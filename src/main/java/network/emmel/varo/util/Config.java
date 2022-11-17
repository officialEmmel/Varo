package network.emmel.varo.util;

import org.bukkit.plugin.java.JavaPlugin;
import network.emmel.varo.Varo;
import org.bukkit.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Config {

    public static Varo plugin;

    public Config(Varo plugin) {
        this.plugin = plugin;
        plugin.saveDefaultConfig();
    }

    private String getString(String path) {
        return plugin.getConfig().getString(path);
    }

    private int getInt(String path) {
        return plugin.getConfig().getInt(path);
    }

    private boolean getBoolean(String path) {
        return plugin.getConfig().getBoolean(path);
    }

    public boolean getGameStarted() {
        return this.getBoolean("game.started");
    }

    public int getBorderSize() {
        return this.getInt("border.size");
    }

    public int getBorderFactor() {
        return this.getInt("border.factor");
    }

    public String getWorldName() {
        return this.getString("world.name");
    }

    public Location getSpawn() {
        return new Location(
            Bukkit.getWorld(this.getWorldName()),
            this.getInt("spawn.x"),
            this.getInt("spawn.y"),
            this.getInt("spawn.z")
        );
    }

    public int getTeamSize() {
        return this.getInt("teams.size");
    }

    // TODO get teams

    public void getPlayerNames() {
        List<ArrayList<String>> teams = plugin.getConfig().getList("teams.teams");
    }

    public int getTimePerDay() {
        return this.getInt("time.time_per_day");
    }

    public void set(String path, Object value) {
        plugin.getConfig().set(path, value);
        plugin.saveConfig();
    }
}
