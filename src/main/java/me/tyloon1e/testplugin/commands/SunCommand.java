package me.tyloon1e.testplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SunCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("testsun") || label.equalsIgnoreCase("tsun")) {
            if (!(sender instanceof Player player)) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cNOPE!"));
                return true;
            }

            if (!player.hasPermission("testplugin.command.sun")) {
                sender.sendMessage(ChatColor.RED + "NOPE!");
            }

            player.getWorld().setStorm(false);
            player.getWorld().setThundering(false); // unclear if needed

            Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&e&lThe sun is out!"));
            return true;
        }

        return false;
    }
}
