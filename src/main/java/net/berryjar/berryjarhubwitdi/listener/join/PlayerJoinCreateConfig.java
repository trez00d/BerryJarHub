package net.berryjar.berryjarhubwitdi.listener;

import net.berryjar.berryjarhubwitdi.config.ConfigManager;
import net.berryjar.berryjarhubwitdi.player.BerryJarHubPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class PlayerJoinCreateConfig implements Listener {

    @EventHandler
    public void onPlayerJoinCreateConfigEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        UUID u = player.getUniqueId();
        BerryJarHubPlayer jarPlayer = new BerryJarHubPlayer(player);

        ConfigManager config = new ConfigManager(u);
        if (config.getBankConfig() == null) {
            config.createFile();
            config.saveBankConfig();
        }

    }

}
