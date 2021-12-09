package me.corxl.corxl_api.Listeners;

import me.corxl.corxl_api.Corxl_API;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class EndPoralListener implements Listener {

    @EventHandler
    public void endPortal(PlayerInteractEvent e) {
        if (e.getClickedBlock()==null) return;
        if (e.getPlayer().hasPermission("cxl.bypass")&&e.getClickedBlock().getType().equals(Material.END_PORTAL_FRAME)) return;
        if (e.getClickedBlock().getType().equals(Material.END_PORTAL_FRAME) && Corxl_API.plugin.getConfig().getBoolean("disable-end-portal-activation")) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', Corxl_API.PLUGINPREFIX + "&o&cEnd portal activation is disabled on this server!"));
        }
    }
}
