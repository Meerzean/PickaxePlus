package pickaxeplus.me.meerzean.other;

import org.bukkit.Material;

import java.util.ArrayList;

public class addPickaxesToList {


    public static ArrayList<Material> addPickaxes() {
        ArrayList<Material> pickaxes = new ArrayList<Material>();

        pickaxes.add(Material.DIAMOND_PICKAXE);
        pickaxes.add(Material.GOLDEN_PICKAXE);
        pickaxes.add(Material.STONE_PICKAXE);
        pickaxes.add(Material.WOODEN_PICKAXE);
        pickaxes.add(Material.NETHERITE_PICKAXE);
        pickaxes.add(Material.IRON_PICKAXE);

        return pickaxes;
    }


}
