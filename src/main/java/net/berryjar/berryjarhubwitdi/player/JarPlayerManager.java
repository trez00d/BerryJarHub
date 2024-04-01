package net.berryjar.berryjarhubwitdi.player;

import net.berryjar.berryjarhubwitdi.BerryJarHubWitDI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class JarPlayerManager {

    private final BerryJarHubWitDI plugin;

    public JarPlayerManager(final BerryJarHubWitDI plugin) {
        this.plugin = plugin;
    }


    public UUID getPlayerUUID(Player player) {
        for (BerryJarHubPlayer p : plugin.jarPlayers) {
            if (p.getPlayer() == player) {
                return p.getUUID();
            }
        }
        return null;
    }

    public BerryJarHubPlayer getPlayerFromUUID(UUID u) {
        for (BerryJarHubPlayer p : plugin.jarPlayers) {
            if (p.getUUID() == u) {
                return p;
            }
        }
        return null;
    }

    public BerryJarHubPlayer getJarPlayer(Player player) {
        for (BerryJarHubPlayer p : plugin.jarPlayers) {
            if (p.getPlayer() == player) {
                return p;
            }
        }
        return null;
    }

    public BerryJarHubPlayer getCraftPlayer(Player player) {
        for (BerryJarHubPlayer p : plugin.jarPlayers) {
            if (p.getPlayer() == player) {
                return p;
            }
        }
        return null;
    }

    public int getParkourAttempts(Player player) {

        for (BerryJarHubPlayer p : plugin.jarPlayers) {
            if (p.getPlayer() == player) {
                return p.getParkourAttempts();
            }
        }
        return 0;
    }

    public void incrementParkourAttempts(BerryJarHubPlayer jarPlayer) {
        int attempts = jarPlayer.getParkourAttempts();
        attempts++;
        jarPlayer.setParkourAttempts(attempts);

    }

}
