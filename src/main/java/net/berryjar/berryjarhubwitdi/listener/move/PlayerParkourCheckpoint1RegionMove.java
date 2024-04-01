package net.berryjar.berryjarhubwitdi.listener.move;

import net.berryjar.berryjarhubwitdi.BerryJarHubWitDI;
import net.berryjar.berryjarhubwitdi.bank.BankManager;
import net.berryjar.berryjarhubwitdi.chat.ChatHandler;
import net.berryjar.berryjarhubwitdi.cuboid.CuboidManager;
import net.berryjar.berryjarhubwitdi.cuboid.Cuboid;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.checkerframework.checker.units.qual.C;

public class PlayerParkourCheckpoint1RegionMove implements Listener {

    private final BerryJarHubWitDI plugin;

    public PlayerParkourCheckpoint1RegionMove(final BerryJarHubWitDI plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerParkourCheckpoint1RegionMove(PlayerMoveEvent event) {

        CuboidManager regionManager = new CuboidManager(plugin);
        Cuboid parkour1Checkpoint1Region = regionManager.getRegion("parkour1checkpoint1");
        Player player = event.getPlayer();

        if (!(parkour1Checkpoint1Region == null)) {
            if (parkour1Checkpoint1Region.contains(player.getUniqueId())) {
                if (!(plugin.parkourCheckpointRegionMessageList.contains(player.getUniqueId()))) {
                    plugin.parkourCheckpointRegionMessageList.add(player.getUniqueId());
                    player.sendMessage(ChatHandler.chatPrefix + ChatColor.GOLD + "You reached checkpoint 1!");
                    player.sendMessage(ChatHandler.chatPrefix + ChatColor.GOLD + "+10 coins deposited to your account!");
                    player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    BankManager bankManager = new BankManager(plugin);
                    bankManager.deposit(player.getUniqueId(), 10);


                    plugin.parkour1Checkpoint1.add(player.getUniqueId());
                }

            }
        } else {

        }


    }

}
