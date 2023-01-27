package ua.kotarych.item.itemconfig;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Funct {

    public static Component stringToComponent(String s) {
        return LegacyComponentSerializer.legacyAmpersand().deserialize(s);
    }

    public static String componentToString(Component c) {
        return LegacyComponentSerializer.legacyAmpersand().serialize(c);
    }

    public static ItemStack setLore(ItemStack itemStack, ArrayList<Component> lore){

        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.lore(lore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;

    }
}
