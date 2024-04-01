package net.berryjar.berryjarhubwitdi.listener.join;

import net.berryjar.berryjarhubwitdi.BerryJarHubWitDI;
import net.berryjar.berryjarhubwitdi.scoreboard.ScoreboardHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinScoreboard implements Listener {

    private final BerryJarHubWitDI plugin;

    public PlayerJoinScoreboard(final BerryJarHubWitDI plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void playerJoinScoreboardEvent(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        ScoreboardHandler scoreBoardHandler = new ScoreboardHandler(plugin);
        scoreBoardHandler.createScoreboard(player);


    }

}
