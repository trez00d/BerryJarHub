package net.berryjar.berryjarhubwitdi.player;

import org.bukkit.entity.Player;

import java.util.UUID;

public class BerryJarHubPlayer {

    public UUID uuid;
    public Player player;
    public int parkourAttempts = 0;

    public int coins;

    public BerryJarHubPlayer(Player player) {
        this.player = player;
        this.uuid = player.getUniqueId();
        this.coins = 0;
        this.parkourAttempts = 0;
    }

    public UUID getUUID() {
        return this.uuid;
    }

    public Player getPlayer() {
        return this.player;

    }

    public int getCoins() {

        return this.coins;

    }

    public int setCoins(int coinsSet) {

        //This method should not be used unless by the BankManager

        this.coins = coinsSet;

        return coinsSet;

    }

    public void addCoins(int coinsAdd) {

        this.coins += coinsAdd;

    }

    public void incrementParkourAttempts() {
        this.parkourAttempts = this.parkourAttempts + 1;
    }

    public int getParkourAttempts() {
        return this.parkourAttempts;
    }
    public void setParkourAttempts(int i) {
        this.parkourAttempts = i;
    }

    public void clearParkourAttempts() {
        this.parkourAttempts = 0;
    }

}
