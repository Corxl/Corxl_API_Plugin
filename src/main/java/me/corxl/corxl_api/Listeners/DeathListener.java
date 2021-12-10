package me.corxl.corxl_api.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        for (Player playerList : Bukkit.getServer().getOnlinePlayers()){
            for (Player players : Bukkit.getServer().getOnlinePlayers()){
                if (!players.equals(e.getEntity())) {
                    playerList.sendMessage(players.getDisplayName() + ChatColor.GRAY + " :: " + ChatColor.RESET + "L");
                }
            }
        }
    }
}
