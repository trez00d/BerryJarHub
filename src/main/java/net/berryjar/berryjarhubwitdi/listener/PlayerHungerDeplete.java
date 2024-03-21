package net.berryjar.berryjarhubwitdi.listener.join;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class PlayerHungerDeplete implements Listener {

    @EventHandler
    public void onHungerDeplete(FoodLevelChangeEvent event) {

        Entity player = (Player) event.getEntity();
        if (player.getWorld().getName().equals("world")) {

            event.setCancelled(true);

        }
    }
}
