package com.braddevans.bungeebans.listeners;

import com.braddevans.bungeebans.Bungeebans;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;

public class CommandListener implements CommandExecutor {

    @EventHandler
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[]args){


        if(cmd.getName().equalsIgnoreCase("Bungeebans")){
            if (args.length == 0) {
                sendCommandUse(sender);
            } else {
                switch(args[0].toLowerCase())
                {
                    case "reload":
                        Bungeebans.getInstance().getConfig();
                        break;
                    default:
                        sendCommandUse(sender);
                }
            }
        }
    return false;
    }

    private void sendCommandUse(CommandSender sender) {
        sender.sendMessage("====incorrect usage====        ");
        sender.sendMessage("                               ");
        sender.sendMessage("the possible CommandListener are      ");
        sender.sendMessage("                               ");
        sender.sendMessage(ChatColor.GOLD+"/bungeebans"+ChatColor.AQUA+" reload");
    }


}