package net.berryjar.berryjarhubwitdi.listener.blockbreak;

import net.berryjar.berryjarhubwitdi.BerryJarHubWitDI;
import net.berryjar.berryjarhubwitdi.cuboid.Cuboid;
import net.berryjar.berryjarhubwitdi.cuboid.CuboidManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.checkerframework.checker.units.qual.C;

public class PlayerBlockBreakServerSpawn implements Listener {

    private final BerryJarHubWitDI plugin;

    public PlayerBlockBreakServerSpawn(final BerryJarHubWitDI plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerBreakBlockServerSpawn(BlockBreakEvent event) {




        Player player = event.getPlayer();
        CuboidManager regionManager = new CuboidManager(plugin);
        Cuboid region = regionManager.getRegion("spawn");
        if (region.contains(player)) {
            if (region.getAllowBlockBreaking()) {
                if (player.hasPermission("bjhub.regionpermission.serverspawn.allowblockbreaking")) {
                    event.setCancelled(false);
                }
                else if (!(player.hasPermission("bjhub.regionpermission.serverspawn.allowblockbreaking"))) {
                    event.setCancelled(false);
                }

            }
            else {
                if (!(player.hasPermission("bjhub.regionpermission.serverspawn.allowblockbreaking"))) {
                    event.setCancelled(true);
                }
                else if (player.hasPermission("bjhub.regionpermission.serverspawn.allowblockbreaking")) {
                    event.setCancelled(false);
                }
            }
        }
    }

}
