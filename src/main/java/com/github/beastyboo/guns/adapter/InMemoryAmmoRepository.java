package com.github.beastyboo.guns.adapter;

import com.github.beastyboo.guns.adapter.type.AmmoTypeAdapter;
import com.github.beastyboo.guns.application.Guns;
import com.github.beastyboo.guns.domain.entity.Ammo;
import com.github.beastyboo.guns.domain.port.AmmoRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.*;

/**
 * Created by Torbie on 19.11.2020.
 */

public class InMemoryAmmoRepository implements AmmoRepository{

    private final Guns core;
    private final Gson gson;
    private final Map<String, Ammo> inMemoryByName;
    private final Map<Material, Ammo> inMemoryByMaterial;
    private final File folder;

    public InMemoryAmmoRepository(Guns core) {
        this.core = core;
        gson = this.createGsonInstance();
        inMemoryByName = new HashMap<>();
        inMemoryByMaterial = new HashMap<>();
        folder = new File(core.getPlugin().getDataFolder(), "ammo");
    }

    @Override
    public void load() {
        if(!folder.exists()) {
            folder.mkdirs();
        }
        File[] directoryListing = folder.listFiles();
        if (directoryListing == null) {
            return;
        }
        for (File child : directoryListing) {
            String json = core.getUtil().loadContent(child);
            Ammo ammo = this.deserialize(json);

            inMemoryByName.put(ammo.getName().toLowerCase(), ammo);
            inMemoryByMaterial.put(ammo.getItem().getType(), ammo);
        }
    }

    @Override
    public void close() {
        for(Ammo ammo : inMemoryByName.values()) {
            File file = new File(folder, ammo.getName().toLowerCase() + ".json");
            if(!folder.exists()) {
                folder.mkdirs();
            }
            String json = this.serialize(ammo);
            core.getUtil().saveFile(file, json);
        }
    }

    @Override
    public Optional<Ammo> getAmmoByName(String name) {
        return Optional.ofNullable(inMemoryByName.get(name.toLowerCase()));
    }

    @Override
    public Optional<Ammo> getAmmoByItemStack(ItemStack item) {
        return Optional.ofNullable(inMemoryByMaterial.get(item.getType()));
    }

    @Override
    public Set<Ammo> findAllAmmo() {
        return new HashSet<>(inMemoryByName.values());
    }

    private Gson createGsonInstance() {
        return new GsonBuilder().registerTypeAdapter(Ammo.class, new AmmoTypeAdapter())
                .setPrettyPrinting()
                .serializeNulls()
                .disableHtmlEscaping()
                .create();
    }

    private String serialize(Ammo ammo) {
        return this.gson.toJson(ammo);
    }

    private Ammo deserialize(String json) {
        return this.gson.fromJson(json, Ammo.class);
    }

}
