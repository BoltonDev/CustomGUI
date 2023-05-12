package fr.bolton.customgui.listeners;

import fr.bolton.customgui.inventory.InventoryBuilder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryListener implements Listener {

    @EventHandler
    public void onInteract(InventoryClickEvent e) {
        if(e.getView().getTopInventory().getHolder() instanceof InventoryBuilder inventoryBuilder) {

            if(inventoryBuilder.isInteractInventory()) {
                e.setCancelled(true);

                if(inventoryBuilder.getInventoryAction(e.getSlot()) != null) inventoryBuilder.getInventoryAction(e.getSlot()).onInteract((Player) e.getWhoClicked(), e.getAction());
            }
        }
    }
}
