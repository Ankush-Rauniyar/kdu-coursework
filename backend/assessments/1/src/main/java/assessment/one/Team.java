package assessment.one;

import java.util.ArrayList;

public class Team {
    private ArrayList<Player> playerList = new ArrayList<>();
    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void addPlayer(Player player) {
        playerList.add(player);
    }
}
