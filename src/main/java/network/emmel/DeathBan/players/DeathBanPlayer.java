package main.java.network.emmel.DeathBan.players;
public class DeathBanPlayer {
    public String name;
    public String uuid;
    public int teamId;
    public int alive;
    public int soloKills;
    public int soloDeaths;
    public int soloPoints;
    public int timePlayedTotal;
    public int timeLeftToday;

    public DeathBanPlayer(
            String name,
            String uuid,
            int teamId,
            int alive,
            int soloKills,
            int soloDeaths,
            int soloPoints,
            int timePlayedTotal,
            int timeLeftToday) {
        this.name = name;
        this.uuid = uuid;
        this.teamId = teamId;
        this.alive = alive;
        this.soloKills = soloKills;
        this.soloDeaths = soloDeaths;
        this.soloPoints = soloPoints;
        this.timePlayedTotal = timePlayedTotal;
        this.timeLeftToday = timeLeftToday;
    }
}