package pickaxeplus.me.meerzean.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import pickaxeplus.me.meerzean.PickaxeMain;
import pickaxeplus.me.meerzean.other.ymlProcesses;

public class pickaxeCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        Configuration config = PickaxeMain.plugin.getConfig();
        if (player.hasPermission("pickaxeplus.use")) {
            if (args.length == 1) {
                if (player.hasPermission("pickaxeplus.admin")) {
                    if (args[0].equalsIgnoreCase("reload")) {
                        ymlProcesses.reloadYAML();
                        PickaxeMain.plugin.reloadConfig();
                        player.sendMessage(ChatColor.AQUA + "Reloaded config.");
                    }
                }
            }
            if (args.length == 0) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("pickaxePlusCommand")));
            }

            return true;
        }
        return false;
    }
}
