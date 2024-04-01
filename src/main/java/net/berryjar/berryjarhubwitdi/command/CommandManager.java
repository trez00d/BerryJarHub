package net.berryjar.berryjarhubwitdi.command;

import net.berryjar.berryjarhubwitdi.BerryJarHubWitDI;
import net.berryjar.berryjarhubwitdi.command.subcommand.CoinCommand;
import net.berryjar.berryjarhubwitdi.command.subcommand.RegionCommand;
import net.berryjar.berryjarhubwitdi.command.subcommand.SetWarpCommand;
import net.berryjar.berryjarhubwitdi.command.subcommand.WarpCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CommandManager implements CommandExecutor {

    private final BerryJarHubWitDI plugin;

    private ArrayList<SubCommand> subCommandList = new ArrayList<SubCommand>();

    public CommandManager(final BerryJarHubWitDI plugin) {
        this.plugin = plugin;
        subCommandList.add(new RegionCommand(plugin));
        subCommandList.add(new SetWarpCommand(plugin));
        subCommandList.add(new WarpCommand(plugin));
        subCommandList.add(new CoinCommand(plugin));

    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length > 0) {
                for (int i = 0; i < getSubCommandList().size(); i++) {
                    if (args[0].equalsIgnoreCase(getSubCommandList().get(i).getName())) {
                        getSubCommandList().get(i).perform(player, args);
                    }
                }

            }
        }

        return true;
    }

    public ArrayList<SubCommand> getSubCommandList() {
        return subCommandList;
    }
}
