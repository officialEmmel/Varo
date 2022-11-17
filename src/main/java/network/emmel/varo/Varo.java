package network.emmel.varo;

import org.bukkit.plugin.java.JavaPlugin;
import network.emmel.varo.util.Config;
import network.emmel.varo.teams.TeamManager;
import network.emmel.varo.commands.StartCommand;

// import network.emmel.varo.listeners.PlayerJoinListener;
// import network.emmel.varo.listeners.PlayerQuitListener;
// import network.emmel.varo.listeners.PlayerDeathListener;
// import network.emmel.varo.listeners.PlayerRespawnListener;

import network.emmel.varo.Database;


public final class Varo extends JavaPlugin {

    public Config config = null;
    Database database = null;

    @Override
    public void onEnable() {
        // Plugin startup logic
        config = new Config(this);
        database = new Database(getDataFolder().toString(), "varo");

        getLogger().info("VARO has been enabled!");
        getLogger().info("Starting with following config:");
        getLogger().info("VARO-Players: ");
        getLogger().info("VARO-Border: " + config.getBorderSize());
        getLogger().info("VARO-Teamsizes: " + config.getTeamSize());
        config.getPlayerNames();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
