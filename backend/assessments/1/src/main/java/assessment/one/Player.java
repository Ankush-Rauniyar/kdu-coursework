package assessment.one;

public class Player {
    private String name;
    private String team;
    private String role;
    private int matches;
    private int runs;
    private double average;
    private double strikeRate;

    private int wickets;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getAverage() {
        return average;
    }

    public double getStrikeRate() {
        return strikeRate;
    }

    public int getMatches() {
        return matches;
    }

    public int getRuns() {
        return runs;
    }

    public int getWickets() {
        return wickets;
    }

    public String getRole() {
        return role;
    }

    public String getTeam() {
        return team;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public void setStrikeRate(double strikeRate) {
        this.strikeRate = strikeRate;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }
}
