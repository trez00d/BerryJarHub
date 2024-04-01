package net.berryjar.berryjarhubwitdi.spawnitems;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TeleportCompass {

    ItemStack teleportCompass;

    public TeleportCompass() {
        ItemStack teleportCompass = new ItemStack(Material.COMPASS);
        ItemMeta compMeta = teleportCompass.getItemMeta();
        compMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Compass of Teleportation");
        teleportCompass.setItemMeta(compMeta);
        this.teleportCompass = teleportCompass;
    }

    public ItemStack getTeleportCompass() { return teleportCompass; }

}
