package net.berryjar.berryjarhubwitdi.listener.leave;

import net.berryjar.berryjarhubwitdi.BerryJarHubWitDI;
import net.berryjar.berryjarhubwitdi.bank.BankManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class PlayerLeaveSaveBankConfig implements Listener {

    private final BerryJarHubWitDI plugin;

    public PlayerLeaveSaveBankConfig(final BerryJarHubWitDI plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerLeaveSaveBankConfig(PlayerQuitEvent event) {

        for (Player p : Bukkit.getOnlinePlayers()) {
            UUID u = p.getUniqueId();
            BankManager bankManager = new BankManager(plugin);
            bankManager.saveBank(u);
        }

    }

}
