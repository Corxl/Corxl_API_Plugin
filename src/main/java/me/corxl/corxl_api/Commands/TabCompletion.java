package me.corxl.corxl_api.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TabCompletion implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
        if (cmd.getName().equalsIgnoreCase("cxl")) {
            if (args.length==1) {
                List<String> tab = new ArrayList<>();
                if (sender.hasPermission("cxl.reload")) {
                    tab.add("reload");
                }
                if (sender.hasPermission("cxl.toggleportal")) {
                    tab.add("toggleportal");
                }
                return tab;
            }
        }
        return null;
    }
}
