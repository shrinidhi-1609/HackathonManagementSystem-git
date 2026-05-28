package src;
class Team {

    int id;
    String teamName;
    String leader;
    int members;
    String projectStatus;

    Team(int id, String teamName, String leader, int members) {
        this.id = id;
        this.teamName = teamName;
        this.leader = leader;
        this.members = members;
        this.projectStatus = "Not Started";
    }
}