package pickaxeplus.me.meerzean.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pickaxeplus.me.meerzean.other.addPickaxesToList;
import pickaxeplus.me.meerzean.other.itemCreator;
import pickaxeplus.me.meerzean.other.ymlProcesses;

import java.util.ArrayList;

public class pickaxeListener implements Listener {


    @EventHandler
    public void onPickaxeRightClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Material item = e.getPlayer().getInventory().getItemInMainHand().getType();
        ArrayList<Material> pickaxes = addPickaxesToList.addPickaxes();
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (player.isSneaking() && pickaxes.contains(item) && player.hasPermission("pickaxemenu.use")) {
                String title = ChatColor.translateAlternateColorCodes('&', ymlProcesses.getMenuString("menuTitle"));
                Inventory menu = Bukkit.createInventory(player, 27, title);
                ItemStack item1 = itemCreator.itemCreate( "unbreaking", player);
                ItemStack item2 = itemCreator.itemCreate("efficiency", player);
                ItemStack item3 = itemCreator.itemCreate("fortune", player);
                ItemStack item4 = itemCreator.itemCreate("mending", player);
                ItemStack item5 = itemCreator.itemCreate("silktouch", player);

                menu.setItem(9, item1);
                menu.setItem(11, item2);
                menu.setItem(13, item3);
                menu.setItem(15, item4);
                menu.setItem(17, item5);

                player.openInventory(menu);

            }
        }
    }


}
