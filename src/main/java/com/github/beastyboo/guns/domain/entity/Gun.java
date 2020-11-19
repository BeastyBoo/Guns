package com.github.beastyboo.guns.domain.entity;

import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Torbie on 19.11.2020.
 */
public class Gun {

    private final String name;
    private final ItemStack item;
    private final Ammo ammo;
    private final int maxClipSize;
    private final double damage;
    private final int reloadTime;
    private final int bulletPerShot;
    private final Sound sound;
    private final int shootDelay;
    private final int roundsPerBurst;
    private final double recoil;

    public static class Builder {

        private final String name;
        private final ItemStack item;
        private final Ammo ammo;
        private final int maxClipSize;
        private final double damage;

        private int shootDelay = 1;
        private int reloadTime = 3;
        private Sound sound = Sound.ENTITY_GHAST_SHOOT;
        private int roundsPerBurst = 1;
        private double recoil = 2;
        private int bulletPerShot = 1;

        public Builder(String name, ItemStack item, Ammo ammo, int maxClipSize, double damage) {
            this.name = name;
            this.item = item;
            this.ammo = ammo;
            this.maxClipSize = maxClipSize;
            this.damage = damage;

        }

        public Builder shootDelay(int value) {
            shootDelay = value;
            return this;
        }

        public Builder reloadTime(int value) {
            reloadTime = value;
            return this;
        }

        public Builder sound(Sound value) {
            sound = value;
            return this;
        }
        public Builder roundsPerBurst(int value) {
            roundsPerBurst = value;
            return this;
        }

        public Builder recoil(double value) {
            recoil = value;
            return this;
        }
        public Builder bulletPerShot(int value) {
            bulletPerShot = value;
            return this;
        }

        public Gun build() {
            return new Gun(this);
        }

    }

    private Gun(Builder builder) {
        name = builder.name;
        item = builder.item;
        ammo = builder.ammo;
        maxClipSize = builder.maxClipSize;
        damage = builder.damage;
        reloadTime = builder.reloadTime;
        bulletPerShot = builder.bulletPerShot;
        sound = builder.sound;
        shootDelay = builder.shootDelay;
        roundsPerBurst = builder.roundsPerBurst;
        recoil = builder.recoil;
    }

    public String getName() {
        return name;
    }

    public ItemStack getItem() {
        return item;
    }

    public Ammo getAmmo() {
        return ammo;
    }

    public int getMaxClipSize() {
        return maxClipSize;
    }

    public double getDamage() {
        return damage;
    }

    public int getReloadTime() {
        return reloadTime;
    }

    public int getBulletPerShot() {
        return bulletPerShot;
    }

    public Sound getSound() {
        return sound;
    }

    public int getShootDelay() {
        return shootDelay;
    }

    public int getRoundsPerBurst() {
        return roundsPerBurst;
    }

    public double getRecoil() {
        return recoil;
    }

}
