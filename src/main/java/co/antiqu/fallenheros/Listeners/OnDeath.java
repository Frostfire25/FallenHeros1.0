package co.antiqu.fallenheros.Listeners;

import co.antiqu.fallenheros.FallenHeros;
import co.antiqu.fallenheros.Objects.DeathList;
import co.antiqu.fallenheros.Util.Color;
import co.antiqu.fallenheros.Util.Messages;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;

public class OnDeath implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent evt) {
        Player player = (Player) evt.getEntity();
        if(checkInvForStar(player.getInventory())){
            DeathList.addPlayerToInventorys(player.getUniqueId(), player.getInventory());
            evt.getDrops().clear();
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent evt) {
        PlayerInventory deathinv = DeathList.getInventoryFromUUID(evt.getPlayer().getUniqueId());
        if(deathinv == null)
            return;
        for(ItemStack n : deathinv.getContents()) {
            if(n != null)
                if(n.getType() != Material.AIR && n.hasItemMeta() && Color.listAreEqual(n.getItemMeta().getLore(), Messages.getLore())) {
                    if(n.getAmount() == 1) {
                        deathinv.removeItem(n);
                    } else {
                        n.setAmount(n.getAmount()-1);
                    }
                }
        }

        for(ItemStack n : deathinv.getContents()) {
            if(n == null || n.getType() == Material.AIR)
                continue;
            evt.getPlayer().getInventory().addItem(n);
        }

        evt.getPlayer().getInventory().setBoots(deathinv.getBoots());
        evt.getPlayer().getInventory().setLeggings(deathinv.getLeggings());
        evt.getPlayer().getInventory().setChestplate(deathinv.getChestplate());
        evt.getPlayer().getInventory().setHelmet(deathinv.getHelmet());

        DeathList.removePlayerFromInventorys(evt.getPlayer().getUniqueId());

        evt.getPlayer().sendMessage(Messages.died_message);
        
    }

    private boolean checkInvForStar(Inventory inv) {
        for(ItemStack n : inv.getContents()) {
            if(n != null)
                if(n.getType() != Material.AIR && n.hasItemMeta() && Color.listAreEqual(n.getItemMeta().getLore(), Messages.getLore())) {
                return true;
            }
        }
        return false;
    }



}
