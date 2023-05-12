package fr.bolton.customgui.inventory;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class InventoryBuilder implements InventoryHolder {

    private final String title;
    private final int size;
    private final Map<Integer, ItemStack> inventoryContents = new HashMap<>();
    private boolean isInteractInventory;
    private final Map<Integer, InventoryActions> inventoryActions = new HashMap<>();

    public interface InventoryActions {
        void onInteract(Player player, InventoryAction action);
    }

    /**
     * Create a custom GUI
     *
     * @param title title of the inventory
     * @param size size of the inventory, can be one of these values 9, 18, 27, 36, 45, 54
     * @param isInteractInventory define if items can be picked up in the inventory
     */
    public InventoryBuilder(String title, int size, boolean isInteractInventory) {
        this.title = title;
        this.size = size;
        this.isInteractInventory = isInteractInventory;
    }

    /**
     * Set an itemstack in a specific slot
     *
     * @param slot slot number
     * @param item itemstack
     * @return InventoryBuilder
     */
    public InventoryBuilder setItem(int slot, ItemStack item) {
        inventoryContents.put(slot, item);
        return this;
    }

    /**
     * Get the itemstack from a specific slot
     *
     * @param slot slot number
     * @return ItemStack in the slot
     */
    public ItemStack getItem(int slot) {
        return inventoryContents.get(slot);
    }

    /**
     * Clear the content of the inventory
     */
    public void clear() {
        inventoryContents.clear();
    }

    /**
     * Define if the inventory is an interact inventory
     *
     * @param value true/false
     */
    public void setInteractInventory(boolean value) {
        this.isInteractInventory = value;
    }

    /**
     * If it's an interact inventory
     *
     * @return true/false
     */
    public boolean isInteractInventory() {
        return this.isInteractInventory;
    }

    /**
     * Set interact action for a slot
     *
     * @param actions
     * @param slot slot number
     * @return InventoryBuilder
     */
    public InventoryBuilder setInteractAction(InventoryActions actions, int slot) {
        this.inventoryActions.put(slot, actions);
        return this;
    }

    /**
     * Get action for a specific slot
     *
     * @param slot slot number
     * @return action of slot
     */
    public InventoryActions getInventoryAction(int slot) {
        return this.inventoryActions.get(slot);
    }

    /**
     * Remove all actions of the inventory
     */
    public void clearInventoryActions() {
        this.inventoryActions.clear();
    }

    /**
     * @return title of the inventory
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @return size of the inventory
     */
    public int getSize() {
        return this.size;
    }

    /**
     * @return Inventory created from InventoryBuilder
     */
    @Override
    public Inventory getInventory() {
        Inventory inv = Bukkit.createInventory(this, this.size, this.title);

        for (Map.Entry<Integer, ItemStack> entry : this.inventoryContents.entrySet()) {
            inv.setItem(entry.getKey(), entry.getValue());
        }

        return inv;
    }
}
