package ua.kotarych.item.itemconfig.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.meta.ItemMeta;
import ua.kotarych.item.itemconfig.Funct;

public class ItemName implements Listener {

    @EventHandler
    public void AnvilEvent(PrepareAnvilEvent e) {

        if (e.getResult() != null) {
            ItemMeta itemMeta = e.getResult().getItemMeta();

            if (itemMeta != null) {
                String resultDisplayName = Funct.componentToString(itemMeta.displayName());
                resultDisplayName = resultDisplayName.replace("[", "");
                resultDisplayName = resultDisplayName.replace("]", "");

                itemMeta.displayName(Funct.stringToComponent(resultDisplayName));
                if (resultDisplayName.contains("&")) {
                    e.getResult().setItemMeta(itemMeta);
                }
            }
        }
    }
}
