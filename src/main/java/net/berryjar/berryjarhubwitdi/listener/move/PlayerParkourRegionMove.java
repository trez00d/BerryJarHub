package net.berryjar.berryjarhubwitdi.listener.move;

import net.berryjar.berryjarhubwitdi.BerryJarHubWitDI;
import net.berryjar.berryjarhubwitdi.cuboid.Cuboid;
import net.berryjar.berryjarhubwitdi.cuboid.CuboidManager;
import net.berryjar.berryjarhubwitdi.chat.ChatHandler;
import net.berryjar.berryjarhubwitdi.player.BerryJarHubPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.logging.Level;

public class PlayerParkourRegionMove implements Listener {

    private final BerryJarHubWitDI plugin;

    public PlayerParkourRegionMove(final BerryJarHubWitDI plugin) {
        this.plugin = plugin;
    }

    int attempts;

    @EventHandler
    public void onPlayerParkourRegionMove(PlayerMoveEvent event) {

        CuboidManager regionManager = new CuboidManager(plugin);
        Cuboid parkourRegion = regionManager.getRegion("parkour1");
        Player player = event.getPlayer();

        if (!(parkourRegion == null)) {
            if (!(parkourRegion.contains(player.getUniqueId()))) {
                if (plugin.parkourRegionList.contains(player.getUniqueId())) {
                    BerryJarHubPlayer jarPlayer = plugin.jarPlayerManager.getJarPlayer(player);
                    if (!(jarPlayer == null)) {
                        jarPlayer.clearParkourAttempts();
                    } else {
                        Bukkit.getServer().getLogger().log(Level.WARNING, "Player " + player.getName() + " has lost their JarPlayer instance.");
                        player.sendMessage(ChatHandler.chatPrefix + ChatColor.DARK_RED + "It looks like you lost your JarPlayer instance. Your stats will not be recorded until you reconnect.");
                    }
                    plugin.parkourRegionList.remove(player.getUniqueId());
                    player.sendMessage(ChatHandler.chatPrefix + ChatColor.GOLD + "You left the parkour region.");
                    plugin.parkourAttempts.remove(player.getUniqueId());
                    plugin.parkour1Checkpoint1.remove(player.getUniqueId());
                    plugin.parkourCheckpointRegionMessageList.remove(player.getUniqueId());

                }

            } else if (parkourRegion.contains(player.getUniqueId())) {
                if (!(plugin.parkourRegionList.contains(player.getUniqueId()))) {
                    plugin.parkourRegionList.add(player.getUniqueId());
                    player.sendMessage(ChatHandler.chatPrefix + ChatColor.GOLD + "You entered the parkour region.");
                    plugin.parkourAttempts.remove(player.getUniqueId());
                    plugin.parkour1Checkpoint1.remove(player.getUniqueId());
                }
            }
        } else {

        }


    }
}
