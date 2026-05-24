public class Main {

    public static void main(String[] args) {

        HackathonController controller = new HackathonController(10);

        HackathonView view = new HackathonView();

        // Sample Teams

        controller.addTeam(1, "Code Warriors", "Arun", 4);
        controller.addTeam(2, "Bug Smashers", "Priya", 3);
        controller.addTeam(3, "AI Legends", "Rahul", 5);

        while (true) {

            view.showMenu();

            int choice = view.getChoice();

            switch (choice) {

                case 1:

                    view.displayTeams(
                            controller.getTeams(),
                            controller.getCount());

                    break;

                case 2:

                    String search =
                            view.getInput("Enter Team Name: ");

                    if (controller.findTeam(search) != null)
                        view.showMessage("Team Found");
                    else
                        view.showMessage("Team Not Found");

                    break;

                case 3:

                    String memberTeam =
                            view.getInput("Enter Team Name: ");

                    view.showMessage(
                            controller.addMember(memberTeam));

                    break;

                case 4:

                    String statusTeam =
                            view.getInput("Enter Team Name: ");

                    String status =
                            view.getInput("Enter New Status: ");

                    view.showMessage(
                            controller.updateStatus(statusTeam, status));

                    break;

                case 5:

                    System.out.println("Exiting...");
                    return;

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}