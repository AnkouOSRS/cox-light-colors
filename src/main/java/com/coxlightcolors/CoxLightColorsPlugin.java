/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.coxlightcolors;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.*;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;

import javax.inject.Inject;
import java.awt.*;

@PluginDescriptor(
		name = "CoX Light Colors",
		description = "Set the colors of the light above the loot chest in Chambers of Xeric",
		tags = {"bosses", "combat", "pve", "raid"}
)
@Slf4j
public class CoxLightColorsPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private CoxLightColorsConfig config;

	private GameObject lightObject;
	private GameObject entranceObject;
	private String uniqueItemReceived;

	private static final int LIGHT_OBJECT_ID = 28848;
	private static final int OLM_ENTRANCE_ID = 29879;
	private static final int VARBIT_LIGHT_TYPE = 5456;

	private static int currentLightType; // Default (0), Unique (1), Dust (2), Twisted Kit (3)

	@Provides
	CoxLightColorsConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CoxLightColorsConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{

	}

	@Override
	protected void shutDown() throws Exception
	{
		lightObject = null;
		entranceObject = null;
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged varbitChanged)
	{
		currentLightType = client.getVarbitValue(VARBIT_LIGHT_TYPE);
		if (lightObject != null)
		{
			recolorAllFaces(lightObject.getRenderable().getModel(),
					(dropOptainedIsSpecial() ? config.specificUniqueColor() : getNewLightColor()));
		}
		if (client.getVar(Varbits.IN_RAID) != 1)
		{
			uniqueItemReceived = null;
			lightObject = null;
			entranceObject = null;
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage) {
		if (client.getLocalPlayer() == null || client.getLocalPlayer().getName() == null)
			return;

		String message = Text.removeTags(chatMessage.getMessage());

		if (chatMessage.getType() == ChatMessageType.FRIENDSCHATNOTIFICATION
				&& message.startsWith(client.getLocalPlayer().getName() + " - "))
		{
			uniqueItemReceived = message.split(" - ")[1];

			if (lightObject != null)
			{
				recolorAllFaces(lightObject.getRenderable().getModel(),
						(dropOptainedIsSpecial() ? config.specificUniqueColor() : getNewLightColor()));
			}
		}
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		GameObject obj = event.getGameObject();
		if (obj.getId() == LIGHT_OBJECT_ID)
		{
			lightObject = obj;
			recolorAllFaces(lightObject.getRenderable().getModel(),
					(dropOptainedIsSpecial() ? config.specificUniqueColor() : getNewLightColor()));
		}
		else if (obj.getId() == OLM_ENTRANCE_ID)
		{
			entranceObject = obj;
			recolorAllFaces(obj.getRenderable().getModel(), config.olmEntrance());
		}
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		if (event.getGameObject().getId() == LIGHT_OBJECT_ID)
		{
			lightObject = null;
		}
		else if (event.getGameObject().getId() == OLM_ENTRANCE_ID)
		{
			entranceObject = null;
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (lightObject != null)
		{
			recolorAllFaces(lightObject.getRenderable().getModel(),
					(dropOptainedIsSpecial() ? config.specificUniqueColor() : getNewLightColor()));
		}
		if (entranceObject != null)
		{
			recolorAllFaces(entranceObject.getRenderable().getModel(), config.olmEntrance());
		}
	}

	private boolean dropOptainedIsSpecial()
	{
		String[] specifiedItems = config.specificUniqueNames().split(",");
		if (uniqueItemReceived != null && !uniqueItemReceived.isEmpty())
		{
			for (String specifiedItem : specifiedItems) {
				if (specifiedItem.trim().toLowerCase().equals(uniqueItemReceived.toLowerCase()))
				{
					return true;
				}
			}
		}
		return false;
	}

	private Color getNewLightColor() {
		switch (currentLightType) {
			case 2:
				return config.unique();
			case 3:
				return config.dust();
			case 4:
				return config.twistedKit();
			default:
				return config.noUnique();
		}
	}

	private void recolorAllFaces(Model model, Color color)
	{
		if (model == null)
			return;
		int rs2hsb = colorToRs2hsb(color);
		int[] faceColors1 = model.getFaceColors1();
		int[] faceColors2 = model.getFaceColors2();
		int[] faceColors3 = model.getFaceColors3();

		if (faceColors1 != null && faceColors1.length > 0)
		{
			for (int i = 0; i < faceColors1.length; i++)
			{
				faceColors1[i] = rs2hsb;
			}
		}
		if (faceColors2 != null && faceColors2.length > 0)
		{
			for (int i = 0; i < faceColors2.length; i++)
			{
				faceColors2[i] = rs2hsb;
			}
		}
		if (faceColors3 != null && faceColors3.length > 0)
		{
			for (int i = 0; i < faceColors3.length; i++)
			{
				faceColors3[i] = rs2hsb;
			}
		}
	}

	private int colorToRs2hsb(Color color)
	{
		float[] hsbVals = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);

		// "Correct" the brightness level to avoid going to white at full saturation, or having a low brightness at
		// low saturation
		hsbVals[2] -= Math.min(hsbVals[1], hsbVals[2] / 2);

		int encode_hue = (int)(hsbVals[0] * 63);
		int encode_saturation = (int)(hsbVals[1] * 7);
		int encode_brightness = (int)(hsbVals[2] * 127);
		return (encode_hue << 10) + (encode_saturation << 7) + (encode_brightness);
	}
}
