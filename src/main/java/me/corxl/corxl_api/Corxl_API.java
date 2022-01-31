package me.corxl.corxl_api;

import me.corxl.corxl_api.Commands.Commands;
import me.corxl.corxl_api.Commands.TabCompletion;
import me.corxl.corxl_api.Listeners.DeathListener;
import me.corxl.corxl_api.Listeners.EndPoralListener;
import me.corxl.corxl_api.Listeners.ItemEnchantListener;
import me.corxl.corxl_api.Listeners.WitherSkeletonDeathListener;
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
        Bukkit.addRecipe(gildedBlackStone());
        Bukkit.addRecipe(shulkerBoxRecipe());
        Bukkit.addRecipe(saddleRecipe());
        Bukkit.addRecipe(nameTagRecipe());
        this.getServer().getPluginManager().registerEvents(new DeathListener(), this);
        this.getServer().getPluginManager().registerEvents(new EndPoralListener(), this);
        this.getServer().getPluginManager().registerEvents(new ItemEnchantListener(), this);
        this.getServer().getPluginManager().registerEvents(new WitherSkeletonDeathListener(), this);
        this.getCommand("cxl").setExecutor(new Commands());
        this.getCommand("cxl").setTabCompleter(new TabCompletion());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Corxl_API getPlugin() {
        return plugin;
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

    private ShapedRecipe gildedBlackStone() {
        NamespacedKey key = new NamespacedKey(this, "gilded_blackstone_recipe");
        ItemStack item = new ItemStack(Material.GILDED_BLACKSTONE, 3);
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("GGG", "BBB", "GGG");

        recipe.setIngredient('G', Material.GOLD_NUGGET);
        recipe.setIngredient('B', Material.BLACKSTONE);

        return recipe;
    }

    private ShapedRecipe shulkerBoxRecipe() {
        NamespacedKey key = new NamespacedKey(this, "shulker_box_recipe");
        ItemStack item = new ItemStack(Material.SHULKER_BOX, 1);
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape(" D ", "RER", " D ");

        recipe.setIngredient('D', Material.DIAMOND_BLOCK);
        recipe.setIngredient('R', Material.REDSTONE_BLOCK);
        recipe.setIngredient('E', Material.ENDER_CHEST);

        return recipe;
    }

    private ShapedRecipe saddleRecipe() {
        NamespacedKey key = new NamespacedKey(this, "saddle_recipe");
        ItemStack saddle = new ItemStack(Material.SADDLE, 1);
        ShapedRecipe recipe = new ShapedRecipe(key, saddle);
        recipe.shape(" L ", "LIL", "L L");

        recipe.setIngredient('L', Material.LEATHER);
        recipe.setIngredient('I', Material.IRON_INGOT);
        return recipe;
    }

    private ShapedRecipe nameTagRecipe() {
        NamespacedKey key = new NamespacedKey(this, "nametag_recipe");
        ItemStack nameTag = new ItemStack(Material.NAME_TAG, 1);
        ShapedRecipe recipe = new ShapedRecipe(key, nameTag);
        recipe.shape("  S", " P ", "P  ");

        recipe.setIngredient('S', Material.STRING);
        recipe.setIngredient('P', Material.PAPER);

        return recipe;
    }
}
