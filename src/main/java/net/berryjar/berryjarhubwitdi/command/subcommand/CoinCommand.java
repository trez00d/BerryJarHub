package net.berryjar.berryjarhubwitdi.command.subcommand;

import net.berryjar.berryjarhubwitdi.BerryJarHubWitDI;
import net.berryjar.berryjarhubwitdi.bank.BankManager;
import net.berryjar.berryjarhubwitdi.chat.ChatHandler;
import net.berryjar.berryjarhubwitdi.command.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class CoinCommand extends SubCommand {

    private final BerryJarHubWitDI plugin;

    public CoinCommand(final BerryJarHubWitDI plugin) {
        this.plugin = plugin;
    }

    @Override
    public String getName() {
        return "coins";
    }

    @Override
    public String getDescription() {
        return "Coins command";
    }

    @Override
    public String getSyntax() {
        return "/bjhub coins <balance|withdraw|pay>";
    }

    @Override
    public void perform(Player player, String[] args) {
        if (args.length == 1) {
            BankManager bankManager = new BankManager(plugin);
            int balance = bankManager.getBalance(player.getUniqueId());
            player.sendMessage(ChatHandler.chatPrefix + ChatColor.GREEN + "Your current balance is: " + ChatColor.GOLD + balance + ChatColor.GREEN + ".");
        }
        if (args.length == 2) {
            if (args[1].equalsIgnoreCase("pay")) {
                player.sendMessage(ChatHandler.chatPrefix + ChatHandler.insuffArgs);
            }
        }
        if (args.length == 3) {
            if (args[1].equalsIgnoreCase("pay")) {
                player.sendMessage(ChatHandler.chatPrefix + ChatHandler.insuffArgs);
            }
        }
        if (args.length == 4) {
            if(args[1].equalsIgnoreCase("pay")) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (args[2].equals(p.getName())) {
                        BankManager bankManager = new BankManager(plugin);
                        int coinAmt = Integer.parseInt(args[3]);
                        Player playa = Bukkit.getPlayer(args[2]);
                        if (bankManager.getBalance(player.getUniqueId()) < coinAmt) {
                            player.sendMessage(ChatHandler.chatPrefix + ChatColor.RED + "You do not have enough coins to pay " + playa.getName() + "!");
                        } else {
                            bankManager.deposit(playa.getUniqueId(), coinAmt);
                            bankManager.withdraw(player.getUniqueId(), coinAmt);
                            player.sendMessage(ChatHandler.chatPrefix + ChatColor.GREEN + coinAmt + " coins sent to " + playa.getName() + ".");
                        }




                    }
                }
            }
        }
        if (args.length == 2) {
            if (args[1].equalsIgnoreCase("withdraw")) {
                player.sendMessage(ChatHandler.chatPrefix + ChatHandler.insuffArgs);
            }
        }
        if (args.length == 3) {
            if (args[1].equalsIgnoreCase("withdraw")) {
                player.sendMessage(ChatHandler.chatPrefix + ChatHandler.insuffArgs);
            }
        }
        if (args.length == 4) {
            if(args[1].equalsIgnoreCase("withdraw")) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (args[2].equals(p.getName())) {
                        Player playa = Bukkit.getPlayer(args[2]);
                        int coinAmt = Integer.parseInt(args[3]);
                        BankManager bankManager = new BankManager(plugin);

                        if (bankManager.getBalance(playa.getUniqueId()) <= 0) {
                            player.sendMessage(ChatHandler.chatPrefix + ChatColor.RED + "You do not have enough coins to perform this transaction.");
                        } else {
                            bankManager.withdraw(playa.getUniqueId(), coinAmt);
                            bankManager.deposit(player.getUniqueId(), coinAmt);
                            player.sendMessage(ChatHandler.chatPrefix + ChatColor.GREEN + coinAmt + " coins removed from " + playa.getName() + ".");
                        }

                    }
                }
            }
        }

    }
}
