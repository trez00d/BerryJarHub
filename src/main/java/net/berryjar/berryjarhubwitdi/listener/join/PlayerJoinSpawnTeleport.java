package net.berryjar.berryjarhubwitdi.listener.join;

import net.berryjar.berryjarhubwitdi.BerryJarHubWitDI;
import net.berryjar.berryjarhubwitdi.chat.ChatHandler;
import net.berryjar.berryjarhubwitdi.warp.Warp;
import net.berryjar.berryjarhubwitdi.warp.WarpManager;
import org.bukkit.ChatColor;
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
        Warp warp = warpManager.getWarp("spawnloc");
        player.teleport(warp.getLocation());
        player.setFallDistance(0);
        player.setHealth(20F);
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
