package net.berryjar.berryjarhubwitdi.scoreboard;

import net.berryjar.berryjarhubwitdi.BerryJarHubWitDI;
import net.berryjar.berryjarhubwitdi.bank.BankManager;
import net.berryjar.berryjarhubwitdi.config.ConfigManager;
import net.berryjar.berryjarhubwitdi.util.GroupManagerHook;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class ScoreboardHandler {

    private final BerryJarHubWitDI plugin;

    public ScoreboardHandler(final BerryJarHubWitDI plugin) {
        this.plugin = plugin;
    }

    public void createScoreboard(Player player) {



        GroupManagerHook gmHook = new GroupManagerHook(plugin);
        BankManager bankManager = new BankManager(plugin);
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();
        ConfigManager config = new ConfigManager(player.getUniqueId());

        Objective objective = scoreboard.registerNewObjective("test", "dummy", ChatColor.GOLD + "Stats");

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        int balance = bankManager.getBalance(player.getUniqueId());
        String rank = gmHook.getGroup(player);
        Score coins = objective.getScore(ChatColor.GOLD + "Coins: " + ChatColor.GREEN + balance);
        Score rankScore = objective.getScore(ChatColor.BLUE + "Rank: " + ChatColor.LIGHT_PURPLE + rank);
        coins.setScore(1);
        rankScore.setScore(0);

        if (!(player.getWorld().getName().equalsIgnoreCase("spawn"))) {
            player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
        } else {
            player.setScoreboard(scoreboard);
        }

    }

    public void scheduleScoreboardUpdateTask() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    createScoreboard(player);
                }
            }
        }, 0L, 20L);
    }

}
