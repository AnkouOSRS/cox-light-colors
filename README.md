# CoX Light Colors
This plugin allows you to choose custom colors for the light that appears above the loot chest in Chambers of Xeric.
Set custom colors for getting a unique drop, Metamorphic Dust, Twisted Kit, and of course, no special loot at all.
It also allows you to change the color of the barrier used to enter Olm's lair.  

If you find any bugs or would like to request a feature, please do so at the [issues page](https://github.com/AnkouOSRS/cox-light-colors/issues).

### Disclaimer
If you plan on using the "Specific unique" feature for this plugin, the plugin itself will need to be turned on when the drop
 is received. Otherwise it will not recognize whether or not you got one of the specified uniques.
 
![Example image](https://i.imgur.com/Kx3ZM77.png)

### Changelog
- **2/2/26 (1.3.5)**  
Fix issue where a white and unique light would appear at the same time when receiving a unique drop. Fix unique light not clearing properly between raids.
 - **12/22/25 (1.3.4)**  
Replace recoloring logic for the light above the chest to fix an issue where the light would not change colors for some users.
 - **1/1/22 (1.3.3)**  
 Fix an issue where random objects would sometimes get recolored instead of the entrance to olm. Removed the "Experimental" 
 label on the config for groups as this has been confirmed to be working properly since 1.3.2. 
 - **8/20/21 (1.3.2)**  
 Finally fully resolved the issue that was causing the group colors to not work for some players once and for all.
 - **4/17/21 (1.3)**  
 Make several changes to the logic that is used for coloring the light for uniques that are in groups. This should 
 resolve the issue where items in groups were showing the normal unique light for most users. I have marked the feature 
 as "experimental" until I can be sure this is no longer occurring for some users.
 - **8/18/20 (1.2)**    
Add the ability to classify specific uniques into 3 separate groups each with their own color. Add toggles for
 each type of recolor. Other bug fixes.
 - **8/01/20 (1.1)**  
 Fix turning off the plugin so that it properly reverts to the old colors for the light and entrance.
 - **7/29/20**  
 Fix bug relating to the light defaulting to white (e.g. when turning the plugin on after light spawns in)
 - **7/27/20**  
 Update default colors for uniques and the entrance to better match the color without the plugin.
 - **7/22/20**  
 Change specific uniques config to use checkboxes, update logic for what unique was obtained.
 - **7/21/20**  
 Add option to choose specific uniques to get their own color
 - **7/19/20**  
 Initial release
