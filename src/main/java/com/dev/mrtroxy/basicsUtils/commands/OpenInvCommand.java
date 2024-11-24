package com.dev.mrtroxy.basicsUtils.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import com.dev.mrtroxy.basicsUtils.utils.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class OpenInvCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("basicsUtils.openinv")) {
            sender.sendMessage(MessageUtil.getMessage("no_permission"));
            return true;
        }

        if (args.length < 1) {
            sender.sendMessage(MessageUtil.getMessage("usage_openinv"));
            return true;
        }

        if (!(sender instanceof Player)) {
            sender.sendMessage(MessageUtil.getMessage("player_only"));
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage(MessageUtil.getMessage("player_not_found"));
            return true;
        }

        Player player = (Player) sender;
        player.openInventory(target.getInventory());
        return true;
    }
}