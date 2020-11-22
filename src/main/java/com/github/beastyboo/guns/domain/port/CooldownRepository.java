package com.github.beastyboo.guns.domain.port;

import com.github.beastyboo.guns.domain.entity.Cooldown;
import org.bukkit.command.CommandSender;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * Created by Torbie on 22.11.2020.
 */
public interface CooldownRepository {

    boolean startOrCheck(UUID uuid, CommandSender sender, double timeInSeconds);
    Optional<Cooldown> getCooldownByUUID(UUID uuid);
    Set<Cooldown> getAllCooldowns();

}
