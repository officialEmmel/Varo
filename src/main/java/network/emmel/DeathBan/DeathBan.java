package main.java.network.emmel.DeathBan;

import main.java.network.emmel.DeathBan.listeners.EventListener;
import main.java.network.emmel.DeathBan.players.PlayerDeathManager;
import main.java.network.emmel.DeathBan.players.PlayerManager;
import main.java.network.emmel.DeathBan.time.TimeManager;
import main.java.network.emmel.DeathBan.world.WorldBorderManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import main.java.network.emmel.DeathBan.util.Config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// import network.emmel.varo.listeners.PlayerJoinListener;
// import network.emmel.varo.listeners.PlayerQuitListener;
// import network.emmel.varo.listeners.PlayerDeathListener;
// import network.emmel.varo.listeners.PlayerRespawnListener;


public final class DeathBan extends JavaPlugin {

    public Config config;
    public Database database;
    TimeManager timeManager;
    public PlayerDeathManager playerDeathManager;
    public WorldBorderManager worldBorderManager;

    public PlayerManager playerManager;

    public boolean gameStarted = false;

    public List<HashMap> registeredPlayers = new ArrayList<HashMap>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        config = new Config(this);
        if (config.getGameStarted()) {
            getLogger().info("VARO-Game: Started");
            this.gameStarted = true;
        } else {
            getLogger().info("VARO-Game: Not started");
        }

        database = new Database(getDataFolder().toString(), "varo");
        timeManager = new TimeManager();
        playerDeathManager = new PlayerDeathManager();
        worldBorderManager = new WorldBorderManager();
        playerManager = new PlayerManager();

        getServer().getPluginManager().registerEvents(new EventListener(), this);

        getLogger().info("DeathBan has been enabled!");
        getLogger().info("Starting with following config:");
        getLogger().info("  Players: ");
        getLogger().info("  BorderFactor: " + config.getBorderFactor());
        getLogger().info("  Teamsizes: " + config.getTeamSize());

    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
