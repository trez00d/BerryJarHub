package net.berryjar.berryjarhubwitdi.warp;

public class WarpBuilder {

    String warpID;
    String world;
    double x;
    double y;
    double z;
    float pitch;
    float yaw;


    public void setWorld(String world) {

        this.world = world;
    }

    public void setRegionID(String regionID) {
        this.warpID = regionID;
    }

    public void setX1(double x) {
        this.x = x;
    }

    public void setY1(double y) {
        this.y = y;
    }

    public void setZ1(double z) {
        this.z = z;
    }
    public void setPitch(float pitch) {
        this.pitch = pitch;
    }
    public void setYaw(float yaw) {
        this.yaw = yaw;
    }


    public String getWorld() {
        return this.world;
    }

    public String getWarpIDID() {
        return this.warpID;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public float getPitch() {
        return this.pitch;
    }
    public float getYaw() {  return this.yaw;}
}
