package net.berryjar.berryjarhubwitdi.listener.playerinteract;

import net.berryjar.berryjarhubwitdi.BerryJarHubWitDI;
import net.berryjar.berryjarhubwitdi.chat.ChatHandler;
import net.berryjar.berryjarhubwitdi.magicwand.MagicWand;
import net.berryjar.berryjarhubwitdi.magicwand.WandManager;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class PlayerWandInteract implements Listener {

    private final BerryJarHubWitDI plugin;

    public PlayerWandInteract(final BerryJarHubWitDI plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerWandInteractEvent(PlayerInteractEvent event) {
        Action leftClick = event.getAction();
        Action rightClick = event.getAction();

        Player player = event.getPlayer();
        WandManager wandManager = new WandManager(plugin);
        MagicWand magicWand = new MagicWand();
        if (wandManager.isPlayerPrimed(player)) {
            if (leftClick.equals(Action.LEFT_CLICK_BLOCK)) {
                if (event.getHand() == EquipmentSlot.HAND) {
                    ItemStack mWand = magicWand.getMagicWand();
                    if (player.getInventory().getItemInMainHand().isSimilar(mWand)) {
                        event.setCancelled(true);
                        Location blockLoc1 = event.getClickedBlock().getLocation();
                        wandManager.setPositionA(blockLoc1);
                        player.sendMessage(ChatHandler.chatPrefix + ChatColor.LIGHT_PURPLE + "Location 1 set to world: " + blockLoc1.getWorld().getName() + ", X: " + blockLoc1.getBlockX() + ", Y: " + blockLoc1.getBlockY() + ", Z: " + blockLoc1.getBlockZ() + ".");
                    } else {
                        event.setCancelled(false);
                    }
                }
            } else if (rightClick.equals(Action.RIGHT_CLICK_BLOCK)) {
                if (event.getHand() == EquipmentSlot.HAND) {
                    ItemStack mWand = magicWand.getMagicWand();
                    if (player.getInventory().getItemInMainHand().isSimilar(mWand)) {
                        event.setCancelled(true);
                        Location blockLoc2 = event.getClickedBlock().getLocation();
                        wandManager.setPositionB(blockLoc2);
                        player.sendMessage(ChatHandler.chatPrefix + ChatColor.LIGHT_PURPLE + "Location 2 set to world: " + blockLoc2.getWorld().getName() + ", X: " + blockLoc2.getBlockX() + ", Y: " + blockLoc2.getBlockY() + ", Z: " + blockLoc2.getBlockZ() + ".");
                    } else {
                        event.setCancelled(false);
                    }
                }
            }
        } else if (!(wandManager.isPlayerPrimed(player))) {
            event.setCancelled(false);
        }

    }
}
