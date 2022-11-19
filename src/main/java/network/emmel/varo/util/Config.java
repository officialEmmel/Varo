package network.emmel.varo.util;

import org.bukkit.plugin.java.JavaPlugin;
import network.emmel.varo.Varo;
import org.bukkit.*;
import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;

public class Config {

    public Varo plugin;

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

    public List<HashMap> getPlayers() {
        List<HashMap> players = new ArrayList<HashMap>();
        List<LinkedHashMap> teamList = (List<LinkedHashMap>) plugin.getConfig().getConfigurationSection("teams").get("teams");
        for (LinkedHashMap team : teamList) {
            List<LinkedHashMap> playerList = (List<LinkedHashMap>) team.get("players");
            for (LinkedHashMap player : playerList) {
                HashMap<String, String> playerMap = new HashMap<String, String>();
                playerMap.put("name", player.get("name").toString());
                playerMap.put("uuid", player.get("uuid").toString());
                players.add(playerMap);
            }
        }
        return players;
    }

    public List<HashMap> getTeams() {
        List<HashMap> teams = new ArrayList<HashMap>();
        List<LinkedHashMap> teamList = (List<LinkedHashMap>) plugin.getConfig().getConfigurationSection("teams").get("teams");
        for (LinkedHashMap team : teamList) {
            HashMap<String, String> teamMap = new HashMap<String, String>();
            teamMap.put("name", team.get("name").toString());
            teamMap.put("color", team.get("color").toString());
            teams.add(teamMap);
        }
        return teams;
    }

    public int getTimePerDay() {
        return this.getInt("time.time_per_day");
    }

    public void set(String path, Object value) {
        plugin.getConfig().set(path, value);
        plugin.saveConfig();
    }
}
