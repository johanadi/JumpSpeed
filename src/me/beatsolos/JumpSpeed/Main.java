package me.beatsolos.JumpSpeed;

import com.mojang.datafixers.types.templates.Check;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener {

    public void onEnable() {
        PluginManager pm = this.getServer().getPluginManager();

        pm.registerEvents(new CheckJump(), this);
        this.getCommand("resetspeed").setExecutor(new CommandReset());
    }
    public void onDisable() {

    }

}
