package net.berryjar.berryjarhubwitdi.command.subcommand;

import net.berryjar.berryjarhubwitdi.BerryJarHubWitDI;
import net.berryjar.berryjarhubwitdi.chat.ChatHandler;
import net.berryjar.berryjarhubwitdi.command.SubCommand;
import net.berryjar.berryjarhubwitdi.warp.Warp;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class SetWarpCommand extends SubCommand {

    private final BerryJarHubWitDI plugin;

    public SetWarpCommand(final BerryJarHubWitDI plugin) {
        this.plugin = plugin;
    }

    @Override
    public String getName() {
        return "setwarp";
    }

    @Override
    public String getDescription() {
        return "Sets a server warp.";
    }

    @Override
    public String getSyntax() {
        return "/bjhub setwarp <warpID>";
    }

    @Override
    public void perform(Player player, String[] args) {
        if (!(player.hasPermission("bjhub.setwarp"))) {
            player.sendMessage(ChatHandler.chatPrefix + ChatHandler.noPerms);
        } else if (player.hasPermission("bjhub.setwarp")) {
            if (args.length == 1) {
                player.sendMessage(ChatHandler.chatPrefix + ChatHandler.insuffArgs);
            } else if (args.length == 2) {
                Location location = player.getLocation();
                Warp warp = new Warp(args[1], location);
                plugin.warpManager.createWarp(warp);
                player.sendMessage(ChatHandler.chatPrefix + ChatColor.GOLD + "Warp " + args[1] + " created at x: " + location.getX() + ", y: " + location.getY() + ", z: " + location.getZ() + ", pitch: " + location.getPitch() + ", yaw: " + location.getYaw());
            }
        }
    }
}
