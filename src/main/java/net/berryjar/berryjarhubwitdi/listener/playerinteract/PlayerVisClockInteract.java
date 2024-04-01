package net.berryjar.berryjarhubwitdi.listener.playerinteract;

import net.berryjar.berryjarhubwitdi.BerryJarHubWitDI;
import net.berryjar.berryjarhubwitdi.chat.ChatHandler;
import net.berryjar.berryjarhubwitdi.spawnitems.VisibilityClock;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.UUID;

public class PlayerVisClockInteract implements Listener {

    private final BerryJarHubWitDI plugin;

    public PlayerVisClockInteract(final BerryJarHubWitDI plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onPlayerVisClockInteract(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        UUID u = player.getUniqueId();

        VisibilityClock visClock = new VisibilityClock(plugin);

        if (event.getHand() == EquipmentSlot.HAND) {
            if (player.getInventory().getItemInMainHand().equals(visClock.getVisClock())) {
                if (!(visClock.contains(u))) {
                    visClock.visClockAdd(u);
                    player.sendMessage(ChatHandler.chatPrefix + ChatColor.GREEN + "Players have been hidden.");
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        player.hidePlayer(plugin, p);
                    }
                }
                else if (visClock.contains(u)) {
                    visClock.visClockRemove(u);
                    player.sendMessage(ChatHandler.chatPrefix + ChatColor.GREEN + "Players are now visible.");
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        player.showPlayer(plugin, p);
                    }
                }
            }
        } else if (event.getHand() == EquipmentSlot.OFF_HAND) {
            return;
        }
    }

}
