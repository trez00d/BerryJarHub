package net.berryjar.berryjarhubwitdi.listener.join;

import net.berryjar.berryjarhubwitdi.BerryJarHubWitDI;
import net.berryjar.berryjarhubwitdi.spawnitems.TeleportCompass;
import net.berryjar.berryjarhubwitdi.spawnitems.VisibilityClock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerJoinGiveItems implements Listener {

    private final BerryJarHubWitDI plugin;

    public PlayerJoinGiveItems(final BerryJarHubWitDI plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void playerJoinGiveItemsEvent(PlayerJoinEvent event) {
        System.out.println("giveitemtest");
        Player player = event.getPlayer();
        VisibilityClock visClock = new VisibilityClock(plugin);
        ItemStack clock = visClock.getVisClock();
        TeleportCompass teleCompass = new TeleportCompass();
        ItemStack comp = teleCompass.getTeleportCompass();
        player.getInventory().setItem(8, clock);
        player.getInventory().setItem(0, comp);

    }

}
