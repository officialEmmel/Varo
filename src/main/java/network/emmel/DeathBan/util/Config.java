package network.emmel.varo.util;

import org.bukkit.plugin.java.JavaPlugin;
import network.emmel.varo.Varo;
import org.bukkit.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;

public class Config {

    public DeathBan plugin;

    public Config(DeathBan plugin) {
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

    public List<String> getPlayers() {
        List<String> players = new ArrayList<String>();
        List<LinkedHashMap> teamList = (List<LinkedHashMap>) plugin.getConfig().getConfigurationSection("teams").get("teams");
        for (LinkedHashMap team : teamList) {
            List<LinkedHashMap> playerList = (List<LinkedHashMap>) team.get("players");
            for (LinkedHashMap player : playerList) {
                players.add(player.get("uuid").toString());
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
