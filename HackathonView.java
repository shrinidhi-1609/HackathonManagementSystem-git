import java.util.Scanner;

class HackathonView {

    Scanner sc = new Scanner(System.in);

    void showMenu() {

        System.out.println("\n===== Hackathon Team Management =====");

        System.out.println("1. Display Teams");
        System.out.println("2. Search Team");
        System.out.println("3. Add Member");
        System.out.println("4. Update Project Status");
        System.out.println("5. Exit");
    }

    int getChoice() {

        System.out.print("Enter Choice: ");
        return sc.nextInt();
    }

    String getInput(String msg) {

        sc.nextLine();
        System.out.print(msg);
        return sc.nextLine();
    }

    void displayTeams(Team[] teams, int count) {

        System.out.println("\n--- Team Details ---");

        for (int i = 0; i < count; i++) {

            System.out.println(
                    teams[i].id + " | " +
                    teams[i].teamName + " | " +
                    teams[i].leader + " | Members: " +
                    teams[i].members + " | Status: " +
                    teams[i].projectStatus);
        }
    }

    void showMessage(String msg) {
        System.out.println(msg);
    }
}