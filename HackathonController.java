class HackathonController {

    Team[] teams;
    int count;

    HackathonController(int size) {
        teams = new Team[size];
        count = 0;
    }

    void addTeam(int id, String name, String leader, int members) {
        teams[count++] = new Team(id, name, leader, members);
    }

    Team[] getTeams() {
        return teams;
    }

    int getCount() {
        return count;
    }

    Team findTeam(String name) {

        for (int i = 0; i < count; i++) {

            if (teams[i].teamName.equalsIgnoreCase(name)) {
                return teams[i];
            }
        }

        return null;
    }

    String addMember(String name) {

        Team t = findTeam(name);

        if (t == null)
            return "Team Not Found";

        t.members++;

        return "Member Added Successfully";
    }

    String updateStatus(String name, String status) {

        Team t = findTeam(name);

        if (t == null)
            return "Team Not Found";

        t.projectStatus = status;

        return "Project Status Updated";
    }
}