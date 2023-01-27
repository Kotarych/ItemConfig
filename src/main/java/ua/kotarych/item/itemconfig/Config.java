package ua.kotarych.item.itemconfig;

import org.bukkit.plugin.java.JavaPlugin;

public class Config {

    public final ItemConfig plugin = JavaPlugin.getPlugin(ItemConfig.class);

    public final boolean isMaxSymbols = plugin.getConfig().getBoolean("isMaxSymbols");
    public final int maxSymbols = plugin.getConfig().getInt("maxSymbols");
    public final String errorCommandLore = plugin.getConfig().getString("errorCommandLore");
    public final String errorMaxSymbols = plugin.getConfig().getString("errorMaxSymbols");
    public final String errorItem = plugin.getConfig().getString("errorItem");
    public final String successfullyAddedLore = plugin.getConfig().getString("successfullyAddedLore");
    public final String errorLvl = plugin.getConfig().getString("errorLvl");
    public final String errorPermission = plugin.getConfig().getString("errorPermission");
    public final String errorCommand = plugin.getConfig().getString("errorCommand");
    public final String successfullyReloadConfig = plugin.getConfig().getString("successfullyReloadConfig");
}
