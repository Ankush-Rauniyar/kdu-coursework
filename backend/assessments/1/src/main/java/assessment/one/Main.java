package assessment.one;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        ConcurrentHashMap<String,Player> playersAll = CsvRead.readingPlayers();
        HashMap<String,Team> teamHashMap = new HashMap<>();
        HashSet<String> teams = new HashSet<>();

        for(Map.Entry<String,Player> entry : playersAll.entrySet()){
            String playerName = entry.getKey();
            Player player = entry.getValue();
            String teamName = player.getTeam();
            if(!teamHashMap.containsKey(teamName)){
                Team team = new Team();
                team.addPlayer(player);
                teamHashMap.put(teamName,team);
            }else {
                Team team = teamHashMap.get(teamName);
                team.addPlayer(player);
                teamHashMap.put(teamName,team);
            }
            teams.add(teamName);
        }
        int ONE = 1;
        int TWO = 2;
        int THREE = 3;
        WritetoCSV.matchFixtures(teams);
//        Scanner sc = new Scanner(System.in);
//        LoggerFile.displayLogs("\n top 40 wicket taking bowlers : 1 \n highest wicket taker/highest run scorer : 2 \n top 3 run scorers/top 3 wicket takers: 3");
//        int choice = sc.nextInt();
//        if(choice == ONE){
//            String teamName = sc.next();
//            if(!teamHashMap.containsKey(teamName)){
//                LoggerFile.displayLogs("wrong spelling of the team");
//            }else{
//                allFortyWickets(teamHashMap.get(teamName));
//            }
//        }else if(choice == TWO){
//            String teamName = sc.next();
//            if(!teamHashMap.containsKey(teamName)){
//                LoggerFile.displayLogs("wrong spelling of the team");
//            }else{
//                highestWicketAndRuns(teamHashMap.get(teamName));
//            }
//        }else if(choice == THREE){
//            topThree(playersAll);
//        }else{
//            LoggerFile.displayLogs("You chose the wrong options");
//        }


    }
    public static void allFortyWickets(Team team){
        int FORTY = 40;
        String BOWLER = "BOWLER";
        ArrayList<Player> playerArrayList = team.getPlayerList();
        LoggerFile.displayLogs("All players with atleast 40 wickets :");
        for(Player player : playerArrayList){
            if(player.getRole().equals(BOWLER) && player.getWickets() >= FORTY){
                LoggerFile.displayLogs(player.getName());
            }
        }
    }

    public static void highestWicketAndRuns(Team team){
        ArrayList<Player> playerArrayList = team.getPlayerList();
        LoggerFile.displayLogs("Highest runs of your team :");
        String ans = "";
        String result ="";
        int RUNS = 0;
        int WICKETS = 0;
        for(Player player : playerArrayList){
            if(player.getRuns() >= RUNS){
                ans = player.getName();
                RUNS = player.getRuns();
            }
            if(player.getWickets() >= WICKETS){
                result = player.getName();
                WICKETS = player.getWickets();
            }
        }
        LoggerFile.displayLogs("Highest runs :"+ans+" Highest wicket :" +result);
    }

    public static void topThree(ConcurrentHashMap<String,Player> playerHashMap){
        LoggerFile.displayLogs("Top 3 batsman of the season");
        List<String> ans = playerHashMap.values().stream()
                .sorted(Comparator.comparingInt(Player::getRuns))
                .limit(3)
                .map(player -> player.getName())
                .toList();
        for(String name : ans){
            LoggerFile.displayLogs(name);
        }

        LoggerFile.displayLogs("Top 3 bowler of the season");
        List<String> another = playerHashMap.values().stream()
                .sorted(Comparator.comparingInt(Player::getWickets))
                .limit(3)
                .map(player -> player.getName())
                .collect(Collectors.toList());
        for(String name : another){
            LoggerFile.displayLogs(name);
        }

    }
}
