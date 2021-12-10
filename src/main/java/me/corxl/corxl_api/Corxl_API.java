package me.corxl.corxl_api;

import me.corxl.corxl_api.Commands.Commands;
import me.corxl.corxl_api.Commands.TabCompletion;
import me.corxl.corxl_api.Listeners.EndPoralListener;
import me.corxl.corxl_api.Listeners.ItemEnchantListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public final class Corxl_API extends JavaPlugin {

    public static Corxl_API plugin;
    public static final String PLUGINPREFIX = ChatColor.translateAlternateColorCodes('&', "&l&2[&3CorxlAPI&2]&r ");

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        this.saveDefaultConfig();
        Bukkit.addRecipe(spongeRecipe());
        Bukkit.addRecipe(prismarineShardRecipe());
        System.out.println("Change commit1");
        System.out.println("Change commit3");
        this.getServer().getPluginManager().registerEvents(new EndPoralListener(), this);
        this.getServer().getPluginManager().registerEvents(new ItemEnchantListener(), this);
        this.getCommand("cxl").setExecutor(new Commands());
        this.getCommand("cxl").setTabCompleter(new TabCompletion());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    private ShapedRecipe spongeRecipe() {
        NamespacedKey key = new NamespacedKey(this, "sponge_recipe");
        ItemStack item = new ItemStack(Material.SPONGE);
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("SSS", "SCS", "SSS");

        recipe.setIngredient('S', Material.SAND);
        recipe.setIngredient('C', Material.HORN_CORAL_BLOCK);

        return recipe;
    }

    private ShapedRecipe prismarineShardRecipe() {
        NamespacedKey key = new NamespacedKey(this, "prismarine_shard_recipe");
        ItemStack item = new ItemStack(Material.PRISMARINE_SHARD, 4);
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("P");

        recipe.setIngredient('P', Material.PRISMARINE);

        return recipe;
    }
}
