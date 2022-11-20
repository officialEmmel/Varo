package main.java.network.emmel.DeathBan.time;

import main.java.network.emmel.DeathBan.DeathBan;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;


public class TimeManager {
    TimeRunnable task;
    DeathBan plugin;

    List<Player> players = new ArrayList<Player>();
    public TimeManager() {
        plugin = DeathBan.getPlugin(DeathBan.class);
        task = new TimeRunnable();
        task.runTaskTimerAsynchronously(plugin, 0, 1);
    }



}
