package pickaxeplus.me.meerzean.other;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ymlProcesses {


    public static void createMenuFile() throws IOException {
        File file = new File("plugins/PickaxePlus");
        File createLocation = new File(file, "menu.yml");
        FileConfiguration yaml = YamlConfiguration.loadConfiguration(createLocation);
        if (!createLocation.exists()) {
            Bukkit.getLogger().info(ChatColor.AQUA + "[PickaxePlus] Menu.yml not found creating...");
            createLocation.createNewFile();
            yaml.createSection("menuTitle");
            yaml.set("menuTitle", "&aPickaxe Menu");
            yaml.save(createLocation);
            create("unbreaking", "&bUnbreaking", 13, "&7Is your pickaxe breaking easily?", "&aJust buy this!", "&bPrice: %xp%");
            create("efficiency", "&bEfficiency", 15, "&7Dig fast go brrr", "&aBuy this to dig fast", "&bPrice: %xp%");
            create("fortune", "&bFortune", 15, "&7Haha more money xD", "&aBuy this to get more diamonds!", "&bPrice: %xp%");
            create("mending", "&bMending", 45, "&7XP to Buy and XP to fix? what", "&aEasy fix haha", "&bPrice: %xp%");
            create("silktouch", "&bSilk Touch", 25, "&7Most useless ench?", "&aBuy this to get mines as block", "&bPrice: %xp%");
            if (!createLocation.exists()) {
                Bukkit.getLogger().info("Can't create menu.yml");
            } else {
                Bukkit.getLogger().info(ChatColor.AQUA + "[PickaxePlus] Successfully created menu.yml");
            }
        } else {
            Bukkit.getLogger().info(ChatColor.AQUA + "[PickaxePlus] Menu.yml found.");
        }
    }

    public static String getMenuString(String neededData) {
        FileConfiguration yaml = getYaml();
        return yaml.getString(neededData);
    }

    public static int getMenuInt(String neededData) {
        FileConfiguration yaml = getYaml();
        return yaml.getInt(neededData);
    }

    public static String getMenuIntAsString(String neededData) {
        FileConfiguration yaml = getYaml();
        return String.valueOf(yaml.getInt(neededData));
    }

    public static void create(String section, String name, int price, String lore1, String lore2, String lore3) throws IOException {
        FileConfiguration yaml = getYaml();
        File file = new File("plugins/PickaxePlus");
        File menuFile = new File(file, "menu.yml");
        yaml.createSection(section + "Section");
        yaml.createSection(section + "Section.allowed");
        yaml.set(section + "Section.allowed", true);
        yaml.createSection(section + "Section.name");
        yaml.set(section + "Section.name", name);
        yaml.createSection(section + "Section.lore");
        ArrayList<String> loreLines = new ArrayList<>();
        loreLines.add(lore1);
        loreLines.add(lore2);
        loreLines.add(lore3);
        yaml.set(section + "Section.lore", loreLines);
        yaml.createSection(section + "Section.XPCost");
        yaml.set(section + "Section.XPCost", price);
        yaml.save(menuFile);
    }

    public static List<String> getMenuList(String sectionName) {
        FileConfiguration yaml = getYaml();
        return yaml.getStringList(sectionName + "Section.lore");
    }

    public static void reloadYAML() {
        FileConfiguration yaml = getYaml();
    }

    public static FileConfiguration getYaml() {
        File file = new File("plugins/PickaxePlus");
        File createLocation = new File(file, "menu.yml");
        FileConfiguration yaml = YamlConfiguration.loadConfiguration(createLocation);
        return yaml;
    }


}
