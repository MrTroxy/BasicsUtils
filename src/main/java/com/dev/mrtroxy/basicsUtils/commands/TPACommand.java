package com.dev.mrtroxy.basicsUtils.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import com.dev.mrtroxy.basicsUtils.utils.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class TPACommand implements CommandExecutor {

    public static HashMap<UUID, UUID> tpaRequests = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("basicsUtils.tpa")) {
            sender.sendMessage(MessageUtil.getMessage("no_permission"));
            return true;
        }

        if (args.length < 1) {
            sender.sendMessage(MessageUtil.getMessage("usage_tpa"));
            return true;
        }

        if (!(sender instanceof Player)) {
            sender.sendMessage(MessageUtil.getMessage("player_only"));
            return true;
        }

        Player player = (Player) sender;
        Player target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            player.sendMessage(MessageUtil.getMessage("player_not_found"));
            return true;
        }

        tpaRequests.put(target.getUniqueId(), player.getUniqueId());
        player.sendMessage(MessageUtil.getMessage("tpa_request_sent", "{player}", target.getName()));
        target.sendMessage(MessageUtil.getMessage("tpa_request_received", "{player}", player.getName()));
        return true;
    }
}