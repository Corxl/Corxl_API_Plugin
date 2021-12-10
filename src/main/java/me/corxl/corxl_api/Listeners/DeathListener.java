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
                    new Thread(()->{
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        playerList.sendMessage(players.getDisplayName() + ChatColor.GRAY + " :: " + ChatColor.RESET + "L");
                    }).start();
                }
            }
        }
    }
}
