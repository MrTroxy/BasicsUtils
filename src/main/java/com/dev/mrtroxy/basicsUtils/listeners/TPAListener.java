package com.dev.mrtroxy.basicsUtils.listeners;

import com.dev.mrtroxy.basicsUtils.commands.TPACommand;
import com.dev.mrtroxy.basicsUtils.utils.MessageUtil;
import com.dev.mrtroxy.basicsUtils.Main;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import java.util.UUID;

public class TPAListener implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        String msg = event.getMessage().toLowerCase();
        Player player = event.getPlayer();

        if (msg.equals("/tpaccept")) {
            UUID requesterUUID = TPACommand.tpaRequests.get(player.getUniqueId());
            if (requesterUUID == null) {
                player.sendMessage(MessageUtil.getMessage("no_tpa_request"));
                event.setCancelled(true);
                return;
            }

            Player requester = Main.getInstance().getServer().getPlayer(requesterUUID);
            if (requester != null) {
                requester.teleport(player.getLocation());
                requester.sendMessage(MessageUtil.getMessage("tpa_request_accepted"));
                player.sendMessage(MessageUtil.getMessage("tpa_request_acceptor"));
            } else {
                player.sendMessage(MessageUtil.getMessage("player_not_found"));
            }
            TPACommand.tpaRequests.remove(player.getUniqueId());
            event.setCancelled(true);
        } else if (msg.equals("/tpdeny")) {
            UUID requesterUUID = TPACommand.tpaRequests.get(player.getUniqueId());
            if (requesterUUID == null) {
                player.sendMessage(MessageUtil.getMessage("no_tpa_request"));
                event.setCancelled(true);
                return;
            }

            Player requester = Main.getInstance().getServer().getPlayer(requesterUUID);
            if (requester != null) {
                requester.sendMessage(MessageUtil.getMessage("tpa_request_denied"));
                player.sendMessage(MessageUtil.getMessage("tpa_request_denied_sender"));
            } else {
                player.sendMessage(MessageUtil.getMessage("player_not_found"));
            }
            TPACommand.tpaRequests.remove(player.getUniqueId());
            event.setCancelled(true);
        }
    }
}