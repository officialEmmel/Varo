package main.java.network.emmel.DeathBan.players;

import main.java.network.emmel.DeathBan.DeathBan;
import org.bukkit.entity.Player;

import java.util.List;

public class PlayerManager {
    DeathBan plugin;
    public PlayerManager() {
        plugin = DeathBan.getPlugin(DeathBan.class);
    }

    public void addPlayer(Player mcPlayer) {
        List<String> pList = plugin.config.getPlayers();
        for (String p : pList) {
            if (p.equals(mcPlayer.getUniqueId().toString())) {
                kick(mcPlayer, "Du bist kein DeathBan Teilnehmer!");
                return;
            }
            DeathBanPlayer deathBanPlayer = plugin.database.getPlayerByUuid(mcPlayer.getUniqueId().toString());
            if(deathBanPlayer == null) {
                plugin.getLogger().info("Player not found in database, adding player to database");
                deathBanPlayer = new DeathBanPlayer(
                        mcPlayer.getDisplayName(),
                        mcPlayer.getUniqueId().toString(),
                        0,
                        1,
                        0,
                        0,
                        0,
                        0,
                        0
                );
                //plugin.database.addPlayer(deathBanPlayer);
            }
        }
    }

    public void kick(Player mcPlayer, String reason) {
        mcPlayer.kickPlayer(reason);
    }

    public void getMCPlayer(DeathBanPlayer deathBanPlayer) {
        plugin.getServer().getPlayer(deathBanPlayer.uuid);
    }

}

