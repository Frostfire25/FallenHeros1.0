package co.antiqu.fallenheros.Util;

import co.antiqu.fallenheros.FallenHeros;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.RegisteredServiceProvider;

public class Vault {
    public static Permission permission = null;
    public static Economy economy = null;
    public static Chat chat = null;



    public static void setup() {
        setupPermissions();
        setupChat();
        setupEconomy();
    }

    private static boolean setupPermissions()
    {
        RegisteredServiceProvider<Permission> permissionProvider = FallenHeros.getInstance().getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }

    private static boolean setupChat()
    {
        RegisteredServiceProvider<Chat> chatProvider = FallenHeros.getInstance().getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
        if (chatProvider != null) {
            chat = chatProvider.getProvider();
        }

        return (chat != null);
    }

    private static boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = FallenHeros.getInstance().getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }

    public static Economy getEconomy() {
        return economy;
    }

    public static void setEconomy(Economy econ) {
        economy = econ;
    }
}


