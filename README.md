# CustomGUI

**Version** : 1.0.1
**Developer** : Bolton

Allows you to create a custom inventory/gui with actions

## Installation

Download the Jar file here : https://github.com/BoltonDev/CustomGUI/releases/tag/v1.0.1 <br/>
Then, you just have to implement it in your `build.gradle`.

## How to use

Example of custom inventory creation

```Java
        // InventoryBuilder(title, size, isInteractInventory)
        Inventory inventoryBuilder = new InventoryBuilder("Random title here", 45, true)
                .setItem(0, new ItemStack(Material.CLOCK))
                .setItem(1, new ItemStack(Material.ANVIL))
                .setInteractAction((player, action) -> player.sendMessage("CLOCK Item"), 0)
                .setInteractAction((player, action) -> player.sendMessage("ANVIL Item"), 1)
                .setInteractAction((player, action) -> player.sendMessage("No item here"), 10)
                .getInventory();

        // "p" -> Player
        p.openInventory(inventoryBuilder);
```
![](https://github.com/BoltonDev/CustomGUI/blob/master/example-customgui.gif)
