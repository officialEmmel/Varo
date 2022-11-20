package main.java.network.emmel.DeathBan.players;


import main.java.network.emmel.DeathBan.DeathBan;
import main.java.network.emmel.DeathBan.world.WorldBorderManager;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class PlayerDeathManager {
    DeathBan deathBan;

    public PlayerDeathManager() {
        this.deathBan = DeathBan.getPlugin(DeathBan.class);
    }

    public void  PlayerDied(PlayerDeathEvent e) {
        deathBan.worldBorderManager.shrinkBorder(1200);
        Player p = e.getEntity();
        Player killer = p.getKiller();

        Location location_before_death = p.getLocation();
        Vector velocity_before_death =  p.getVelocity();
        velocity_before_death.setX(velocity_before_death.getX() * 2);
        velocity_before_death.setY(velocity_before_death.getY() * 2);
        velocity_before_death.setZ(velocity_before_death.getZ() * 2);

        // Revive the player into game mode spectator
        p.setBedSpawnLocation(location_before_death, true);
        p.setGameMode(GameMode.SPECTATOR);

        // Summon a lightning bolt at the player's location
        p.getWorld().strikeLightningEffect(p.getLocation());
        p.spigot().respawn();

        // Cool visual effect
        p.teleport(location_before_death);
        p.setVelocity(velocity_before_death);

        WorldBorder border = p.getWorld().getWorldBorder();
        Bukkit.getOnlinePlayers().forEach(player -> {
            if (p == player) {
                player.sendTitle("§4DU BIST GESTORBEN", "");
            } else {
                player.playSound(player.getLocation(), Sound.AMBIENCE_THUNDER, 5, 1);
                player.sendTitle(
                        // TODO config implementieren
                        "§c" + p.getName() + " ist gestorben!",
                        "§cDie Worldboarder schrumpft in 60 Sekunden! (" + deathBan.worldBorderManager.worldBorder.getSize() / 2 + " -> " + (deathBan.worldBorderManager.queuedBoarder - deathBan.worldBorderManager.borderFactor) / 2 + ")"
                );
            }
        });
        p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 40, 0));
        new BukkitRunnable() {
            public void run() {
                p.setBanned(true);
                p.kickPlayer("§cDu bist ausgeschieden!");
            }
        }.runTaskLater(deathBan, 1200);
    }
}
