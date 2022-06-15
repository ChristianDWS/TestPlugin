package me.tyloon1e.testplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class TestPluginCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("testplugin") || label.equalsIgnoreCase("test")) {
            if (!(sender instanceof Player player)) {
                sender.sendMessage("Hello Console?");
                return true;
            }

            if (!player.hasPermission("testplugin.command")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou don't have permission, naughty!"));
                return true;
            }

            if (args.length == 0) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Use: &f/test <about|heal|insult>"));
                return true;
            }

            if (args[0].equalsIgnoreCase("about")) {
                ArrayList<String> list = new ArrayList<>(Arrays.asList("This", "is", "the", "about", "command."));

                for (int i = 0; i < list.size(); i++) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', list.get(i)));
                }
                return true;
            }

            if (args[0].equalsIgnoreCase("heal")) {
                player.setHealth(20);
                player.setSaturation(20);
                player.sendMessage(ChatColor.GREEN + "You have been blessed!");
                return true;
            }

            if (args[0].equalsIgnoreCase("insult")) {
                player.kickPlayer("Bye bye");
                return true;
            }

            return true;
        }

        return false;
    }

}
