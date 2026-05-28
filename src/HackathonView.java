package src;

import java.util.ArrayList;
import java.util.Scanner;

public class HackathonView {

    Scanner sc = new Scanner(System.in);

    public void showMenu() {
        System.out.println("\n=== Hackathon Management System ===");
        System.out.println("1. View All Teams");
        System.out.println("2. Find Team");
        System.out.println("3. Add Team");
        System.out.println("4. Update Project Status");
        System.out.println("5. Delete Team");
        System.out.println("6. Exit");
        System.out.print("Enter Choice: ");
    }

    public int getChoice() {
        return Integer.parseInt(sc.nextLine());
    }

    public String getInput(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }

    public void displayTeams(ArrayList<Team> teams) {
        if (teams.isEmpty()) {
            System.out.println("No teams found.");
            return;
        }
        System.out.println("\nID | Team Name | Leader | Members | Status");
        System.out.println("--------------------------------------------");
        for (Team t : teams) {
            System.out.println(t.id + " | " + t.teamName + " | " + t.leader + " | " + t.members + " | " + t.projectStatus);
        }
    }
}
