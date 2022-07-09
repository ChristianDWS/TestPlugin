package me.tyloon1e.testplugin;

import me.tyloon1e.testplugin.commands.VersionCommand;
import me.tyloon1e.testplugin.commands.SunCommand;
import me.tyloon1e.testplugin.commands.TestCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class TestPlugin extends JavaPlugin {

    public static TestPlugin plugin;
    private File customConfigFile;
    private FileConfiguration customConfig;

    @Override
    public void onEnable() {
        plugin = this;

        createCustomConfig();

        this.getCommand("testplugin").setExecutor(new TestCommand());
        this.getCommand("testversion").setExecutor(new VersionCommand());
        this.getCommand("testsun").setExecutor(new SunCommand());

        getLogger().info("TestPlugin has been enabled, woo!");
    }

    @Override
    public void onDisable() {
        getLogger().info("TestPlugin has been disabled. So sad.");
    }

    public FileConfiguration getCustomConfig() {
        return this.customConfig;
    }

    // creates a "custom.yml" config file (if not already present)
    private void createCustomConfig() {
        customConfigFile = new File(getDataFolder(), "custom.yml");

        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            saveResource("custom.yml", false); // copies file from resources folder in JAR
        }

        customConfig = new YamlConfiguration();
        YamlConfiguration.loadConfiguration(customConfigFile); // loads configuration and handles possible errors
    }
}
