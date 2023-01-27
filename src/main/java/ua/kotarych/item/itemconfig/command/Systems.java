package ua.kotarych.item.itemconfig.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ua.kotarych.item.itemconfig.Config;

import java.util.List;

public class Systems implements CommandExecutor, TabExecutor {
    private final Config CONFIG = new Config();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (args.length != 0){
            if (sender.hasPermission("ItemConfig.reload")) {
                if (args[0].equalsIgnoreCase("reload")) {

                    Bukkit.reload();
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', CONFIG.successfullyReloadConfig));

                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', CONFIG.errorPermission));
            }

        } else {

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', CONFIG.errorCommand));
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (args.length == 1){
            return List.of("reload");
        }
        return null;
    }
}
