package pickaxeplus.me.meerzean.events;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import pickaxeplus.me.meerzean.PickaxeMain;

import java.io.File;


public class menuListener implements Listener {


    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {

        Configuration config = PickaxeMain.plugin.getConfig();
        File file = new File("plugins/PickaxePlus");
        File createLocation = new File(file, "menu.yml");
        FileConfiguration yaml = YamlConfiguration.loadConfiguration(createLocation);

        String notEnoughXP = ChatColor.translateAlternateColorCodes('&', config.getString("notEnoughXP"));
        String maxLevel = ChatColor.translateAlternateColorCodes('&', config.getString("maxLevel"));
        String success = ChatColor.translateAlternateColorCodes('&', config.getString("success"));
        String disabled = ChatColor.translateAlternateColorCodes('&', config.getString("disabled"));
        String noPermission = ChatColor.translateAlternateColorCodes('&', config.getString("noPermission"));
        int unbreakingCost = yaml.getInt("unbreakingSection.XPCost");
        int efficiencyCost = yaml.getInt("efficiencySection.XPCost");
        int fortuneCost = yaml.getInt("fortuneSection.XPCost");
        int silkTouchCost = yaml.getInt("silktouchSection.XPCost");
        int mendingCost = yaml.getInt("mendingSection.XPCost");

        boolean unbreakingActive = yaml.getBoolean("unbreakingSection.allowed");
        boolean efficiencyActive = yaml.getBoolean("efficiencySection.allowed");
        boolean fortuneActive = yaml.getBoolean("fortuneSection.allowed");
        boolean silktouchActive = yaml.getBoolean("silktouchSection.allowed");
        boolean mendingActive = yaml.getBoolean("mendingSection.allowed");

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', yaml.getString("menuTitle")))) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (player.hasPermission("pickaxeplus.use")) {
                if (e.getCurrentItem() == null) {
                    return;
                }

                if (unbreakingActive) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', yaml.getString("unbreakingSection.name")))) {
                        if (player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.DURABILITY) < 3) {
                            if (player.getLevel() > unbreakingCost) {

                                if (player.getInventory().getItemInMainHand().containsEnchantment(Enchantment.DURABILITY)) {
                                    player.getInventory().getItemInMainHand().addEnchantment(Enchantment.DURABILITY, player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.DURABILITY) + 1);
                                    player.sendMessage(success);
                                    player.setLevel(player.getLevel() - unbreakingCost);
                                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2.0F, 1.0F);
                                } else {
                                    player.getInventory().getItemInMainHand().addEnchantment(Enchantment.DURABILITY, 1);
                                    player.sendMessage(success);
                                    player.setLevel(player.getLevel() - unbreakingCost);
                                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2.0F, 1.0F);
                                }

                            } else {
                                player.sendMessage(notEnoughXP);
                            }
                        } else {
                            player.sendMessage(maxLevel);
                        }
                    }
                } else {
                    player.sendMessage(disabled);
                }

                if (efficiencyActive) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', yaml.getString("efficiencySection.name")))) {
                        if (player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.DIG_SPEED) < 5) {
                            if (player.getLevel() > efficiencyCost) {
                                if (player.getInventory().getItemInMainHand().containsEnchantment(Enchantment.DIG_SPEED)) {
                                    player.getInventory().getItemInMainHand().addEnchantment(Enchantment.DIG_SPEED, player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.DIG_SPEED) + 1);
                                    player.sendMessage(success);
                                    player.setLevel(player.getLevel() - efficiencyCost);
                                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2.0F, 1.0F);
                                } else {
                                    player.getInventory().getItemInMainHand().addEnchantment(Enchantment.DIG_SPEED, 1);
                                    player.sendMessage(success);
                                    player.setLevel(player.getLevel() - efficiencyCost);
                                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2.0F, 1.0F);
                                }

                            } else {
                                player.sendMessage(notEnoughXP);
                            }
                        } else {
                            player.sendMessage(maxLevel);
                        }

                    }
                } else {
                    player.sendMessage(disabled);
                }

                if (fortuneActive) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', yaml.getString("fortuneSection.name")))) {
                        if (player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) < 3) {
                            if (player.getLevel() > fortuneCost) {

                                if (player.getInventory().getItemInMainHand().containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) {
                                    player.getInventory().getItemInMainHand().addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) + 1);
                                    player.sendMessage(success);
                                    player.setLevel(player.getLevel() - fortuneCost);
                                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2.0F, 1.0F);
                                } else {
                                    player.getInventory().getItemInMainHand().addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
                                    player.sendMessage(success);
                                    player.setLevel(player.getLevel() - fortuneCost);
                                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2.0F, 1.0F);
                                }

                            } else {
                                player.sendMessage(notEnoughXP);
                            }
                        } else {
                            player.sendMessage(maxLevel);
                        }

                    }
                } else {
                    player.sendMessage(disabled);
                }

                if (mendingActive) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', yaml.getString("mendingSection.name")))) {
                        if (player.getLevel() > mendingCost) {
                            if (player.getInventory().getItemInMainHand().containsEnchantment(Enchantment.MENDING)) {
                                player.sendMessage(maxLevel);
                            } else {
                                player.getInventory().getItemInMainHand().addEnchantment(Enchantment.MENDING, 1);
                                player.setLevel(player.getLevel() - mendingCost);
                                player.sendMessage(success);
                            }
                        } else {
                            player.sendMessage(notEnoughXP);
                        }
                    }
                } else {
                    player.sendMessage(disabled);
                }

                if (silktouchActive) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', yaml.getString("silktouchSection.name")))) {
                        if (player.getLevel() > silkTouchCost) {
                            if (player.getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
                                player.sendMessage(maxLevel);
                            } else {
                                player.getInventory().getItemInMainHand().addEnchantment(Enchantment.SILK_TOUCH, 1);
                                player.setLevel(player.getLevel() - silkTouchCost);
                                player.sendMessage(success);
                            }
                        } else {
                            player.sendMessage(notEnoughXP);
                        }
                    }
                } else {
                    player.sendMessage(disabled);
                }


            } else {
                player.sendMessage(noPermission);
            }
        }
    }

}
