package net.berryjar.berryjarhubwitdi.spawnitems;

import net.berryjar.berryjarhubwitdi.BerryJarHubWitDI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashSet;
import java.util.UUID;

public class VisibilityClock {

    ItemStack visClock;
    private final BerryJarHubWitDI plugin;

    public VisibilityClock(final BerryJarHubWitDI plugin) {
        this.plugin = plugin;
        ItemStack visClock = new ItemStack(Material.CLOCK);
        ItemMeta clockMeta = visClock.getItemMeta();
        clockMeta.setDisplayName(ChatColor.GOLD + "Visibility Clock");
        visClock.setItemMeta(clockMeta);
        this.visClock = visClock;
    }

    public void visClockAdd(UUID u) {
        plugin.visClockToggle.add(u);
    }
    public void visClockRemove(UUID u) {
        plugin.visClockToggle.remove(u);
    }

    public HashSet<UUID> getClockSet() {
        return plugin.visClockToggle;
    }

    public boolean contains(UUID u) {
        return plugin.visClockToggle.contains(u);
    }

    public ItemStack getVisClock() {
        return visClock;
    }

}
