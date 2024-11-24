package com.dev.mrtroxy.basicsUtils.utils;

import org.bukkit.ChatColor;
import com.dev.mrtroxy.basicsUtils.Main;

public class MessageUtil {

    public static String getMessage(String path) {
        String message = Main.getInstance().getConfig().getString(path);
        if (message == null) return "";
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String getMessage(String path, String placeholder, String value) {
        String message = getMessage(path);
        return message.replace(placeholder, value);
    }
}