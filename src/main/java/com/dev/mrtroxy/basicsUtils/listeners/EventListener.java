package com.dev.mrtroxy.basicsUtils.listeners;

import com.dev.mrtroxy.basicsUtils.commands.GodCommand;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.entity.Player;

public class EventListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (GodCommand.isGodMode(player)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onHunger(FoodLevelChangeEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (GodCommand.isGodMode(player)) {
                event.setFoodLevel(20);
                event.setCancelled(true);
            }
        }
    }
}