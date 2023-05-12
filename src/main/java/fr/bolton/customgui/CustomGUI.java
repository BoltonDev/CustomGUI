package fr.bolton.customgui;

import fr.bolton.customgui.listeners.InventoryListener;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomGUI extends JavaPlugin {

    private static CustomGUI instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        Bukkit.getPluginManager().registerEvents(new InventoryListener(), this);
    }

    public CustomGUI getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        HandlerList.unregisterAll();
        instance = null;
    }
}
