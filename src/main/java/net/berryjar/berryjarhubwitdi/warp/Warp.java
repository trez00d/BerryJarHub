package net.berryjar.berryjarhubwitdi.warp;

import org.bukkit.Location;

public class Warp {

    Location loc;

    String warpID;

    public Warp(String warpID, Location loc) {
        this.warpID = warpID;
        this.loc = loc;
    }

    public Location getLocation() {
        return loc;
    }

    public String getWarpID() {
        return warpID;
    }

    public void setLocation(Location loc) {
        this.loc = loc;
    }

    public void setWarpID(String warpID) {
        this.warpID = warpID;
    }

}
