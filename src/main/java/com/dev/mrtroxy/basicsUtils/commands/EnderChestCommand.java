package com.dev.mrtroxy.basicsUtils.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import com.dev.mrtroxy.basicsUtils.utils.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class EnderChestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("basicsUtils.enderchest")) {
            sender.sendMessage(MessageUtil.getMessage("no_permission"));
            return true;
        }

        Player target;
        if (args.length > 0) {
            if (!sender.hasPermission("basicsUtils.enderchest.others")) {
                sender.sendMessage(MessageUtil.getMessage("no_permission"));
                return true;
            }
            target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                sender.sendMessage(MessageUtil.getMessage("player_not_found"));
                return true;
            }
        } else {
            if (!(sender instanceof Player)) {
                sender.sendMessage(MessageUtil.getMessage("player_only"));
                return true;
            }
            target = (Player) sender;
        }

        ((Player) sender).openInventory(target.getEnderChest());
        return true;
    }
}