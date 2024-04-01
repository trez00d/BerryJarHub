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

public class PlayerSpawnRegionMove implements Listener {

    private final BerryJarHubWitDI plugin;

    public PlayerSpawnRegionMove(final BerryJarHubWitDI plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerSpawnRegionMove(PlayerMoveEvent event) {

        CuboidManager regionManager = new CuboidManager(plugin);
        Cuboid spawnRegion = regionManager.getRegion("spawn");
        Player player = event.getPlayer();

        if (!(spawnRegion == null)) {
            if (!(spawnRegion.contains(player.getUniqueId()))) {
                if (plugin.spawnRegionList.contains(player.getUniqueId())) {
                    plugin.spawnRegionList.remove(player.getUniqueId());
                    player.sendMessage(ChatHandler.chatPrefix + ChatColor.GOLD + "You left the spawn region.");
                }

            } else if (spawnRegion.contains(player.getUniqueId())) {
                if (!(plugin.spawnRegionList.contains(player.getUniqueId()))) {
                    plugin.spawnRegionList.add(player.getUniqueId());
                    player.sendMessage(ChatHandler.chatPrefix + ChatColor.GOLD + "You entered the spawn region.");
                }
            }
        } else {

        }

    }
}
