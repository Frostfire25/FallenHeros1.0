package co.antiqu.fallenheros.Commands;

import co.antiqu.fallenheros.FallenHeros;
import co.antiqu.fallenheros.Util.Messages;
import co.antiqu.fallenheros.Util.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GiveStar implements CommandExecutor {

    public static final FileConfiguration config = FallenHeros.getInstance().getConfig();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player snd = (Player) sender;
            if(!snd.hasPermission(""+Permissions.USE))
                return false;

            Player args1;
            int args2;

            if(args.length != 2) {
                snd.sendMessage(Messages.invalid_arguments);
                return false;
            }

            try {
                args1 = Bukkit.getPlayer(args[0]);
            } catch (Exception e) {
                snd.sendMessage(Messages.invalid_arguments);
                return false;
            }

            try {
                args2 = Integer.valueOf(args[1]);
                if(args2 <= 0)
                    throw new Exception("Incorrect size");
            } catch (Exception e) {
                snd.sendMessage(Messages.invalid_arguments);
                return false;
            }
            ItemStack item = new ItemStack(Material.getMaterial(config.getString("star_material")));
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName(Messages.fallen_star_name);
            itemMeta.setLore(Messages.getLore());
            item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
            item.setItemMeta(itemMeta);

            for(int i = 0; i < args2; i++) {
                if(args1.getInventory().getSize() == -1) {
                    args1.getWorld().dropItem(args1.getLocation(), item);
                } else {
                    args1.getInventory().addItem(item);
                }
                snd.sendMessage(Messages.sentMessage(args1.getName(), args2));
            }



        } else



            {

            Player args1;
            int args2;

            try {
                args1 = Bukkit.getPlayer(args[0]);
            } catch (Exception e) {
                return false;
            }

            try {
                args2 = Integer.valueOf(args[1]);
                if(args2 <= 0)
                    throw new Exception("Incorrect size");
            } catch (Exception e) {
                return false;
            }
            ItemStack item = new ItemStack(Material.getMaterial(config.getString("star_material")));
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName(Messages.fallen_star_name);
            itemMeta.setLore(Messages.getLore());
            item.addEnchantment(Enchantment.DURABILITY, 1);
            item.setItemMeta(itemMeta);

            for(int i = 0; i < args2; i++) {
                if(args1.getInventory().getSize() == -1) {
                    args1.getWorld().dropItem(args1.getLocation(), item);
                } else {
                    args1.getInventory().addItem(item);
                }
            }
        }

        return false;
    }
}
