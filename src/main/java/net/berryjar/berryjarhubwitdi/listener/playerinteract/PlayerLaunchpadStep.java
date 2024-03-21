package net.berryjar.berryjarhubwitdi.listener;

import org.bukkit.Location;
import org.bukkit.Material;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import org.bukkit.util.Vector;

public class PlayerLaunchpadStep implements Listener {

    @EventHandler
    public void onPlayerLaunchpadStepEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        Block blockBelow = player.getLocation().subtract(0, 0, 0).getBlock();

        if (event.getAction() == Action.PHYSICAL) {
            if (blockBelow.getType() == Material.STONE_PRESSURE_PLATE) {
                Location loc = player.getLocation();
                Vector direction = player.getEyeLocation().getDirection();
                Vector product = direction.multiply(2.5);
                player.setVelocity(product);
            }
        }

    }
}
