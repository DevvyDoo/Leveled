package io.github.devvydoo.levelingoverhaul.items;

import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public abstract class CustomItem implements Listener {

    protected CustomItemType type;
    protected ItemStack itemStack;

    public CustomItem(CustomItemType type) {
        this.type = type;
        this.itemStack = new ItemStack(type.TYPE);

        // Flag this item as a custom item
        itemStack.getItemMeta().getPersistentDataContainer().set(CustomItemManager.CUSTOM_ITEM_INDEX_KEY, PersistentDataType.INTEGER, type.ordinal());

        // Setup any things that will be common with all custom items
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(type.RARITY.NAME_LABEL_COLOR + type.NAME);

        List<String> lore = new ArrayList<>();
        lore.add("");

        if (CustomItemType.Category.hasCategoryStat(type.CATEGORY)) {
            lore.add(CustomItemType.Category.getCategoryStatPrefix(type.CATEGORY) + type.STAT_AMOUNT);
            lore.add("");
        }

        lore.addAll(type.LORE);
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES);
        itemStack.setItemMeta(meta);

        // This is an overridable method that will do anything extra that needs to be done per item
        setupItemStack();
    }

    public void setupItemStack() {}

    public ItemStack getItemStackClone() {
        return itemStack.clone();
    }
}