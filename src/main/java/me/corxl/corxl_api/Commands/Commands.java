package me.corxl.corxl_api.Commands;

import me.corxl.corxl_api.Corxl_API;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("cxl")) {
            if (args.length==1) {
                if (args[0].equalsIgnoreCase("reload")) {
                    if (!sender.hasPermission("cxl.reload")) {
                        sender.sendMessage("Test");
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Corxl_API.PLUGINPREFIX + "&c&oYou do not have permission to reload!"));
                        return true;
                    }
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Corxl_API.PLUGINPREFIX + "&c&oPlugin reloaded!"));
                    Corxl_API.plugin.reloadConfig();
                    return true;
                } else if (args[0].equalsIgnoreCase("toggleportal")) {
                    if (!sender.hasPermission("cxl.toggleportal")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Corxl_API.PLUGINPREFIX + "&c&oYou do not have permission to toggle the end portal!"));
                        return true;
                    }
                    Corxl_API.plugin.getConfig().set("disable-end-portal-activation", !Corxl_API.plugin.getConfig().getBoolean("disable-end-portal-activation"));
                    Corxl_API.plugin.saveConfig();
                    Corxl_API.plugin.reloadConfig();
                    sender.getServer().getOnlinePlayers().forEach(player->{
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Corxl_API.PLUGINPREFIX + "&2&oEnd Portal &cactivation has been: " +
                                (Corxl_API.plugin.getConfig().getBoolean("disable-end-portal-activation") ? "&r&4Disabled" : "&r&2Enabled")));
                    });
                }
            }
        }
        return false;
    }
}
