package main.java.network.emmel.DeathBan.teams;
public class Team {
    public int id;
    public String name;
    public int size;
    public int kills;
    public int deaths;
    public int points;
    public int timePlayedTotal;
    public int alive;

    public Team(
            int id,
            String name,
            int size,
            int alive,
            int kills,
            int deaths,
            int points,
            int timePlayedTotal) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.alive = alive;
        this.kills = kills;
        this.deaths = deaths;
        this.points = points;
        this.timePlayedTotal = timePlayedTotal;
        //this.members = members;
    }
}