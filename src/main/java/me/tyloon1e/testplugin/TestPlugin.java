package me.tyloon1e.testplugin;

import me.tyloon1e.testplugin.commands.VersionCommand;
import me.tyloon1e.testplugin.commands.SunCommand;
import me.tyloon1e.testplugin.commands.TestCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("TestPlugin has been enabled, woo!");

        this.getCommand("testplugin").setExecutor(new TestCommand());
        this.getCommand("testversion").setExecutor(new VersionCommand());
        this.getCommand("testsun").setExecutor(new SunCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("TestPlugin has been disabled. So sad.");
    }
}
