package com.github.beastyboo.guns.domain.entity;

import org.bukkit.inventory.ItemStack;

/**
 * Created by Torbie on 19.11.2020.
 */
public class Ammo {

    private final String name;
    private final ItemStack item;

    public Ammo(String name, ItemStack item) {
        this.name = name;
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public ItemStack getItem() {
        return item;
    }

}
