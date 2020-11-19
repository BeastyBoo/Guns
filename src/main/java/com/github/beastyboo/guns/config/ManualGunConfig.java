package com.github.beastyboo.guns.config;

import com.github.beastyboo.guns.adapter.InMemoryGunRepository;
import com.github.beastyboo.guns.application.Guns;
import com.github.beastyboo.guns.domain.port.GunRepository;
import com.github.beastyboo.guns.usecase.FindGun;

/**
 * Created by Torbie on 19.11.2020.
 */
public class ManualGunConfig {

    private final Guns core;
    private final GunRepository repository;

    public ManualGunConfig(Guns core) {
        this.core = core;
        repository = new InMemoryGunRepository(core);
    }

    public FindGun findGun() {
        return new FindGun(repository);
    }

    public void load() {
        repository.load();
    }

    public void close() {
        repository.close();
    }

}
