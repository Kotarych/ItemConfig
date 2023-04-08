package ua.kotarych.item.itemconfig;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Config {


    public static final ItemConfig plugin = JavaPlugin.getPlugin(ItemConfig.class);

    private static final File fileConfig = new File(plugin.getDataFolder(), "config.yml");
    private static final FileConfiguration config = YamlConfiguration.loadConfiguration(fileConfig);
    private static final String thisLanguage = config.getString("thisLanguage");
    private static String language = config.getString("language");
    private static final File fileConfigEn = new File(plugin.getDataFolder(), "config_en.yml");
    private static final File fileConfigLan = new File(plugin.getDataFolder(), "config_" + language + ".yml");

    public static void load(){

        if (fileConfig.exists()) {
            if (!language.equals(thisLanguage)) {
                if (language.equals("en") | language.equals("ru") | language.equals("ua")) {
                    fileConfig.delete();

                    plugin.saveResource("config_" + language + ".yml", false);

                    fileConfigLan.renameTo(fileConfig);
                }
            } else {
                plugin.getConfig().options().copyDefaults();
                plugin.saveDefaultConfig();

                plugin.saveConfig();
            }
        } else {
            plugin.saveResource("config_en.yml", false);

            fileConfigEn.renameTo(fileConfig);
        }

        isMaxSymbols = plugin.getConfig().getBoolean("isMaxSymbols");
        maxSymbols = plugin.getConfig().getInt("maxSymbols");
        errorCommandLore = plugin.getConfig().getString("errorCommandLore");
        errorMaxSymbols = plugin.getConfig().getString("errorMaxSymbols");
        errorItem = plugin.getConfig().getString("errorItem");
        successfullyAddedLore = plugin.getConfig().getString("successfullyAddedLore");
        errorLvl = plugin.getConfig().getString("errorLvl");
        errorPermission = plugin.getConfig().getString("errorPermission");
        errorCommand = plugin.getConfig().getString("errorCommand");
        successfullyReloadConfig = plugin.getConfig().getString("successfullyReloadConfig");

    }

    public static void reload(){
        plugin.reloadConfig();
        plugin.saveConfig();

        isMaxSymbols = plugin.getConfig().getBoolean("isMaxSymbols");
        maxSymbols = plugin.getConfig().getInt("maxSymbols");
        errorCommandLore = plugin.getConfig().getString("errorCommandLore");
        errorMaxSymbols = plugin.getConfig().getString("errorMaxSymbols");
        errorItem = plugin.getConfig().getString("errorItem");
        successfullyAddedLore = plugin.getConfig().getString("successfullyAddedLore");
        errorLvl = plugin.getConfig().getString("errorLvl");
        errorPermission = plugin.getConfig().getString("errorPermission");
        errorCommand = plugin.getConfig().getString("errorCommand");
        successfullyReloadConfig = plugin.getConfig().getString("successfullyReloadConfig");
        language = plugin.getConfig().getString("language");
    }

    private static boolean isMaxSymbols;
    private static int maxSymbols;
    private static String errorCommandLore;
    private static String errorMaxSymbols;
    private static String errorItem;
    private static String successfullyAddedLore;
    private static String errorLvl;
    private static String errorPermission;
    private static String errorCommand;
    private static String successfullyReloadConfig;

    public static int getMaxSymbols() {
        return maxSymbols;
    }

    public static String getErrorCommand() {
        return errorCommand;
    }

    public static String getErrorCommandLore() {
        return errorCommandLore;
    }

    public static String getErrorItem() {
        return errorItem;
    }

    public static String getErrorLvl() {
        return errorLvl;
    }

    public static String getErrorMaxSymbols() {
        return errorMaxSymbols;
    }

    public static String getErrorPermission() {
        return errorPermission;
    }

    public static String getSuccessfullyAddedLore() {
        return successfullyAddedLore;
    }

    public static String getSuccessfullyReloadConfig() {
        return successfullyReloadConfig;
    }

    public static boolean isIsMaxSymbols() {
        return isMaxSymbols;
    }

}
