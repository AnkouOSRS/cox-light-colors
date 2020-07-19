package com.coxlightcolors;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class CoxLightColorsPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(CoxLightColorsPlugin.class);
		RuneLite.main(args);
	}
}
