package assessment.one;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import com.opencsv.CSVWriter;
public class WritetoCSV {
    public static void matchFixtures(HashSet<String> name){
        try {
            String csvFile = "matches.csv";
            CSVWriter writer = new CSVWriter(new FileWriter(csvFile));


            String[] header = { "Date", "Match Number", "Team home" ,"Team away","Ground"};
            writer.writeNext(header);

            ArrayList<String> teamsList = new ArrayList<>(name);
            int matchNumber = 1;
            for(int i = 0; i < teamsList.size() ; i++){
                String[] data = new String[5];
                data[0] ="date";
                for(int j = 0 ; j < teamsList.size() ; j++){
                    if(j == i){
                        continue;
                    }
                    data[1] = Integer.toString(matchNumber);
                    matchNumber++;
                    data[2] = teamsList.get(i);
                    data[3] = teamsList.get(j);
                    data[4] = teamsList.get(i) + "_HOME";
                    LoggerFile.displayLogs(Arrays.toString(data));
                    writer.writeNext(data);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
