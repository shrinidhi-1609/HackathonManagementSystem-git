package src;

import java.sql.*;
import java.util.ArrayList;

public class HackathonController {

    public ArrayList<Team> getAllTeams() {
        ArrayList<Team> teams = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM teams");
            while (rs.next()) {
                teams.add(new Team(rs.getInt("id"), rs.getString("team_name"), rs.getString("leader"), rs.getInt("members")));
            }
            con.close();
        } catch (Exception e) { e.printStackTrace(); }
        return teams;
    }

    public void addTeam(Team t) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO teams VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, t.id);
            ps.setString(2, t.teamName);
            ps.setString(3, t.leader);
            ps.setInt(4, t.members);
            ps.setString(5, t.projectStatus);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public Team findTeam(String name) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM teams WHERE team_name=?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Team(rs.getInt("id"), rs.getString("team_name"), rs.getString("leader"), rs.getInt("members"));
            }
            con.close();
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    public void updateStatus(String teamName, String status) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE teams SET project_status=? WHERE team_name=?");
            ps.setString(1, status);
            ps.setString(2, teamName);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void deleteTeam(String teamName) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM teams WHERE team_name=?");
            ps.setString(1, teamName);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
