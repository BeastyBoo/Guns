package com.github.beastyboo.guns.adapter.memory;

import com.github.beastyboo.guns.adapter.type.GunTypeAdapter;
import com.github.beastyboo.guns.application.Guns;
import com.github.beastyboo.guns.domain.entity.Gun;
import com.github.beastyboo.guns.domain.port.GunRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.*;

/**
 * Created by Torbie on 19.11.2020.
 */
public class InMemoryGunRepository implements GunRepository{

    private final Guns core;
    private final Gson gson;
    private final Map<String, Gun> inMemoryByName;
    private final Map<Material, Gun> inMemoryByMaterial;

    public InMemoryGunRepository(Guns core) {
        this.core = core;
        gson = this.createGsonInstance();
        inMemoryByName = new HashMap<>();
        inMemoryByMaterial = new HashMap<>();
    }

    @Override
    public void load() {
        //TODO: LOAD
    }

    @Override
    public void close() {
        //TODO: CLOSE
    }

    @Override
    public Optional<Gun> getGunByName(String name) {
        return Optional.ofNullable(inMemoryByName.get(name.toLowerCase()));
    }

    @Override
    public Optional<Gun> getGunByItemStack(ItemStack item) {
        return Optional.ofNullable(inMemoryByMaterial.get(item.getType()));
    }

    @Override
    public Set<Gun> findAllGuns() {
        return new HashSet<>(inMemoryByName.values());
    }

    private Gson createGsonInstance() {
        return new GsonBuilder().registerTypeAdapter(Gun.class, new GunTypeAdapter(core))
                .setPrettyPrinting()
                .serializeNulls()
                .disableHtmlEscaping()
                .create();
    }
}
