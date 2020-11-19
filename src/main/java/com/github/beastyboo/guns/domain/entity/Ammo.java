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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ammo ammo = (Ammo) o;

        if (!getName().equals(ammo.getName())) return false;
        return getItem().equals(ammo.getItem());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getItem().hashCode();
        return result;
    }
}
