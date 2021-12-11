package me.corxl.corxl_api.Listeners;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;

import java.util.Random;

public class ItemEnchantListener implements Listener {
    @EventHandler
    public void onItemEnchant(EnchantItemEvent e) {
        if (e.getEnchantsToAdd().containsKey(Enchantment.ARROW_INFINITE)) return;
        boolean chance = false;
        if ((e.getExpLevelCost()>=15)&&(e.getExpLevelCost()<=25)) {
            chance = new Random().nextInt(15)==0;
        } else if (e.getExpLevelCost()==30) {
            chance = new Random().nextInt(4)==0;
        }
        if (chance) {
            e.getEnchantsToAdd().put(Enchantment.MENDING, 1);
        }
    }
}
