package main.java.network.emmel.DeathBan.time;

import main.java.network.emmel.DeathBan.DeathBan;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class TimeRunnable extends BukkitRunnable {

    DeathBan plugin;

    TimeRunnable() {
        this.plugin = DeathBan.getPlugin(DeathBan.class);
    }
    @Override
    public void run() {

    }
}


