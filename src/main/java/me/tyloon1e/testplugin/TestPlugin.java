package me.tyloon1e.testplugin;

import me.tyloon1e.testplugin.commands.TestPluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("TestPlugin has been enabled, woo!");

        this.getCommand("testplugin").setExecutor(new TestPluginCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("TestPlugin has been disabled. So sad.");
    }
}
