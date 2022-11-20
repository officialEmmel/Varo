package network.emmel.varo.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import network.emmel.varo.Varo;

public class StartCommand implements CommandExecutor {
    DeathBan plugin = null;
    StartCommand(DeathBan plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("varo.start")) {
                if (plugin.getConfig().getBoolean("game.started")) {
                    player.sendMessage("§cThe game has already started!");
                } else {
                    plugin.config.set("game.started", true);
                    player.sendMessage("§aThe game has been started!");
                    // TODO: Start game
                }
            } else {
                player.sendMessage("§cYou don't have the permission to do this!");
            }
        } else {
            sender.sendMessage("§cYou have to be a player to do this!");
        }
        return true;
    }
}

