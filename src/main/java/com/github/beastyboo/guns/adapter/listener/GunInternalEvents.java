package com.github.beastyboo.guns.adapter.listener;

import com.github.beastyboo.guns.application.Guns;
import com.github.beastyboo.guns.domain.entity.Gun;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * Created by Torbie on 20.11.2020.
 */
public class GunInternalEvents implements Listener {

    private final Guns core;
    private final Set<UUID> zoomed;
    private final PotionEffect zoomPotion;

    public GunInternalEvents(Guns core) {
        this.core = core;
        zoomed = new HashSet<>();
        zoomPotion = new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 3, true);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if(event.getAction() == null) {
            return;
        }

        Player p = event.getPlayer();

        if(!event.getHand().equals(EquipmentSlot.HAND)) {
            return;
        }

        Optional<Gun> gun = core.getFindGun().getGunByItemStack(p.getInventory().getItemInMainHand());

        if(!gun.isPresent()) {
            return;
        }

        if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            gun.get().shoot(p);
        } else {
            this.setZooming(p, !this.zoomed.contains(p.getUniqueId()));
        }
    }

    @EventHandler
    public void onSwitchItems(PlayerItemHeldEvent event) {
        Player p = event.getPlayer();

        Optional<Gun> gun = core.getFindGun().getGunByItemStack(p.getInventory().getItemInMainHand());

        if(!gun.isPresent()) {
            return;
        }

        this.setZooming(p, false);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event)
    {
        setZooming(event.getPlayer(), false);
    }

    private void setZooming(Player p, boolean value) {
        boolean zoom = (value) && (!this.zoomed.contains(p.getUniqueId()));
        if (zoom)
        {
            this.zoomed.add(p.getUniqueId());
            p.addPotionEffect(zoomPotion);
        }
        else
        {
            this.zoomed.remove(p.getUniqueId());
            p.removePotionEffect(zoomPotion.getType());
        }
    }

}
