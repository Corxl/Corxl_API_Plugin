package me.corxl.corxl_api.Listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class WitherSkeletonDeathListener implements Listener {

    @EventHandler
    public void onWitherSkeleDeath(EntityDeathEvent event) {
        if (event.getEntity().getName().equalsIgnoreCase("Wither Skeleton")) {
            if ((event.getDrops() == null) || event.getDrops().isEmpty()) return;
            event.getDrops().forEach(key->{
                if (key.getType().equals(Material.WITHER_SKELETON_SKULL)) {
                    event.getDrops().remove(key);
                }
            });
            if (new Random().nextInt(3)==0) {
                event.getDrops().add(new ItemStack(Material.WITHER_SKELETON_SKULL, 1));
            }
        }
    }

}
