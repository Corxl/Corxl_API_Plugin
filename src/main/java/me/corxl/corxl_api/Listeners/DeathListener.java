package me.corxl.corxl_api.Listeners;

import me.corxl.corxl_api.Corxl_API;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class DeathListener implements Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        new Thread(()->{
            try {
                Corxl_API plugin = Corxl_API.getPlugin();
                File file = new File(plugin.getDataFolder().getAbsolutePath()+"\\DeathLog.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter wr = new FileWriter(file, true);
                Player player = e.getEntity();

                Calendar c1 = Calendar.getInstance();

                c1.set(Calendar.MONTH, 11);

                c1.set(Calendar.DATE, 05);

                c1.set(Calendar.YEAR, 1996);

                Date dateOne = c1.getTime();

                System.out.println(dateOne);

                String death = "Date: " + dateOne + "\nPlayer name: " + e.getEntity().getName() + "\nUUID: " + e.getEntity().getUniqueId() + "\nDeath Cause: " + e.getDeathMessage()
                        + "\nLocation: " + e.getEntity().getLocation().getX() + ", " + e.getEntity().getLocation().getY() + ", " +
                        e.getEntity().getLocation().getZ() + "\nInventory Stack: " + Arrays.toString(player.getInventory().getContents()) + "\n\n";
                wr.append(death);

                wr.close();
            } catch (IOException error) {
                error.printStackTrace();
            }
        }).start();

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
