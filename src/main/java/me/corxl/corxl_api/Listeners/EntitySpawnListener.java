package me.corxl.corxl_api.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

import java.util.Random;

public class EntitySpawnListener implements Listener {

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        if (!(event.getEntity() instanceof Creeper)) return;
        if (!(new Random().nextDouble()<=0.25)) return;
        ((Creeper) event.getEntity()).setPowered(true);
    }

    @EventHandler
    public void onCreeperDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        if (!(entity instanceof Creeper)) return;
        Creeper creeper = (Creeper) entity;
        if (!creeper.isPowered()) return;
        event.getDrops().forEach(drop ->{
            if (drop.getType().equals(Material.GUNPOWDER)) {
                drop.setAmount(drop.getAmount()*2);
            }
        });
    }

}
