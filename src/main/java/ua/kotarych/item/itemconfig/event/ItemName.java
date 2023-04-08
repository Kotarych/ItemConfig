package ua.kotarych.item.itemconfig.event;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ua.kotarych.item.itemconfig.Funct;

public class ItemName implements Listener {

    @EventHandler
    public void AnvilEvent(PrepareAnvilEvent e) {

        if (e.getView().getPlayer().hasPermission("ItemConfig.name")) {

            if (e.getResult() != null) {
                ItemMeta itemMeta = e.getResult().getItemMeta();

                if (itemMeta != null) {
                    if (itemMeta.displayName() != null) {
                        String resultDisplayName = Funct.componentToString(itemMeta.displayName());

                        if (resultDisplayName.contains("&")) {

                            itemMeta.displayName(Funct.stringToComponent(resultDisplayName));

                            ItemStack itemStack = e.getResult();
                            itemStack.setItemMeta(itemMeta);
                            e.setResult(itemStack);
                        }
                    }
                }
            }
        }
    }
}
