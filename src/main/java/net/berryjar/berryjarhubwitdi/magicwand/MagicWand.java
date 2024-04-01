package net.berryjar.berryjarhubwitdi.magicwand;

import net.berryjar.berryjarhubwitdi.BerryJarHubWitDI;
import net.berryjar.berryjarhubwitdi.chat.ChatHandler;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.UUID;

public class MagicWand {

    public ItemStack magicWandStack;


    public MagicWand() {
        ItemStack magicWand = new ItemStack(Material.BLAZE_ROD);
        ItemMeta wandMeta = magicWand.getItemMeta();
        wandMeta.setDisplayName(ChatColor.GOLD + "Region Wand");
        magicWand.setItemMeta(wandMeta);
        magicWandStack = magicWand;
    }

    public ItemStack getMagicWand() { return magicWandStack; }



}
