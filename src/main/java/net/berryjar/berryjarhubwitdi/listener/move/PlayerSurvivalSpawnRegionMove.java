package net.berryjar.berryjarhubwitdi.listener.move;

import net.berryjar.berryjarhubwitdi.BerryJarHubWitDI;
import net.berryjar.berryjarhubwitdi.chat.ChatHandler;
import net.berryjar.berryjarhubwitdi.cuboid.CuboidManager;
import net.berryjar.berryjarhubwitdi.cuboid.Cuboid;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerSurvivalSpawnRegionMove implements Listener {

    private final BerryJarHubWitDI plugin;

    public PlayerSurvivalSpawnRegionMove(final BerryJarHubWitDI plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerSurvivalSpawnRegionMove(PlayerMoveEvent event) {

        CuboidManager regionManager = new CuboidManager(plugin);
        Cuboid spawnRegion = regionManager.getRegion("survivalspawn");
        Player player = event.getPlayer();

        if (!(spawnRegion == null)) {
            if (!(spawnRegion.contains(player.getUniqueId()))) {
                if (plugin.survivalSpawnRegionList.contains(player.getUniqueId())) {
                    plugin.survivalSpawnRegionList.remove(player.getUniqueId());
                    player.sendMessage(ChatHandler.chatPrefix + ChatColor.GOLD + "You left the survival spawn region. Be careful out there.");
                }

            } else if (spawnRegion.contains(player.getUniqueId())) {
                if (!(plugin.survivalSpawnRegionList.contains(player.getUniqueId()))) {
                    plugin.survivalSpawnRegionList.add(player.getUniqueId());
                    player.sendMessage(ChatHandler.chatPrefix + ChatColor.GOLD + "You entered the spawn region. You're safe for now.");
                }
            }
        } else {

        }


    }

}
