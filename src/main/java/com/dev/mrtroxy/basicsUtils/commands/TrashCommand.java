package com.dev.mrtroxy.basicsUtils.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import com.dev.mrtroxy.basicsUtils.utils.MessageUtil;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;

public class TrashCommand implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("basicsUtils.trash")) {
            sender.sendMessage(MessageUtil.getMessage("no_permission"));
            return true;
        }

        if (!(sender instanceof Player)) {
            sender.sendMessage(MessageUtil.getMessage("player_only"));
            return true;
        }

        Player player = (Player) sender;
        Inventory trash = Bukkit.createInventory(null, 54, "Trash");
        player.openInventory(trash);
        return true;
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        if (event.getView().getTitle().equals("Trash")) {
            event.getInventory().clear();
        }
    }
}