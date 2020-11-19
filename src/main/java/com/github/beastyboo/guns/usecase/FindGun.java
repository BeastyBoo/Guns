package com.github.beastyboo.guns.usecase;

import com.github.beastyboo.guns.domain.entity.Gun;
import com.github.beastyboo.guns.domain.port.GunRepository;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;
import java.util.Set;

/**
 * Created by Torbie on 19.11.2020.
 */
public class FindGun {

    private final GunRepository repository;

    public FindGun(final GunRepository repository) {
        this.repository = repository;
    }

    public Optional<Gun> getGunByName(String name) {
        return repository.getGunByName(name);
    }

    public Optional<Gun> getGunByItemStack(ItemStack item) {
        return repository.getGunByItemStack(item);
    }

    public Set<Gun> findAllGuns() {
        return repository.findAllGuns();
    }

}
