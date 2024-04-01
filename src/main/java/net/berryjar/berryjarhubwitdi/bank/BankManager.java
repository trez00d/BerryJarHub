package net.berryjar.berryjarhubwitdi.bank;

import net.berryjar.berryjarhubwitdi.BerryJarHubWitDI;
import net.berryjar.berryjarhubwitdi.config.ConfigManager;
import org.bukkit.Bukkit;

import java.io.File;
import java.util.UUID;

public class BankManager {

    private final BerryJarHubWitDI plugin;

    public UUID id;
    public BankManager(final BerryJarHubWitDI plugin) {
        this.plugin = plugin;
    }

    public void deposit(UUID uuid, int coinAmount) {

        int balance = plugin.bankBalance.get(uuid);
        balance += coinAmount;
        plugin.bankBalance.put(uuid, balance);

    }

    public int getBalance(UUID uuid) {


        return plugin.bankBalance.get(uuid);

    }

    public void withdraw(UUID uuid, int coinAmount) {

        int balance = plugin.bankBalance.get(uuid);
        balance -= coinAmount;
        plugin.bankBalance.put(uuid, balance);

    }

    public void loadBank() {
        File folder = new File(Bukkit.getServer().getPluginManager().getPlugin("BerryJarHubWitDI").getDataFolder(), "users");
        File[] directoryListing = folder.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                ConfigManager config = new ConfigManager(UUID.fromString(child.getName().replace(".yml", "")));
                int balance = config.getBankConfig().getInt("coins");
                plugin.bankBalance.put(UUID.fromString(child.getName().replace(".yml", "")), balance);
                System.out.println(plugin.bankBalance);
            }
        }
    }

    public void saveBank(UUID uuid) {
        ConfigManager configManager = new ConfigManager(uuid);
        configManager.getBankConfig().set("coins", getBalance(uuid));
        configManager.saveBankConfig();

    }

}