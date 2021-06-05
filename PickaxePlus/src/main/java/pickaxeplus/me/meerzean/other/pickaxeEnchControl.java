package pickaxeplus.me.meerzean.other;

import org.bukkit.ChatColor;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import pickaxeplus.me.meerzean.PickaxeMain;

public class pickaxeEnchControl {


    static Configuration config = PickaxeMain.plugin.getConfig();

    static String notEnoughXP = ChatColor.translateAlternateColorCodes('&', config.getString("notEnoughXP"));
    static String maxLevel = ChatColor.translateAlternateColorCodes('&', config.getString("maxLevel"));
    static String success = ChatColor.translateAlternateColorCodes('&', config.getString("success"));

    static int unbreakingCost = ymlProcesses.getMenuInt("unbreakingSection.XPCost");
    static int efficiencyCost = ymlProcesses.getMenuInt("efficiencySection.XPCost");
    static int fortuneCost = ymlProcesses.getMenuInt("fortuneSection.XPCost");
    static int silkTouchCost = ymlProcesses.getMenuInt("silktouchSection.XPCost");
    static int mendingCost = ymlProcesses.getMenuInt("mendingSection.XPCost");


    public static void enchPickaxe(Enchantment enchName, Player player) {
        if(enchName.equals(Enchantment.DURABILITY)) {
            if(player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.DURABILITY) > 3) {
                if (player.getLevel() > unbreakingCost) {

                    if (player.getInventory().getItemInMainHand().containsEnchantment(Enchantment.DURABILITY)) {
                        player.getInventory().getItemInMainHand().addEnchantment(Enchantment.DURABILITY, player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.DURABILITY) + 1);
                        player.sendMessage(success);
                        player.setLevel(player.getLevel() - unbreakingCost);
                    } else {
                        player.getInventory().getItemInMainHand().addEnchantment(Enchantment.DURABILITY, 1);
                        player.sendMessage(success);
                        player.setLevel(player.getLevel() - unbreakingCost);
                    }

                } else {
                    player.sendMessage(notEnoughXP);
                }
            }




        }
    }



}
