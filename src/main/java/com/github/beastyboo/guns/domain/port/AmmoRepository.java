package com.github.beastyboo.guns.domain.port;

import com.github.beastyboo.guns.domain.entity.Ammo;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;
import java.util.Set;

/**
 * Created by Torbie on 19.11.2020.
 */

public interface AmmoRepository {

    void load();
    void close();
    Optional<Ammo> getAmmoByName(String name);
    Optional<Ammo> getAmmoByItemStack(ItemStack itemStack);
    Set<Ammo> findAllAmmo();

}
