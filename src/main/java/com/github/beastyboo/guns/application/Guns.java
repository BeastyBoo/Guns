package com.github.beastyboo.guns.application;

import com.github.beastyboo.guns.config.ManualAmmoConfig;
import com.github.beastyboo.guns.config.ManualGunConfig;
import com.github.beastyboo.guns.domain.util.LazyUtil;
import com.github.beastyboo.guns.usecase.FindAmmo;
import com.github.beastyboo.guns.usecase.FindGun;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Torbie on 19.11.2020.
 */
public class Guns {

    private final JavaPlugin plugin;
    private final ManualAmmoConfig ammo;
    private final ManualGunConfig gun;
    private final FindAmmo findAmmo;
    private final FindGun findGun;
    private final LazyUtil util;

    Guns(JavaPlugin plugin) {
        this.plugin = plugin;
        ammo = new ManualAmmoConfig(this);
        gun = new ManualGunConfig(this);
        findAmmo = ammo.findAmmo();
        findGun = gun.findGun();
        util = new LazyUtil();
    }

    void load() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Loading up Guns...");

        ammo.load();
    }

    void close() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Closing up Guns...");

        ammo.close();
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

    public ManualAmmoConfig getAmmo() {
        return ammo;
    }

    public ManualGunConfig getGun() {
        return gun;
    }

    public FindAmmo getFindAmmo() {
        return findAmmo;
    }

    public FindGun getFindGun() {
        return findGun;
    }

    public LazyUtil getUtil() {
        return util;
    }
}
