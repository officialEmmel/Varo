package network.emmel.varo;

import java.sql.*;
import network.emmel.varo.players.Player;
import network.emmel.varo.teams.Team;

public class Database {
    Connection conn = null;
    public Database(String path, String name) {
        // sqlite 3 database connection
        try {
            // db parameters
            String url = "jdbc:sqlite:" + path + "/" + name + ".db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            //TODO print connection status

            //sql create tables
            String player_table = "CREATE TABLE IF NOT EXISTS players (\n"
                    + "	id integer PRIMARY KEY,\n"
                    + "	name text NOT NULL,\n"
                    + " uuid text NOT NULL,\n"
                    + "	teamId integer NOT NULL,\n"
                    + "	alive integer NOT NULL,\n"
                    + "	soloKills integer NOT NULL,\n"
                    + "	soloDeaths integer NOT NULL,\n"
                    + "	teamPoints integer NOT NULL,\n"
                    + "	soloPoints integer NOT NULL,\n"
                    + " timePlayedTotal integer NOT NULL,\n"
                    + " timeLeftToday integer NOT NULL\n,"
                    + ");";
            String team_table = "CREATE TABLE IF NOT EXISTS teams (\n"
                    + "	id integer PRIMARY KEY,\n"
                    + "	name text NOT NULL,\n"
                    + " size integer NOT NULL,\n"
                    + " playersAlive integer NOT NULL,\n"
                    + "	teamKills integer NOT NULL,\n"
                    + "	teamDeaths integer NOT NULL,\n"
                    + "	teamPoints integer NOT NULL,\n"
                    + "	timePlayedTotal integer NOT NULL\n"
                    + ");";

            Statement stmt = conn.createStatement();
            stmt.execute(player_table);
            stmt.execute(team_table);
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //TODO print error
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    // ##### PLAYERS #####
    public void addPlayer(Player player) {
        //TODO add player to database
    }

    public Player getPlayerByUuid(String uuid) {
        String sql = "SELECT name, uuid, teamId, alive, soloKills, soloDeaths, teamPoints, soloPoints, timePlayedTotal, timeLeftToday FROM players WHERE uuid = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, uuid);
            ResultSet rs = pstmt.executeQuery();
            Player p = null;
            try {
                p = new Player(
                        rs.getString("name"),
                        rs.getString("uuid"),
                        rs.getInt("teamId"),
                        rs.getInt("alive"),
                        rs.getInt("soloKills"),
                        rs.getInt("soloDeaths"),
                        rs.getInt("soloPoints"),
                        rs.getInt("timePlayedTotal"),
                        rs.getInt("timeLeftToday")
                );
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return p;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Player getPlayerByName(String name) {
        String sql = "SELECT name, uuid, teamId, alive, soloKills, soloDeaths, teamPoints, soloPoints, timePlayedTotal, timeLeftToday FROM players WHERE name = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            Player p = null;
            try {
                p = new Player(
                        rs.getString("name"),
                        rs.getString("uuid"),
                        rs.getInt("teamId"),
                        rs.getInt("alive"),
                        rs.getInt("soloKills"),
                        rs.getInt("soloDeaths"),
                        rs.getInt("soloPoints"),
                        rs.getInt("timePlayedTotal"),
                        rs.getInt("timeLeftToday"))
                ;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return p;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    // ##### TEAMS #####
    public void addTeam(Team team) {
        //TODO add team to database
    }

    public Team getTeamById(int id) {
        String sql = "SELECT name, size, playersAlive, teamKills, teamDeaths, teamPoints, timePlayedTotal FROM teams WHERE id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            Team t = null;
            try {
                t = new Team(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("size"),
                        rs.getInt("playersAlive"),
                        rs.getInt("teamKills"),
                        rs.getInt("teamDeaths"),
                        rs.getInt("teamPoints"),
                        rs.getInt("timePlayedTotal")
                );
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return t;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Team getTeamByName(String name) {
        String sql = "SELECT name, size, playersAlive, teamKills, teamDeaths, teamPoints, timePlayedTotal FROM teams WHERE name = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            Team t = null;
            try {
                t = new Team(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("size"),
                        rs.getInt("playersAlive"),
                        rs.getInt("teamKills"),
                        rs.getInt("teamDeaths"),
                        rs.getInt("teamPoints"),
                        rs.getInt("timePlayedTotal")
                );
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return t;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}