package ua.kotarych.item.itemconfig.command;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ua.kotarych.item.itemconfig.Config;
import ua.kotarych.item.itemconfig.Funct;

import java.awt.*;
import java.util.ArrayList;

public class ItemLore implements CommandExecutor {

    private static final Config CONFIG = new Config();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;

            if (player.hasPermission("LoreOmega.commandLore")) {

                if (args.length != 0) {
                    String lore = String.join(" ", args);

                    if (CONFIG.isMaxSymbols) {
                        if (lore.length() > CONFIG.maxSymbols) {

                            player.sendRawMessage(ChatColor.translateAlternateColorCodes('&',
                                    CONFIG.errorMaxSymbols.replace("%symbols%", String.valueOf(CONFIG.maxSymbols))));

                            return true;
                        }
                    }

                    if (!player.hasPermission("ItemConfig.noLvl")) {
                        if (player.getLevel() < 2) {

                            player.sendRawMessage(ChatColor.translateAlternateColorCodes('&', CONFIG.errorLvl));
                            return true;
                        }
                    }

                    ArrayList<Component> components = new ArrayList<>();
                    components.add(Funct.stringToComponent(lore));

                    int slot = player.getInventory().getHeldItemSlot();
                    ItemStack itemStack = player.getInventory().getItem(slot);

                    if (itemStack != null) {

                        player.getInventory().setItem(slot, Funct.setLore(itemStack, components));

                        if (!player.hasPermission("ItemConfig.noLvl")) {
                            player.setLevel(player.getLevel() - 2);
                        }

                        player.sendActionBar(Funct.stringToComponent(CONFIG.successfullyAddedLore));


                    } else {
                        player.sendRawMessage(ChatColor.translateAlternateColorCodes('&', CONFIG.errorItem));
                    }

                } else {
                    player.sendRawMessage(ChatColor.translateAlternateColorCodes('&', CONFIG.errorCommandLore));

                }
            } else {
                player.sendRawMessage(ChatColor.translateAlternateColorCodes('&', CONFIG.errorPermission));
            }

        }
        return true;
    }
}
