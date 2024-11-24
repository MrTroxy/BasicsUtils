package com.dev.mrtroxy.basicsUtils.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import com.dev.mrtroxy.basicsUtils.utils.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import java.util.HashSet;
import java.util.Set;

public class GodCommand implements CommandExecutor {

    private static Set<Player> godModePlayers = new HashSet<>();

    public static boolean isGodMode(Player player) {
        return godModePlayers.contains(player);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("basicsUtils.god")) {
            sender.sendMessage(MessageUtil.getMessage("no_permission"));
            return true;
        }

        Player target;
        if (args.length > 0) {
            if (!sender.hasPermission("basicsUtils.god.others")) {
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

        if (godModePlayers.contains(target)) {
            godModePlayers.remove(target);
            target.sendMessage(MessageUtil.getMessage("godmode_disabled"));
            if (!target.equals(sender)) {
                sender.sendMessage(MessageUtil.getMessage("godmode_disabled_other", "{player}", target.getName()));
            }
        } else {
            godModePlayers.add(target);
            target.sendMessage(MessageUtil.getMessage("godmode_enabled"));
            if (!target.equals(sender)) {
                sender.sendMessage(MessageUtil.getMessage("godmode_enabled_other", "{player}", target.getName()));
            }
        }
        return true;
    }
}