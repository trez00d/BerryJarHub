package net.berryjar.berryjarhubwitdi.listener.playerinteract;

import net.berryjar.berryjarhubwitdi.BerryJarHubWitDI;
import net.berryjar.berryjarhubwitdi.cuboid.Cuboid;
import net.berryjar.berryjarhubwitdi.cuboid.CuboidManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

public class PlayerLaunchpadStep implements Listener {

    private final BerryJarHubWitDI plugin;

    public PlayerLaunchpadStep(final BerryJarHubWitDI plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerLaunchpadLapisWalkEvent(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Block blockBelowPlate = player.getLocation().getBlock();
        Block blockBelowModifier = player.getLocation().subtract(0, 1, 0).getBlock();
        CuboidManager regionManager = new CuboidManager(plugin);
        Cuboid spawnRegion = regionManager.getRegion("spawn");
        if (spawnRegion.contains(player.getUniqueId())) {
            if (blockBelowPlate.getType() == Material.STONE_PRESSURE_PLATE && blockBelowModifier.getType() == Material.LAPIS_BLOCK) {
//                scheduleLaunchpadLapisVectorStepTask(player);
                Vector loc = player.getEyeLocation().getDirection();
                Vector vec = new Vector(loc.getX(), 1, loc.getZ());
//                Vector direction = player.getEyeLocation().getDirection().subtract(vec);
                Vector product = vec.multiply(0.75);
                player.setVelocity(product);
            }
        }
    }

    @EventHandler
    public void onPlayerLaunchpadIronWalkEvent(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Block blockBelowPlate = player.getLocation().getBlock();
        Block blockBelowModifier = player.getLocation().subtract(0, 1, 0).getBlock();
        CuboidManager regionManager = new CuboidManager(plugin);
        Cuboid spawnRegion = regionManager.getRegion("spawn");
        if (spawnRegion.contains(player.getUniqueId())) {
            if (blockBelowPlate.getType() == Material.STONE_PRESSURE_PLATE && blockBelowModifier.getType() == Material.IRON_BLOCK) {
                scheduleLaunchpadIronVectorStepTask(player);
            }
        }
    }

    @EventHandler
    public void onPlayerLaunchpadRedstoneWalkEvent(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Block blockBelowPlate = player.getLocation().getBlock();
        Block blockBelowModifier = player.getLocation().subtract(0, 1, 0).getBlock();
        CuboidManager regionManager = new CuboidManager(plugin);
        Cuboid spawnRegion = regionManager.getRegion("spawn");
        if (spawnRegion.contains(player.getUniqueId())) {
            if (blockBelowPlate.getType() == Material.STONE_PRESSURE_PLATE && blockBelowModifier.getType() == Material.REDSTONE_BLOCK) {
                scheduleLaunchpadRedstoneVectorStepTask(player);
            }
        }
    }

    public static int iIron = 10;

    public void scheduleLaunchpadIronVectorStepTask(Player player) {

        BukkitTask task = new BukkitRunnable() {

            int i = 0;
            Vector direction = player.getEyeLocation().getDirection();

            @Override
            public void run() {
                i++;
                Location loc = player.getLocation();
                Vector vec = player.getEyeLocation().getDirection();
                Vector product = direction.multiply(2.0);
                direction = product;
                player.setVelocity(product);
                if (i == 10) {
                    this.cancel();
                }
            }
        }.runTaskTimer(plugin, 0, 1);

    }


    public static int iDiamond = 10;

    public void scheduleLaunchpadRedstoneVectorStepTask(Player player) {

        BukkitTask task = new BukkitRunnable() {

            int i = 0;

            @Override
            public void run() {
                i++;
                Location loc = player.getLocation();
                Vector direction = player.getEyeLocation().getDirection();
                Vector product = direction.multiply(2.0);
                player.setVelocity(product);
                if (i == 10) {
                    this.cancel();
                }
            }
        }.runTaskTimer(plugin, 0, 1);

    }

    public void scheduleLaunchpadLapisVectorStepTask(Player player) {

        BukkitTask task = new BukkitRunnable() {

            int i = 0;

            @Override
            public void run() {
                i++;
                Vector vec = new Vector(1, 1, 1);
//                Vector direction = player.getEyeLocation().getDirection().subtract(vec);
//                Vector product = direction.multiply(1.3);
                player.setVelocity(vec);
                if (i == 10) {
                    this.cancel();
                }
            }
        }.runTaskTimer(plugin, 0, 1);

    }
}
