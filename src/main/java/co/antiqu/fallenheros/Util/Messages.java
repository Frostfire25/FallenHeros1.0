package co.antiqu.fallenheros.Util;

import co.antiqu.fallenheros.FallenHeros;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;

public class Messages {

    public static final FileConfiguration config = FallenHeros.getInstance().getConfig();

    public static final String fallen_star_name = Color.t(config.getString("name"));

    public static final String invalid_arguments = Color.t(config.getString("invaled_arguments"));

    public static final String died_message = Color.t(config.getString("player_sent_message"));

    public static String sentMessage(String name, int amount) {
        return Color.t(config.getString("stars_given").replaceAll("%player%", name).replaceAll("%amount%", ""+amount));
    }

    public static ArrayList<String> getLore() {
        ArrayList<String> lore = new ArrayList<>();
        for(String n : config.getStringList("lore")) {
            lore.add(Color.t(n));
        }
        return lore;
    }

}
