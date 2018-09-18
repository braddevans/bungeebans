package com.braddevans.bungeebans;


import com.braddevans.bungeebans.listeners.CommandListener;
import com.braddevans.bungeebans.listeners.ListenerManager;
import com.braddevans.bungeebans.timers.TimerHandler;
import org.bukkit.*;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Bungeebans extends JavaPlugin {

    private static Bungeebans instance;
    private final TimerHandler timerHandler = new TimerHandler();
    private FileConfiguration config;
    private ListenerManager listenermanager;

    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }

    public static Bungeebans getInstance() {
        return Bungeebans.instance;
    }


    @Override
    public void onEnable() {
        instance = this;
        this.config = this.getConfig();
        
        //Get config / default config here
        if (!(new File(getDataFolder(), "config.yml").exists())) {
            saveResource("config.yml", false);
        }

        //command
        instance.getCommand("Bungeebans").setExecutor(new CommandListener());

        //Start Tick timer
        getServer().getScheduler().scheduleSyncRepeatingTask(this, getTimerHandler(), 1200, 1200);

    }

    public void onDisable() {
        ListenerManager.unRegisterListeners();
    }

    public void reload(Bungeebans plugin){

        this.config = plugin.getConfig();
    }

    public TimerHandler getTimerHandler() {
        return timerHandler;
    }
}