package me.VAL.welcomeManager;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class WelcomeManager extends JavaPlugin {

    public static WelcomeManager instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        instance = this;
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
    }

}
