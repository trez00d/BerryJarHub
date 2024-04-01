package net.berryjar.berryjarhubwitdi.listener.playerinteract;

import net.berryjar.berryjarhubwitdi.BerryJarHubWitDI;
import net.berryjar.berryjarhubwitdi.menus.TeleCompassMenu;
import net.berryjar.berryjarhubwitdi.spawnitems.TeleportCompass;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerTeleCompassInteract implements Listener {


    private final BerryJarHubWitDI plugin;

    public PlayerTeleCompassInteract(final BerryJarHubWitDI plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerTeleCompassInteract(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        TeleportCompass teleCompass = new TeleportCompass();

        if (player.getInventory().getItemInMainHand().equals(teleCompass.getTeleportCompass())) {
            TeleCompassMenu teleCompassMenu = new TeleCompassMenu(plugin);
            teleCompassMenu.displayMenu(player);
        }

    }

}
