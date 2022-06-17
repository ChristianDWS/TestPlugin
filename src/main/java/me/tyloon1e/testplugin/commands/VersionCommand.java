package me.tyloon1e.testplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VersionCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("testversion") || label.equalsIgnoreCase("tver")) {
            if (!(sender instanceof Player player)) {
                sender.sendMessage("Hello Console?");
                return true;
            }

            if (!player.hasPermission("testplugin.command.performance")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cYou don't have permission man."));
                return true;
            }

            String ver = Bukkit.getServer().getBukkitVersion();

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eThe server is running " + ver));
        }

        return false;
    }
}
