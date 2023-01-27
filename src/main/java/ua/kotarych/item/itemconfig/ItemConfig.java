package ua.kotarych.item.itemconfig;

import org.bukkit.plugin.java.JavaPlugin;
import ua.kotarych.item.itemconfig.command.ItemLore;
import ua.kotarych.item.itemconfig.command.Systems;
import ua.kotarych.item.itemconfig.event.ItemName;

public final class ItemConfig extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("lore").setExecutor(new ItemLore());
        getCommand("ItemConfig").setExecutor(new Systems());
        getCommand("ItemConfig").setExecutor(new Systems());

        getServer().getPluginManager().registerEvents(new ItemName(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
