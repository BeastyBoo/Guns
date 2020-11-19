package com.github.beastyboo.guns.adapter.type;

import com.github.beastyboo.guns.application.Guns;
import com.github.beastyboo.guns.domain.entity.Gun;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by Torbie on 19.11.2020.
 */
public class GunTypeAdapter extends TypeAdapter<Gun> {

    private final Guns core;

    public GunTypeAdapter(Guns core) {
        this.core = core;
    }

    @Override
    public void write(JsonWriter out, Gun value) throws IOException {

    }

    @Override
    public Gun read(JsonReader in) throws IOException {
        return null;
    }
}
