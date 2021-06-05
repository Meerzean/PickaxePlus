package pickaxeplus.me.meerzean;

import org.bukkit.Bukkit;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.java.JavaPlugin;
import pickaxeplus.me.meerzean.commands.pickaxeCommand;
import pickaxeplus.me.meerzean.events.menuListener;
import pickaxeplus.me.meerzean.events.pickaxeListener;
import pickaxeplus.me.meerzean.other.ymlProcesses;

import java.io.IOException;

public final class PickaxeMain extends JavaPlugin {


    public static PickaxeMain plugin;


    @Override
    public void onEnable() {
        plugin = this;
        // Plugin startup logic
        getCommand("pickaxeplus").setExecutor(new pickaxeCommand());
        Bukkit.getPluginManager().registerEvents(new pickaxeListener(), this);
        Bukkit.getPluginManager().registerEvents(new menuListener(), this);
        saveDefaultConfig();
        try {
            ymlProcesses.createMenuFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
