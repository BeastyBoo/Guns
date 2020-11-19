package com.github.beastyboo.guns.usecase;

import com.github.beastyboo.guns.domain.entity.Ammo;
import com.github.beastyboo.guns.domain.port.AmmoRepository;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;
import java.util.Set;

/**
 * Created by Torbie on 19.11.2020.
 */
public class FindAmmo {

    private final AmmoRepository repository;

    public FindAmmo(final AmmoRepository repository) {
        this.repository = repository;
    }

    public Optional<Ammo> getAmmoByName(String name) {
        return repository.getAmmoByName(name);
    }

    public Optional<Ammo> getAmmoByItemStack(ItemStack item){
        return repository.getAmmoByItemStack(item);
    }

    public Set<Ammo> findAllAmmo() {
        return repository.findAllAmmo();
    }

}
