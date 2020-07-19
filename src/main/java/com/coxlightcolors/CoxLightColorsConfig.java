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

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.*;

@ConfigGroup("coxlightcolors")
public interface CoxLightColorsConfig extends Config
{
	@ConfigItem(
			keyName = "noUnique",
			name = "No Unique",
			description = "Color of light when no unique item is obtained",
			position = 1
	)
	default Color noUnique()
	{
		return Color.WHITE;
	}

	@ConfigItem(
			keyName = "unique",
			name = "Unique",
			description = "Color of light when a unique item is obtained (besides twisted kit or dust)",
			position = 2
	)
	default Color unique()
	{
		return Color.MAGENTA;
	}

	@ConfigItem(
			keyName = "dust",
			name = "Metamorphic Dust",
			description = "Color of light when metamorphic dust is obtained",
			position = 3
	)
	default Color dust()
	{
		return Color.CYAN;
	}

	@ConfigItem(
			keyName = "twistedKit",
			name = "Twisted Kit",
			description = "Color of light when a twisted kit is obtained",
			position = 4
	)
	default Color twistedKit()
	{
		return Color.GREEN;
	}

	@ConfigItem(
			keyName = "olmEntrance",
			name = "Olm Entrance",
			description = "Color of the barrier used to enter the Olm room",
			position = 5
	)
	default Color olmEntrance()
	{
		return Color.GREEN;
	}
}
