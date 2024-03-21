package net.berryjar.berryjarhubwitdi.listener.leave;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.UUID;

public class PlayerLeaveEvent implements Listener {

    @EventHandler
    public void onPlayerLeaveSaveBankConfig(PlayerLeaveEvent event) {

        for (Player p : Bukkit.getOnlinePlayers()) {
            UUID u = p.getUniqueId();
            bankManager.saveBank(u);
        }

    }

}
