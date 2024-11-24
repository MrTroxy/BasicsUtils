package com.dev.mrtroxy.basicsUtils.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import com.dev.mrtroxy.basicsUtils.utils.MessageUtil;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class FixCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("basicsUtils.fix")) {
            sender.sendMessage(MessageUtil.getMessage("no_permission"));
            return true;
        }

        if (!(sender instanceof Player)) {
            sender.sendMessage(MessageUtil.getMessage("player_only"));
            return true;
        }

        Player player = (Player) sender;
        ItemStack item = player.getInventory().getItemInMainHand();

        if (item == null || item.getType().isAir()) {
            player.sendMessage(MessageUtil.getMessage("no_item_in_hand"));
            return true;
        }

        item.setDurability((short) 0);
        player.sendMessage(MessageUtil.getMessage("item_repaired"));
        return true;
    }
}