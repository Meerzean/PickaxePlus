package pickaxeplus.me.meerzean.other;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class itemCreator {


    public static ItemStack itemCreate(String section, Player player) {
        Material holdingItem = player.getInventory().getItemInMainHand().getType();
        ItemStack item = new ItemStack(holdingItem);
        ItemMeta meta = item.getItemMeta();
        String price = ymlProcesses.getMenuIntAsString(section+"Section.XPCost");
        String displayName = ChatColor.translateAlternateColorCodes('&', ymlProcesses.getMenuString(section+"Section.name"));
        ArrayList<String> lore = new ArrayList<>();
        for(int i=0; i < ymlProcesses.getMenuList(section).size(); i++) {
            lore.add(ChatColor.translateAlternateColorCodes('&', ymlProcesses.getMenuList(section).get(i)).replaceAll("%xp%", price));
        }
        meta.setDisplayName(displayName);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }


}
