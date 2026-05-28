package src;

public class Main {
    public static void main(String[] args) {
        HackathonController controller = new HackathonController();
        HackathonView view = new HackathonView();
        while (true) {
            view.showMenu();
            int choice = view.getChoice();
            switch (choice) {
                case 1:
                    view.displayTeams(controller.getAllTeams());
                    break;
                case 2:
                    String search = view.getInput("Enter Team Name: ");
                    Team found = controller.findTeam(search);
                    if (found != null)
                        view.showMessage("Team Found: " + found.teamName);
                    else
                        view.showMessage("Team Not Found");
                    break;
                case 3:
                    String name = view.getInput("Enter Team Name: ");
                    String leader = view.getInput("Enter Leader Name: ");
                    int members = Integer.parseInt(view.getInput("Enter Members: "));
                    int id = Integer.parseInt(view.getInput("Enter Team ID: "));
                    controller.addTeam(new Team(id, name, leader, members));
                    view.showMessage("Team Added!");
                    break;
                case 4:
                    String statusTeam = view.getInput("Enter Team Name: ");
                    String status = view.getInput("Enter New Status: ");
                    controller.updateStatus(statusTeam, status);
                    view.showMessage("Status Updated!");
                    break;
                case 5:
                    String deleteTeam = view.getInput("Enter Team Name to Delete: ");
                    controller.deleteTeam(deleteTeam);
                    view.showMessage("Team Deleted!");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}