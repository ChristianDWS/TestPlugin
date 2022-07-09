package me.tyloon1e.testplugin.commands;

import me.tyloon1e.testplugin.TestPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class VersionCommand implements CommandExecutor {

    FileConfiguration customConfig = TestPlugin.plugin.getCustomConfig();

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

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eThe server is running " + Bukkit.getServer().getBukkitVersion()));
            sender.sendMessage("The result of key 'test-option' is " + customConfig.getBoolean("test-option"));
        }

        return false;
    }
}
