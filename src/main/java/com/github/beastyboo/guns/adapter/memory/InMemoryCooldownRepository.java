package com.github.beastyboo.guns.adapter.memory;

import com.github.beastyboo.guns.application.Guns;
import com.github.beastyboo.guns.domain.entity.Cooldown;
import com.github.beastyboo.guns.domain.port.CooldownRepository;
import org.bukkit.command.CommandSender;

import java.util.*;

/**
 * Created by Torbie on 22.11.2020.
 */
public class InMemoryCooldownRepository implements CooldownRepository{

    private final Guns core;
    private final Map<UUID, Cooldown> inMemoryByUUID;

    public InMemoryCooldownRepository(Guns core) {
        this.core = core;
        inMemoryByUUID = new HashMap<>();
    }

    @Override
    public boolean startOrCheck(UUID uuid, CommandSender sender, double timeInSeconds) {
        Optional<Cooldown> cooldown = this.getCooldownByUUID(uuid);
        if(!cooldown.isPresent()) {
            Cooldown newCooldown = new Cooldown(uuid, timeInSeconds);
            inMemoryByUUID.put(uuid, newCooldown);
            return true;
        }

        //sender.se

        return false;
    }

    @Override
    public Optional<Cooldown> getCooldownByUUID(UUID uuid) {
        return Optional.ofNullable(inMemoryByUUID.get(uuid));
    }

    @Override
    public Set<Cooldown> getAllCooldowns() {
        return new HashSet<>(inMemoryByUUID.values());
    }



}
