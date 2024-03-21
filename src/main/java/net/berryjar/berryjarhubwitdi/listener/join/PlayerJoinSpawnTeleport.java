package net.berryjar.berryjarhubwitdi.listener.spawn;

import net.berryjar.berryjarhubwitdi.BerryJarHubWitDI;
import net.berryjar.berryjarhubwitdi.chat.ChatHandler;
import net.berryjar.berryjarhubwitdi.warp.WarpManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinSpawnTeleport implements Listener {

    private final BerryJarHubWitDI plugin;

    public PlayerJoinSpawnTeleport(BerryJarHubWitDI plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void playerJoinSpawnTeleport(PlayerJoinEvent event) {

        WarpManager warpManager = new WarpManager(plugin);
        Player player = event.getPlayer();
        player.teleport(warpManager.getWarp("spawnloc"));
        player.setFallDistance(0);
        player.sendMessage(ChatHandler.chatPrefix + ChatColor.GREEN + "Welcome to the server! We're glad to have you.");
//        Bukkit.getScheduler().scheduleSyncDelayedTask(BerryJarHub.getPlugin(), new Runnable() {
//            @Override
//            public void run() {
//                player.teleport(spawnLoc);
//                player.setFallDistance(0F);
//
//            }
//        },1);

    }

}
