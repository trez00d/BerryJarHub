package net.berryjar.berryjarhubwitdi.listener.join;

import net.berryjar.berryjarhubwitdi.BerryJarHubWitDI;
import net.berryjar.berryjarhubwitdi.config.ConfigManager;
import net.berryjar.berryjarhubwitdi.player.BerryJarHubPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class PlayerJoinSetCoin implements Listener {

    private final BerryJarHubWitDI plugin;

    public PlayerJoinSetCoin(final BerryJarHubWitDI plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoinCreateConfigEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        UUID u = player.getUniqueId();
        BerryJarHubPlayer jarPlayer = new BerryJarHubPlayer(player);
        plugin.jarPlayers.add(jarPlayer);


        ConfigManager config = new ConfigManager(u);
        config.getBankConfig().set("coins", 0);
        config.saveBankConfig();

    }

}
