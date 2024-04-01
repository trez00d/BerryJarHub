package net.berryjar.berryjarhubwitdi.listener.move;

import net.berryjar.berryjarhubwitdi.BerryJarHubWitDI;
import net.berryjar.berryjarhubwitdi.chat.ChatHandler;
import net.berryjar.berryjarhubwitdi.cuboid.Cuboid;
import net.berryjar.berryjarhubwitdi.cuboid.CuboidManager;
import net.berryjar.berryjarhubwitdi.player.BerryJarHubPlayer;
import net.berryjar.berryjarhubwitdi.warp.Warp;
import net.berryjar.berryjarhubwitdi.warp.WarpManager;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerParkourVoidMove implements Listener {

    private final BerryJarHubWitDI plugin;

    public PlayerParkourVoidMove(final BerryJarHubWitDI plugin) {
        this.plugin = plugin;
    }

    int i = 0;
    @EventHandler
    public void onPlayerParkourVoidMove(PlayerMoveEvent event) {

        CuboidManager regionManager = new CuboidManager(plugin);
        Cuboid parkourVoidRegion = regionManager.getRegion("parkour1void");
        Player player = event.getPlayer();
        BerryJarHubPlayer jarPlayer = plugin.jarPlayerManager.getJarPlayer(player);

        if (!(parkourVoidRegion == null)) {
            if (!(parkourVoidRegion.contains(player.getUniqueId()))) {
                plugin.parkourVoidRegionList.remove(player.getUniqueId());

            } else if (parkourVoidRegion.contains(player.getUniqueId())) {
                if (!(plugin.parkourVoidRegionList.contains(player.getUniqueId()))) {
                    if (!plugin.parkour1Checkpoint1.contains(player.getUniqueId())) {
                        plugin.parkourVoidRegionList.add(player.getUniqueId());

                        jarPlayer.incrementParkourAttempts();
                        player.sendMessage(ChatHandler.chatPrefix + ChatColor.RED + "FAIL!");
                        player.sendMessage(ChatHandler.chatPrefix + ChatColor.RED + "Attempts: " + jarPlayer.getParkourAttempts());

                        WarpManager warpManager = new WarpManager(plugin);
                        Warp parkourSpawn = warpManager.getWarp("parkourspawn");
                        Location parkourSpawnLoc = parkourSpawn.getLocation();
                        player.teleport(parkourSpawnLoc);
                        player.setFallDistance(0F);
                        plugin.parkourVoidRegionList.remove(player.getUniqueId());
                    } else {
                        plugin.parkourVoidRegionList.add(player.getUniqueId());
                        jarPlayer.incrementParkourAttempts();
                        player.sendMessage(ChatHandler.chatPrefix + ChatColor.RED + "FAIL!");
                        player.sendMessage(ChatHandler.chatPrefix + ChatColor.RED + "Attempts: " + jarPlayer.getParkourAttempts());
                        player.teleport(new Location(parkourVoidRegion.getWorld(), 70, -27, -237, -90, 0));
                        player.setFallDistance(0F);
                    }

                }

            }
        } else {

        }

    }
//
//    private void incrementAttempts() {
//        i++;
//    }
//
//    private int getAttempts() {
//        return i;
//    }

}
