package com.github.beastyboo.guns.domain.entity;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.Random;

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
    private final int maxDistance;
    private final int bulletSpeed;
    private final double accuracy;

    public static class Builder {

        private final String name;
        private final ItemStack item;
        private final Ammo ammo;
        private final int maxClipSize;
        private final double damage;
        private final int maxDistance;
        private final int bulletSpeed;
        private final double accuracy;

        private int shootDelay = 1;
        private int reloadTime = 3;
        private Sound sound = Sound.ENTITY_GHAST_SHOOT;
        private int roundsPerBurst = 1;
        private double recoil = 2;
        private int bulletPerShot = 1;

        public Builder(String name, ItemStack item, Ammo ammo, int maxClipSize, double damage, int maxDistance, int bulletSpeed, double accuracy) {
            this.name = name;
            this.item = item;
            this.ammo = ammo;
            this.maxClipSize = maxClipSize;
            this.damage = damage;
            this.maxDistance = maxDistance;
            this.bulletSpeed = bulletSpeed;
            this.accuracy = accuracy;
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
        maxDistance = builder.maxDistance;
        bulletSpeed = builder.bulletSpeed;
        accuracy = builder.accuracy;
        reloadTime = builder.reloadTime;
        bulletPerShot = builder.bulletPerShot;
        sound = builder.sound;
        shootDelay = builder.shootDelay;
        roundsPerBurst = builder.roundsPerBurst;
        recoil = builder.recoil;
    }

    public void shoot(Player p) {
        Snowball bullet = p.launchProjectile(Snowball.class);

        //doRecoil.

        p.playSound(p.getLocation(), sound, 1.0F, 2.0F);


        /**
         * Accuracy and bullet speed from PvPGunPlus, a plugin which don't exist anymore.
         */

        int acc = (int) (accuracy * 1000.0D);
        if (acc <= 0) {
            acc = 1;
        }

        Location loc = p.getLocation();
        Random rand = new Random();

        double dir = -loc.getYaw() - 90.0F;
        double pitch = -loc.getPitch();
        double xwep = (rand.nextInt(acc) - rand.nextInt(acc) + 0.5D) / 1000.0D;
        double ywep = (rand.nextInt(acc) - rand.nextInt(acc) + 0.5D) / 1000.0D;
        double zwep = (rand.nextInt(acc) - rand.nextInt(acc) + 0.5D) / 1000.0D;

        double xd = Math.cos(Math.toRadians(dir)) * Math.cos(Math.toRadians(pitch)) + xwep;
        double yd = Math.sin(Math.toRadians(pitch)) + ywep;
        double zd = -Math.sin(Math.toRadians(dir)) * Math.cos(Math.toRadians(pitch)) + zwep;

        Vector vec = new Vector(xd, yd, zd);
        vec.multiply(bulletSpeed);

        bullet.setVelocity(vec);

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

    public int getMaxDistance() {
        return maxDistance;
    }

    public int getBulletSpeed() {
        return bulletSpeed;
    }

    public double getAccuracy() {
        return accuracy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gun gun = (Gun) o;

        if (getMaxClipSize() != gun.getMaxClipSize()) return false;
        if (Double.compare(gun.getDamage(), getDamage()) != 0) return false;
        if (getReloadTime() != gun.getReloadTime()) return false;
        if (getBulletPerShot() != gun.getBulletPerShot()) return false;
        if (getShootDelay() != gun.getShootDelay()) return false;
        if (getRoundsPerBurst() != gun.getRoundsPerBurst()) return false;
        if (Double.compare(gun.getRecoil(), getRecoil()) != 0) return false;
        if (!getName().equals(gun.getName())) return false;
        if (!getItem().equals(gun.getItem())) return false;
        if (!getAmmo().equals(gun.getAmmo())) return false;
        return getSound() == gun.getSound();
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getName().hashCode();
        result = 31 * result + getItem().hashCode();
        result = 31 * result + getAmmo().hashCode();
        result = 31 * result + getMaxClipSize();
        temp = Double.doubleToLongBits(getDamage());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getReloadTime();
        result = 31 * result + getBulletPerShot();
        result = 31 * result + getSound().hashCode();
        result = 31 * result + getShootDelay();
        result = 31 * result + getRoundsPerBurst();
        temp = Double.doubleToLongBits(getRecoil());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }



}
