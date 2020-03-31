package co.antiqu.fallenheros;

import co.antiqu.fallenheros.Commands.GiveStar;
import co.antiqu.fallenheros.Listeners.OnDeath;
import co.antiqu.fallenheros.Objects.DeathList;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class FallenHeros extends JavaPlugin {

    public static FallenHeros instance;
    public static DeathList deathList;

    @Override
    public void onEnable() {
        instance = this;
        getConfig().options().copyDefaults(true);
        saveConfig();
        Bukkit.getPluginManager().registerEvents(new OnDeath(), this);
        getCommand("givestar").setExecutor(new GiveStar());
        deathList = new DeathList();
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static FallenHeros getInstance() {
        return instance;
    }



}
