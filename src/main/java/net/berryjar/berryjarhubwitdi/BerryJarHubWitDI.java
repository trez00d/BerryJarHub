package net.berryjar.berryjarhubwitdi;

import net.berryjar.berryjarhubwitdi.bank.BankManager;
import net.berryjar.berryjarhubwitdi.command.CommandManager;
import net.berryjar.berryjarhubwitdi.command.subcommand.CoinCommand;
import net.berryjar.berryjarhubwitdi.command.subcommand.WarpCommand;
import net.berryjar.berryjarhubwitdi.cuboid.Cuboid;
import net.berryjar.berryjarhubwitdi.cuboid.CuboidManager;
import net.berryjar.berryjarhubwitdi.listener.playerinteract.PlayerLaunchpadStep;
import net.berryjar.berryjarhubwitdi.listener.blockbreak.PlayerBlockBreakServerSpawn;
import net.berryjar.berryjarhubwitdi.listener.join.PlayerJoinCreateConfig;
import net.berryjar.berryjarhubwitdi.listener.join.PlayerJoinGiveItems;
import net.berryjar.berryjarhubwitdi.listener.join.PlayerJoinScoreboard;
import net.berryjar.berryjarhubwitdi.listener.join.PlayerJoinSetCoin;
import net.berryjar.berryjarhubwitdi.listener.PlayerHungerDeplete;
import net.berryjar.berryjarhubwitdi.listener.join.PlayerJoinSpawnTeleport;
import net.berryjar.berryjarhubwitdi.listener.leave.PlayerLeaveSaveBankConfig;
import net.berryjar.berryjarhubwitdi.listener.move.*;
import net.berryjar.berryjarhubwitdi.listener.playerinteract.PlayerTeleCompassInteract;
import net.berryjar.berryjarhubwitdi.listener.playerinteract.PlayerVisClockInteract;
import net.berryjar.berryjarhubwitdi.listener.playerinteract.PlayerWandInteract;
import net.berryjar.berryjarhubwitdi.magicwand.WandManager;
import net.berryjar.berryjarhubwitdi.menus.TeleCompassMenu;
import net.berryjar.berryjarhubwitdi.player.BerryJarHubPlayer;
import net.berryjar.berryjarhubwitdi.player.JarPlayerManager;
import net.berryjar.berryjarhubwitdi.scoreboard.ScoreboardHandler;
import net.berryjar.berryjarhubwitdi.util.Tuple;
import net.berryjar.berryjarhubwitdi.warp.Warp;
import net.berryjar.berryjarhubwitdi.warp.WarpManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.ipvp.canvas.MenuFunctionListener;

import java.io.File;
import java.util.*;
import java.util.logging.Level;

public final class BerryJarHubWitDI extends JavaPlugin {


    public HashSet<Cuboid> activeRegions = new HashSet<Cuboid>();
    public HashSet<UUID> wandPrime = new HashSet<UUID>();
    public Tuple<Location, Location> clipboardMap = new Tuple<Location, Location>(null, null);
    public HashSet<UUID> visClockToggle = new HashSet<UUID>();
    public HashSet<Warp> warps = new HashSet<Warp>();
    public HashSet<UUID> spawnRegionList  = new HashSet<UUID>();
    public HashSet<UUID> survivalSpawnRegionList = new HashSet<UUID>();
    public HashSet<UUID> parkourRegionList = new HashSet<UUID>();
    public HashSet<UUID> parkour1Checkpoint1 = new HashSet<UUID>();
    public HashSet<UUID> parkourCheckpointRegionMessageList = new HashSet<UUID>();
    public HashSet<UUID> parkourVoidRegionList = new HashSet<UUID>();
    public Map<UUID, Integer> parkourAttempts = new HashMap<UUID, Integer>();
    public Map<UUID, Integer> bankBalance = new HashMap<UUID, Integer>();
    public HashSet<BerryJarHubPlayer> jarPlayers = new HashSet<BerryJarHubPlayer>();

    public WandManager wandManager;
    public PlayerJoinScoreboard playerJoinScoreboard;
    public PlayerJoinSpawnTeleport playerJoinSpawnTeleport;
    public PlayerBlockBreakServerSpawn playerBlockBreakServerSpawn;
    public PlayerVisClockInteract playerVisClockInteract;
    public PlayerJoinGiveItems playerJoinGiveItems;
    public PlayerSpawnRegionMove playerSpawnRegionMove;
    public ScoreboardHandler scoreboardHandler;
    public WarpManager warpManager;
    public WarpCommand warpCommand;
    public CuboidManager regionManager;
    public TeleCompassMenu teleCompassMenu;
    public PlayerTeleCompassInteract playerTeleCompassInteract;
    public PlayerWandInteract playerWandInteract;
    public PlayerSurvivalSpawnRegionMove playerSurvivalSpawnRegionMove;
    public PlayerParkourCheckpoint1RegionMove playerParkourCheckpoint1RegionMove;
    public PlayerParkourRegionMove playerParkourRegionMove;
    public PlayerParkourVoidMove playerParkourVoidMove;
    public BankManager bankManager;
    public CoinCommand coinCommand;
    public PlayerLeaveSaveBankConfig playerLeaveSaveBankConfig;
    public PlayerLaunchpadStep playerLaunchpadStep;
    public JarPlayerManager jarPlayerManager;


    @Override
    public void onEnable() {
        /*

        Instantiating necessities.

         */
        wandManager = new WandManager(this);
        playerJoinScoreboard = new PlayerJoinScoreboard(this);
        scoreboardHandler = new ScoreboardHandler(this);
        warpManager = new WarpManager(this);
        regionManager = new CuboidManager(this);
        warpCommand = new WarpCommand(this);
        playerJoinSpawnTeleport = new PlayerJoinSpawnTeleport(this);
        playerBlockBreakServerSpawn = new PlayerBlockBreakServerSpawn(this);
        playerVisClockInteract = new PlayerVisClockInteract(this);
        playerJoinGiveItems = new PlayerJoinGiveItems(this);
        teleCompassMenu = new TeleCompassMenu(this);
        playerTeleCompassInteract = new PlayerTeleCompassInteract(this);
        playerWandInteract = new PlayerWandInteract(this);
        playerSpawnRegionMove = new PlayerSpawnRegionMove(this);
        playerSurvivalSpawnRegionMove = new PlayerSurvivalSpawnRegionMove(this);
        playerParkourCheckpoint1RegionMove = new PlayerParkourCheckpoint1RegionMove(this);
        playerParkourRegionMove = new PlayerParkourRegionMove(this);
        playerParkourVoidMove = new PlayerParkourVoidMove(this);
        bankManager = new BankManager(this);
        coinCommand = new CoinCommand(this);
        playerLeaveSaveBankConfig = new PlayerLeaveSaveBankConfig(this);
        playerLaunchpadStep = new PlayerLaunchpadStep(this);
        jarPlayerManager = new JarPlayerManager(this);


        /*

        Registering commands.

         */
        getCommand("bjhub").setExecutor(new CommandManager(this));


        /*

        Registering listeners.

         */
        getServer().getPluginManager().registerEvents(new PlayerBlockBreakServerSpawn(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinCreateConfig(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinGiveItems(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinScoreboard(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinSetCoin(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinSpawnTeleport(this), this);
        getServer().getPluginManager().registerEvents(new PlayerHungerDeplete(), this);
        getServer().getPluginManager().registerEvents(new PlayerParkourCheckpoint1RegionMove(this), this);
        getServer().getPluginManager().registerEvents(new PlayerParkourRegionMove(this), this);
        getServer().getPluginManager().registerEvents(new PlayerParkourVoidMove(this), this);
        getServer().getPluginManager().registerEvents(new PlayerSpawnRegionMove(this), this);
        getServer().getPluginManager().registerEvents(new PlayerSurvivalSpawnRegionMove(this), this);
        getServer().getPluginManager().registerEvents(new PlayerTeleCompassInteract(this), this);
        getServer().getPluginManager().registerEvents(new PlayerVisClockInteract(this), this);
        getServer().getPluginManager().registerEvents(new MenuFunctionListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerWandInteract(this), this);
        getServer().getPluginManager().registerEvents(new PlayerHungerDeplete(), this);
        getServer().getPluginManager().registerEvents(new PlayerLeaveSaveBankConfig(this), this);
        getServer().getPluginManager().registerEvents(new PlayerLaunchpadStep(this), this);



        /*
        Creating default config.
         */
        File config = new File(this.getDataFolder(), "config.yml");

        if (!(config.exists())) {
            saveDefaultConfig();
            saveConfig();
            getLogger().log(Level.INFO, "Default config.yml generated.");
        } else {
            getLogger().log(Level.INFO, "Default config.yml already exists, not generating a new one.");
        }
        /*
        Load warps into memory. This is preferable to calling from config each time.
         */
        warpManager.loadWarps();
        bankManager.loadBank();
        regionManager.loadRegions();


        scoreboardHandler.scheduleScoreboardUpdateTask();



    }

    @Override
    public void onDisable() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            UUID u = p.getUniqueId();
            BankManager bankManager = new BankManager(this);
            bankManager.saveBank(u);
        }
    }
}
