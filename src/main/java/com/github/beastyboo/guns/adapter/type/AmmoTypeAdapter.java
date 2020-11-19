package com.github.beastyboo.guns.adapter.type;

import com.github.beastyboo.guns.domain.entity.Ammo;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Torbie on 19.11.2020.
 */
public class AmmoTypeAdapter extends TypeAdapter<Ammo>{

    public AmmoTypeAdapter() {
    }

    @Override
    public void write(JsonWriter writer, Ammo ammo) throws IOException {
        writer.beginObject();

        writer.name("name").value(ammo.getName());

        writer.name("material").value(ammo.getItem().getType().toString());

        writer.name("lore").beginArray();
        for(String lore : ammo.getItem().getLore()) {
            writer.beginObject();

            writer.name("string").value(lore);

            writer.endObject();
        }
        writer.endArray();

        writer.endObject();
    }

    @Override
    public Ammo read(JsonReader reader) throws IOException {
        reader.beginObject();

        String name = "";
        Material material = null;
        List<String> lore = new ArrayList<>();

        while (reader.hasNext()) {
            switch (reader.nextName()) {
                case "name":
                    name = reader.nextString();
                    break;
                case "material":
                    material = Material.getMaterial(reader.nextString());
                    break;
                case "lore":
                    reader.beginArray();
                    while (reader.hasNext()) {
                        reader.beginObject();

                        while(reader.hasNext()) {
                            switch (reader.nextName()) {
                                case "string":
                                    lore.add(reader.nextString());
                                    break;
                            }
                        }

                        reader.endObject();
                    }
                    reader.endArray();
            }
        }

        ItemStack itemStack = new ItemStack(material, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        Ammo ammo = new Ammo(name, itemStack);
        reader.endObject();
        return ammo;
    }
}
