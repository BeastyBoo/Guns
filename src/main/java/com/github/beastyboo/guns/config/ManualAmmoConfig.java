package com.github.beastyboo.guns.config;

import com.github.beastyboo.guns.adapter.InMemoryAmmoRepository;
import com.github.beastyboo.guns.application.Guns;
import com.github.beastyboo.guns.domain.port.AmmoRepository;
import com.github.beastyboo.guns.usecase.FindAmmo;

/**
 * Created by Torbie on 19.11.2020.
 */
public class ManualAmmoConfig {

    private final Guns core;
    private final AmmoRepository repository;

    public ManualAmmoConfig(Guns core) {
        this.core = core;
        repository = new InMemoryAmmoRepository(core);
    }

    public FindAmmo findAmmo() {
        return new FindAmmo(repository);
    }

    public void load() {
        repository.load();
    }

    public void close() {
        repository.close();
    }

}
