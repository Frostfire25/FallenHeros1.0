package co.antiqu.fallenheros.Objects;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;

import java.util.HashMap;
import java.util.UUID;

public class DeathList {

    public static HashMap<UUID, PlayerInventory> inventorys;

    public DeathList() {
        inventorys = new HashMap<>();
    }

    public static void addPlayerToInventorys(UUID uuid, PlayerInventory inventory) {
        inventorys.put(uuid,inventory);
    }

    public static void removePlayerFromInventorys(UUID uuid) {
        inventorys.remove(uuid);
    }

    public static PlayerInventory getInventoryFromUUID(UUID uuid) {
        if(inventorys.containsKey(uuid))
            return inventorys.get(uuid);
        return null;
    }


}
