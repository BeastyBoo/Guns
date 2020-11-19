package com.github.beastyboo.guns.domain.port;

import com.github.beastyboo.guns.domain.entity.Gun;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;
import java.util.Set;

/**
 * Created by Torbie on 19.11.2020.
 */
public interface GunRepository {

    void load();
    void close();
    Optional<Gun> getGunByName(String name);
    Optional<Gun> getGunByItemStack(ItemStack itemStack);
    Set<Gun> findAllGuns();

}
