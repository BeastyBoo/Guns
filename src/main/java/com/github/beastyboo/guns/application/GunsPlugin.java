package com.github.beastyboo.guns.application;

import org.bukkit.plugin.java.JavaPlugin;

public final class GunsPlugin extends JavaPlugin {

    private Guns guns;

    @Override
    public void onEnable() {
        guns = new Guns(this);
        guns.load();

    }

    @Override
    public void onDisable() {
        guns.close();
        guns = null;
    }
}
