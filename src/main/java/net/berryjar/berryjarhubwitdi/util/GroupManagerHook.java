package net.berryjar.berryjarhubwitdi.util;

import net.berryjar.berryjarhubwitdi.BerryJarHubWitDI;
import org.anjocaido.groupmanager.GroupManager;
import org.anjocaido.groupmanager.dataholder.OverloadedWorldHolder;
import org.anjocaido.groupmanager.permissions.AnjoPermissionsHandler;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import java.util.Arrays;
import java.util.List;

public class GroupManagerHook {

    private GroupManager groupManager;

    private final BerryJarHubWitDI plugin;

    public GroupManagerHook(final BerryJarHubWitDI plugin) {
        this.plugin = plugin;
    }

    public boolean hasGroupManager() {

        if (groupManager != null) return true;

        final PluginManager pluginManager = plugin.getServer().getPluginManager();
        final Plugin GMplugin = pluginManager.getPlugin("GroupManager");

        if (GMplugin != null && GMplugin.isEnabled()) {
            groupManager = (GroupManager)GMplugin;
            return true;
        }
        return false;
    }

    public String getGroup(final Player player) {
        if (!hasGroupManager()) return null;

        final AnjoPermissionsHandler handler = groupManager.getWorldsHolder().getWorldPermissions(player);
        if (handler == null) return null;

        return handler.getGroup(player.getName());
    }

    public boolean setGroup(final Player player, final String group) {
        if (!hasGroupManager()) return false;

        final OverloadedWorldHolder handler = groupManager.getWorldsHolder().getWorldData(player);
        if (handler == null) return false;

        handler.getUser(player.getName()).setGroup(handler.getGroup(group));
        return true;
    }

    public List<String> getGroups(final Player player) {
        if (!hasGroupManager()) return null;

        final AnjoPermissionsHandler handler = groupManager.getWorldsHolder().getWorldPermissions(player);
        if (handler == null) return null;

        return Arrays.asList(handler.getGroups(player.getName()));
    }

    public String getPrefix(final Player player) {
        if (!hasGroupManager()) return null;

        final AnjoPermissionsHandler handler = groupManager.getWorldsHolder().getWorldPermissions(player);
        if (handler == null) return null;

        return handler.getUserPrefix(player.getName());
    }

    public String getSuffix(final Player player) {
        if (!hasGroupManager()) return null;

        final AnjoPermissionsHandler handler = groupManager.getWorldsHolder().getWorldPermissions(player);
        if (handler == null) return null;

        return handler.getUserSuffix(player.getName());
    }

    /**
     * Supports wildcards.
     *
     * @param player
     * @param node
     * @return
     */
    public boolean hasPermission(final Player player, final String node) {
        if (!hasGroupManager()) return false;

        final AnjoPermissionsHandler handler = groupManager.getWorldsHolder().getWorldPermissions(player);
        if (handler == null) return false;

        return handler.has(player, node);
    }


}
