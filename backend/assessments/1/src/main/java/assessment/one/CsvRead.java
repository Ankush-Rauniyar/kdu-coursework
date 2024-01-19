package assessment.one;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class CsvRead {
    public static ConcurrentHashMap<String,Player> readingPlayers() {
        String path = "src/main/java/assessment/one/IPL_2021-data.csv";
        int count = 0;

        ConcurrentHashMap<String,Player> playerHashMap = new ConcurrentHashMap<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();

            while ((line = br.readLine()) != null) {

                String[] fields = line.split(",");


                String name = fields[0].trim();
                String teamName = fields[1].trim();
                String role = fields[2].trim();
                int matches = Integer.parseInt(fields[3].trim());
                int runs = Integer.parseInt(fields[4].trim());
                double average = Double.parseDouble(fields[5].trim());
                double strikeRate = Double.parseDouble(fields[6].trim());
                int wickets = Integer.parseInt(fields[7].trim());


                Player player = new Player();

                player.setName(name);
                player.setAverage(average);
                player.setTeam(teamName);
                player.setMatches(matches);
                player.setRole(role);
                player.setRuns(runs);
                player.setStrikeRate(strikeRate);
                player.setWickets(wickets);

                LoggerFile.displayLogs(name);

               playerHashMap.put(name,player);
               count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        LoggerFile.displayLogs("total players : " + String.valueOf(count));
        return playerHashMap;
    }
}
