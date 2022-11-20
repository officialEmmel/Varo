package main.java.network.emmel.DeathBan.world;

import main.java.network.emmel.DeathBan.DeathBan;
import main.java.network.emmel.DeathBan.util.Config;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.WorldBorder;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class WorldBorderManager {
    DeathBan deathBan;
    public WorldBorder worldBorder;
    public int borderFactor;
    public double queuedBoarder;
    int maxBorder;

    public WorldBorderManager() {
        deathBan = DeathBan.getPlugin(DeathBan.class);
        borderFactor = deathBan.config.getBorderFactor();
        worldBorder = Bukkit.getWorld("world").getWorldBorder();
        queuedBoarder = worldBorder.getSize();
        maxBorder = deathBan.config.getPlayers().size() * borderFactor;
        System.out.println(deathBan.config.getBorderFactor());
        if (worldBorder.getSize() > maxBorder) {
            worldBorder.setSize(maxBorder);
        }
    }

    public void shrinkBorder(int ticks) {
        queuedBoarder = queuedBoarder - borderFactor;
        System.out.println(queuedBoarder);
        new BukkitRunnable() {
            public void run() {
                worldBorder.setSize(worldBorder.getSize() - borderFactor);
            }
        }.runTaskLater(deathBan, ticks);
    }
}
