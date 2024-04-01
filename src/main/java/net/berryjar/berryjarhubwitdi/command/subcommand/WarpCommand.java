package net.berryjar.berryjarhubwitdi.command.subcommand;

import net.berryjar.berryjarhubwitdi.BerryJarHubWitDI;
import net.berryjar.berryjarhubwitdi.chat.ChatHandler;
import net.berryjar.berryjarhubwitdi.command.SubCommand;
import net.berryjar.berryjarhubwitdi.cuboid.Cuboid;
import net.berryjar.berryjarhubwitdi.cuboid.CuboidManager;
import net.berryjar.berryjarhubwitdi.warp.Warp;
import net.berryjar.berryjarhubwitdi.warp.WarpManager;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class WarpCommand extends SubCommand {

    private final BerryJarHubWitDI plugin;

    public WarpCommand(final BerryJarHubWitDI plugin) {
        this.plugin = plugin;
    }
    @Override
    public String getName() {
        return "warp";
    }

    @Override
    public String getDescription() {
        return "Warp to a location.";
    }

    @Override
    public String getSyntax() {
        return "/bjhub warp <warpID>";
    }

    @Override
    public void perform(Player player, String[] args) {
        if (!(player.hasPermission("bjhub.warp"))) {
            player.sendMessage(ChatHandler.chatPrefix + ChatHandler.noPerms);
        } else if (player.hasPermission("bjhub.warp")) {
            if (args.length == 1) {
                player.sendMessage(ChatHandler.chatPrefix + ChatHandler.insuffArgs);
            }
            if (args.length == 2) {
                player.sendMessage("1");
                String warpID = args[1];
                player.sendMessage("2");
                WarpManager warpManager = new WarpManager(plugin);
                player.sendMessage("3");
                if (warpManager.contains(warpID)) {
                    player.sendMessage("4");
                    Warp warp = warpManager.getWarp(warpID);
                    player.sendMessage("5");
                    Location warpLoc = warp.getLocation();
                    player.sendMessage("6");
                    player.teleport(warpLoc);
                    player.sendMessage("7");
                    player.sendMessage(ChatHandler.chatPrefix + ChatColor.GREEN + "You were teleported to " + warpID + ".");
                }
                else if (!(warpManager.contains(warpID))) {
                    player.sendMessage(ChatHandler.chatPrefix + ChatColor.RED + warpID + " don't sound like a place I've ever heard of. They speak English in " + warpID + "?");
                }
//                for (String warpID : plugin.warps.keySet()) {
//                    if (args[1].equalsIgnoreCase(warpID)) {
//                        Location warp = plugin.warps.get(warpID);
//                        player.teleport(warp);
//                        player.sendMessage(ChatHandler.chatPrefix + ChatColor.GREEN + "You were teleported to " + warpID + ", x: " + warp.getX() + ", y: " + warp.getY() + ", z: " + warp.getZ() + ", pitch: " + warp.getPitch() + ", yaw: " + warp.getYaw());
//                    }
//                }
            }
//            if (args.length == 2) {
//                String warpID = args[1];
//                WarpManager warpManager = new WarpManager(plugin);
//                if
////                for (String warpID : plugin.getConfig().getConfigurationSection("warps").getKeys(false)) {
////                    if (args[1].equalsIgnoreCase(warpID)) {
////                        Location warp = plugin.warps.get(warp);
////                        player.teleport(warp);
////                    } else if (!(args[1].equalsIgnoreCase(warpID))) {
////                        player.sendMessage(ChatHandler.chatPrefix + ChatColor.RED + args[1] + " don't sound like a place I ever heard of. They speak English in " + args[1] + "?");
////                    }
////                }
//            }

        }
    }
}
