package me.sebbaindustries.advancedafk.utils;

import me.sebbaindustries.advancedafk.Core;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Objects;

/**
 * @author sebbaindustries
 * @version 1.0
 * @see me.sebbaindustries.advancedafk.global.GlobalCore
 */
public class FileManager {

    private final Core core;

    public FileManager(Core core) {
        this.core = core;
        generateREADME();
        generateMessages();
        generateSettings();
        generateConfiguration();
    }

    /*
    README.md File
     */

    /**
     * Generates README.md File
     */
    public void generateREADME() {
        File README = new File(core.getDataFolder(), "README.md");

        if (!README.exists()) {
            core.saveResource("README.md", false);
        }
    }

    /*
    messages.xml file
     */

    public File messages;

    /**
     * Generates messages.xml File
     */
    public void generateMessages() {
        if (messages == null) {
            messages = new File(core.getDataFolder(), "messages.xml");
        }
        if (!messages.exists()) {
            core.saveResource("messages.xml", false);
        }
    }

    /*
    settings.xml
     */

    public File settings;

    /**
     * Generates settings.xml File
     */
    public void generateSettings() {
        if (settings == null) {
            settings = new File(core.getDataFolder(), "settings.xml");
        }
        if (!settings.exists()) {
            core.saveResource("settings.xml", false);
        }
    }

    /*
    configuration.yml
     */

    private FileConfiguration fileConfiguration = null;
    private File configuration = null;

    /**
     * Generates configuration.yml File
     */
    public void generateConfiguration() {
        if (configuration == null) {
            configuration = new File(core.getDataFolder(), "configuration.yml");
        }
        if (!configuration.exists()) {
            core.saveResource("configuration.yml", false);
        }
    }

    /**
     * @return configuration file
     * @see FileConfiguration
     */
    public FileConfiguration getConfiguration() {
        if (fileConfiguration == null) {
            reloadConfiguration();
        }
        return fileConfiguration;
    }

    /**
     * @see YamlConfiguration
     * @see Reader
     * Reloads or creates new configuration file
     */
    public void reloadConfiguration() {
        if (configuration == null) {
            configuration = new File(core.getDataFolder(), "configuration.yml");

        }
        fileConfiguration = YamlConfiguration.loadConfiguration(configuration);

        Reader defConfigStream = new InputStreamReader(Objects.requireNonNull(core.getResource("configuration.yml")));
        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
        fileConfiguration.setDefaults(defConfig);
    }

}
