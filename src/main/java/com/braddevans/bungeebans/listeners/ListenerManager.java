package com.braddevans.bungeebans.listeners;

import com.braddevans.bungeebans.Bungeebans;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;


public class ListenerManager {

    public static void registerListener(Listener listener)
    {
        Bungeebans.getInstance().getServer().getPluginManager().registerEvents(listener,Bungeebans.getInstance());
    }

    public static void unRegisterListeners()
    {

        Bungeebans.getInstance().getServer().getPluginManager().disablePlugin(Bungeebans.getInstance());
        HandlerList.unregisterAll(Bungeebans.getInstance());
    }

}
