package com.braddevans.bungeebans.utils;

import com.braddevans.bungeebans.Bungeebans;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

public class ChatUtils {
    public static void sendToAllPlayers(String message) {
        List<Player> playerList = (List<Player>) VersionUtils.getOnlinePlayers();
        for (Player otherPlayer : playerList) {
            otherPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
        }
    }

    public static void doLog(String message) {
        if (Bungeebans.getInstance().getConfig().getBoolean("Plugin.Debug")) {
            Bungeebans.getInstance().getLogger().info(message);
        }
    }
}
