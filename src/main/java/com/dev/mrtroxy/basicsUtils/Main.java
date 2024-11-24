package com.dev.mrtroxy.basicsUtils;

import com.dev.mrtroxy.basicsUtils.listeners.EventListener;
import org.bukkit.plugin.java.JavaPlugin;
import com.dev.mrtroxy.basicsUtils.commands.*;
import com.dev.mrtroxy.basicsUtils.listeners.TPAListener;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        // Register commands
        getCommand("gamemode").setExecutor(new GamemodeCommand());
        getCommand("god").setExecutor(new GodCommand());
        getCommand("openinv").setExecutor(new OpenInvCommand());
        getCommand("enderchest").setExecutor(new EnderChestCommand());
        getCommand("fix").setExecutor(new FixCommand());
        getCommand("tpa").setExecutor(new TPACommand());
        getCommand("trash").setExecutor(new TrashCommand());

        // Register listeners
        getServer().getPluginManager().registerEvents(new TPAListener(), this);
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        getServer().getPluginManager().registerEvents(new TrashCommand(), this);
    }

    public static Main getInstance() {
        return instance;
    }
}