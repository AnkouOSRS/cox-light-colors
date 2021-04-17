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
import net.runelite.client.config.ConfigSection;

import java.awt.*;

@ConfigGroup("coxlightcolors")
public interface CoxLightColorsConfig extends Config
{
    @ConfigSection(
            name = "Light colors",
            description = "Colors of the lights above the loot chest for different scenarios",
            position = 0
    )
    String colorsSection = "colors";

    @ConfigSection(
            name = "Groups (Experimental)",
            description = "Uniques that, when obtained, will use the 'Specific Unique' color for the light",
            position = 1
    )
    String uniquesSection = "uniques";

    @ConfigSection(
            name = "Toggles",
            description = "Toggle different recolors on or off",
            position = 2,
            closedByDefault = true
    )
    String togglesSection = "toggles";

    @ConfigItem(
            keyName = "standardLoot",
            name = "Standard loot",
            description = "Color of light when no unique item is obtained",
            position = 0,
            section = colorsSection
    )
    default Color standardLoot()
    {
        return Color.WHITE;
    }

    @ConfigItem(
            keyName = "enableStandardLoot",
            name = "Recolor standard loot",
            description = "Enable recoloring the light of the chest when no unique is obtained",
            position = 1,
            section = togglesSection
    )
    default boolean enableStandardLoot()
    {
        return true;
    }

    @ConfigItem(
            keyName = "unique",
            name = "Unique",
            description = "Color of light when a unique item is obtained (besides twisted kit or dust)",
            position = 2,
            section = colorsSection
    )
    default Color unique()
    {
        return Color.decode("#F155F5");
    }

    @ConfigItem(
            keyName = "enableUnique",
            name = "Recolor uniques",
            description = "Enable recoloring the light of the chest when a unique is obtained",
            position = 3,
            section = togglesSection
    )
    default boolean enableUnique()
    {
        return true;
    }

    @ConfigItem(
            keyName = "dust",
            name = "Metamorphic Dust",
            description = "Color of light when metamorphic dust is obtained",
            position = 4,
            section = colorsSection
    )
    default Color dust()
    {
        return Color.CYAN;
    }

    @ConfigItem(
            keyName = "enableDust",
            name = "Recolor dust",
            description = "Enable recoloring the light of the chest when metamorphic dust is obtained",
            position = 5,
            section = togglesSection
    )
    default boolean enableDust()
    {
        return true;
    }

    @ConfigItem(
            keyName = "twistedKit",
            name = "Twisted Kit",
            description = "Color of light when a twisted kit is obtained",
            position = 6,
            section = colorsSection
    )
    default Color twistedKit()
    {
        return Color.GREEN;
    }

    @ConfigItem(
            keyName = "enableKit",
            name = "Recolor Twisted kit",
            description = "Enable recoloring the light of the chest when a twisted kit is obtained",
            position = 7,
            section = togglesSection
    )
    default boolean enableKit()
    {
        return true;
    }

    @ConfigItem(
            keyName = "olmEntrance",
            name = "Olm Entrance",
            description = "Color of the barrier used to enter the Olm room",
            position = 8,
            section = colorsSection
    )
    default Color olmEntrance()
    {
        return Color.decode("#8CFF0B");
    }

    @ConfigItem(
            keyName = "enableEntrance",
            name = "Recolor entance",
            description = "Enable recoloring the entrance barrier to Olm",
            position = 9,
            section = togglesSection
    )
    default boolean enableEntrance()
    {
        return true;
    }

    @ConfigItem(
            keyName = "groupOneColor",
            name = "Group 1",
            description = "Color of the light when an item from group 1 is obtained",
            position = 0,
            section = uniquesSection
    )
    default Color groupOneColor()
    {
        return Color.RED;
    }

    @ConfigItem(
            keyName = "groupTwoColor",
            name = "Group 2",
            description = "Color of the light when an item from group 2 is obtained",
            position = 1,
            section = uniquesSection
    )
    default Color groupTwoColor()
    {
        return Color.BLUE;
    }

    @ConfigItem(
            keyName = "groupThreeColor",
            name = "Group 3",
            description = "Color of the light when an item from group 3 is obtained",
            position = 2,
            section = uniquesSection
    )
    default Color groupThreeColor()
    {
        return Color.YELLOW;
    }

    @ConfigItem(
            keyName = "groupTwistedBow",
            name = "Twisted bow",
            description = "Group color to use when this item is obtained. If no group is specified, the 'unique' color will be used",
            position = 3,
            section = uniquesSection
    )
    default ItemGroup groupTwistedBow()
    {
        return ItemGroup.NONE;
    }

    @ConfigItem(
            keyName = "groupKodai",
            name = "Kodai insignia",
            description = "Group color to use when this item is obtained. If no group is specified, the 'unique' color will be used",
            position = 4,
            section = uniquesSection
    )
    default ItemGroup groupKodai()
    {
        return ItemGroup.NONE;
    }

    @ConfigItem(
            keyName = "groupElderMaul",
            name = "Elder maul",
            description = "Group color to use when this item is obtained. If no group is specified, the 'unique' color will be used",
            position = 5,
            section = uniquesSection
    )
    default ItemGroup groupElderMaul()
    {
        return ItemGroup.NONE;
    }

    @ConfigItem(
            keyName = "groupClaws",
            name = "Dragon claws",
            description = "Group color to use when this item is obtained. If no group is specified, the 'unique' color will be used",
            position = 6,
            section = uniquesSection
    )
    default ItemGroup groupClaws()
    {
        return ItemGroup.NONE;
    }

    @ConfigItem(
            keyName = "groupAncestralHat",
            name = "Ancestral hat",
            description = "Group color to use when this item is obtained. If no group is specified, the 'unique' color will be used",
            position = 7,
            section = uniquesSection
    )
    default ItemGroup groupAncestralHat()
    {
        return ItemGroup.NONE;
    }

    @ConfigItem(
            keyName = "groupAncestralTop",
            name = "Ancestral robe top",
            description = "Group color to use when this item is obtained. If no group is specified, the 'unique' color will be used",
            position = 8,
            section = uniquesSection
    )
    default ItemGroup groupAncestralTop()
    {
        return ItemGroup.NONE;
    }

    @ConfigItem(
            keyName = "groupAncestralBottom",
            name = "Ancestral robe bottom",
            description = "Group color to use when this item is obtained. If no group is specified, the 'unique' color will be used",
            position = 9,
            section = uniquesSection
    )
    default ItemGroup groupAncestralBottom()
    {
        return ItemGroup.NONE;
    }

    @ConfigItem(
            keyName = "groupDinhs",
            name = "Dinh's bulwark",
            description = "Group color to use when this item is obtained. If no group is specified, the 'unique' color will be used",
            position = 10,
            section = uniquesSection
    )
    default ItemGroup groupDinhs()
    {
        return ItemGroup.NONE;
    }

    @ConfigItem(
            keyName = "groupDHCB",
            name = "Dragon hunter crossbow",
            description = "Group color to use when this item is obtained. If no group is specified, the 'unique' color will be used",
            position = 11,
            section = uniquesSection
    )
    default ItemGroup groupDHCB()
    {
        return ItemGroup.NONE;
    }

    @ConfigItem(
            keyName = "groupBuckler",
            name = "Twisted buckler",
            description = "Group color to use when this item is obtained. If no group is specified, the 'unique' color will be used",
            position = 12,
            section = uniquesSection
    )
    default ItemGroup groupBuckler()
    {
        return ItemGroup.NONE;
    }

    @ConfigItem(
            keyName = "groupArcane",
            name = "Arcane prayer scroll",
            description = "Group color to use when this item is obtained. If no group is specified, the 'unique' color will be used",
            position = 13,
            section = uniquesSection
    )
    default ItemGroup groupArcane()
    {
        return ItemGroup.NONE;
    }

    @ConfigItem(
            keyName = "groupDex",
            name = "Dexterous prayer scroll",
            description = "Group color to use when this item is obtained. If no group is specified, the 'unique' color will be used",
            position = 14,
            section = uniquesSection
    )
    default ItemGroup groupDex()
    {
        return ItemGroup.NONE;
    }

    @ConfigItem(
            keyName = "enableGroupOne",
            name = "Recolor group 1",
            description = "Enable recoloring the light of the chest when a unique from group 1 is obtained",
            position = 15,
            section = uniquesSection
    )
    default boolean enableGroupOne()
    {
        return true;
    }

    @ConfigItem(
            keyName = "enableGroupTwo",
            name = "Recolor group 2",
            description = "Enable recoloring the light of the chest when a unique from group 2 is obtained",
            position = 16,
            section = uniquesSection
    )
    default boolean enableGroupTwo()
    {
        return true;
    }

    @ConfigItem(
            keyName = "enableGroupThree",
            name = "Recolor group 3",
            description = "Enable recoloring the light of the chest when a unique from group 3 is obtained",
            position = 17,
            section = uniquesSection
    )
    default boolean enableGroupThree()
    {
        return true;
    }
}
