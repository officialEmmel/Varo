package main.java.network.emmel.DeathBan.listeners;
import main.java.network.emmel.DeathBan.DeathBan;
import main.java.network.emmel.DeathBan.players.PlayerDeathManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventListener implements Listener {

    DeathBan plugin;

    public EventListener() {
        this.plugin = DeathBan.getPlugin(DeathBan.class);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        plugin.getLogger().info("player joined");
        Player player = event.getPlayer();
        plugin.playerManager.addPlayer(player);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerDeath(PlayerDeathEvent e) {
        plugin.playerDeathManager.PlayerDied(e);
    }

}
