package com.github.beastyboo.guns.usecase;

import com.github.beastyboo.guns.domain.entity.Cooldown;
import com.github.beastyboo.guns.domain.port.CooldownRepository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * Created by Torbie on 22.11.2020.
 */
public class FindCooldown {

    private final CooldownRepository repository;

    public FindCooldown(CooldownRepository repository) {
        this.repository = repository;
    }

    public Optional<Cooldown> getCooldownByUUID(UUID uuid) {
        return repository.getCooldownByUUID(uuid);
    }

    public Set<Cooldown> getAllCooldowns() {
        return repository.getAllCooldowns();
    }

}
