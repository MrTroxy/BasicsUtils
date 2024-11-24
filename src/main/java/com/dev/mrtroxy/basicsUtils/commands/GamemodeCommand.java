package com.dev.mrtroxy.basicsUtils.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import com.dev.mrtroxy.basicsUtils.utils.MessageUtil;

public class GamemodeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("basicsUtils.gamemode")) {
            sender.sendMessage(MessageUtil.getMessage("no_permission"));
            return true;
        }

        if (args.length < 1) {
            sender.sendMessage(MessageUtil.getMessage("usage_gamemode"));
            return true;
        }

        GameMode mode = null;
        switch (args[0].toLowerCase()) {
            case "survival":
            case "0":
                mode = GameMode.SURVIVAL;
                break;
            case "creative":
            case "1":
                mode = GameMode.CREATIVE;
                break;
            case "adventure":
            case "2":
                mode = GameMode.ADVENTURE;
                break;
            case "spectator":
            case "3":
                mode = GameMode.SPECTATOR;
                break;
            default:
                sender.sendMessage(MessageUtil.getMessage("invalid_gamemode"));
                return true;
        }

        Player target;
        if (args.length > 1) {
            if (!sender.hasPermission("basicsUtils.gamemode.others")) {
                sender.sendMessage(MessageUtil.getMessage("no_permission"));
                return true;
            }
            target = Bukkit.getPlayer(args[1]);
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

        target.setGameMode(mode);
        target.sendMessage(MessageUtil.getMessage("gamemode_set", "{mode}", mode.name()));
        if (!target.equals(sender)) {
            sender.sendMessage(MessageUtil.getMessage("gamemode_set_other", "{player}", target.getName())
                    .replace("{mode}", mode.name()));
        }
        return true;
    }
}