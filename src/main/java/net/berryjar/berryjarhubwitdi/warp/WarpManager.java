package net.berryjar.berryjarhubwitdi.warp;

import net.berryjar.berryjarhubwitdi.BerryJarHubWitDI;
import net.berryjar.berryjarhubwitdi.cuboid.Cuboid;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class WarpManager {

    private WarpBuilder builder = new WarpBuilder();
    private final BerryJarHubWitDI plugin;

    public WarpManager(final BerryJarHubWitDI plugin) {
        this.plugin = plugin;
    }

    public boolean contains(Warp warp) {
        return plugin.warps.contains(warp);
    }
    public boolean contains(String warpID) {
        for (Warp w : plugin.warps) {
            if (w.getWarpID().equals(warpID)) {
                return true;
            }
        }
        return false;
    }
    public void createWarp(Warp warp) {
        String warpID = warp.getWarpID();
        Location location = warp.getLocation();
        plugin.getConfig().set("warps." + warpID + ".world", location.getWorld().getName());
        plugin.getConfig().set("warps." + warpID + ".x", location.getX());
        plugin.getConfig().set("warps." + warpID + ".y", location.getY());
        plugin.getConfig().set("warps." + warpID + ".z", location.getZ());
        plugin.getConfig().set("warps." + warpID + ".pitch", location.getPitch());
        plugin.getConfig().set("warps." + warpID + ".yaw", location.getYaw());
        plugin.saveConfig();
        plugin.warps.add(warp);

    }

    public Warp getWarp(String warpID) {
        for (Warp warp : plugin.warps) {
            if (warp.getWarpID().equals(warpID)) {
                return warp;
            }
        }
        return null;
    }

    public void loadWarps() {

        if (plugin.getConfig().getConfigurationSection("warps") == null) {
            System.out.println("No warps detected. Continuing.");
        } else for (String warpID : plugin.getConfig().getConfigurationSection("warps").getKeys(false)) {
            for (String atts : plugin.getConfig().getConfigurationSection("warps." + warpID).getKeys(false)) {
                System.out.println(warpID + atts);
                String world = plugin.getConfig().getString("warps." + warpID + ".world");
                double x = plugin.getConfig().getDouble("warps." + warpID + ".x");
                System.out.println(x);
                double y = plugin.getConfig().getDouble("warps." + warpID + ".y");
                System.out.println(y);
                double z = plugin.getConfig().getDouble("warps." + warpID + ".z");
                System.out.println(z);
                float pitch = (float) plugin.getConfig().getDouble("warps." + warpID + ".pitch");
                float yaw = (float) plugin.getConfig().getDouble("warps." + warpID + ".yaw");

                builder.setWorld(world);
                builder.setRegionID(warpID);
                builder.setX1(x);
                builder.setY1(y);
                builder.setZ1(z);
                builder.setPitch(pitch);
                builder.setYaw(yaw);
                break;
            }
            String world = builder.getWorld();
            String wID = builder.getWarpIDID();
            double x = builder.getX();
            System.out.println(x);
            double y = builder.getY();
            System.out.println(y);
            double z = builder.getZ();
            System.out.println(z);
            float pitch = builder.getPitch();
            float yaw = builder.getYaw();
            World worldLoc = Bukkit.getWorld(world);
            Location loc = new Location(worldLoc, x, y, z, yaw, pitch);
            Warp warp = new Warp(wID, loc);
            plugin.warps.add(warp);
        }

    }
}
