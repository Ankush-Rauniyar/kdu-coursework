package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CsvReader {
    public static HashMap<String,Trader> readTraderCsv(){
        HashMap<String, Trader> tradersMap = new HashMap<>();

        // Path to your CSV file
        String csvFilePath = "src/main/resources/traders.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            // Skip the header line if it exists
            String line = br.readLine();

            // Read each line from the CSV file
            while ((line = br.readLine()) != null) {
                // Split the line into fields
                String[] fields = line.split(",");

                // Extract information from the fields
                String firstName = fields[1].trim();
                String lastName = fields[2].trim();
                String walletAddress = fields[4].trim();
                String phoneNumber = fields[3].trim();


                // Create a Trader object
                Trader trader = new Trader();
                trader.setFirstName(firstName);
                trader.setPhone(phoneNumber);
                trader.setLastName(lastName);
                trader.setWalletAdderss(walletAddress);

                tradersMap.put(walletAddress, trader);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return tradersMap;
    }

    public static HashMap<String, Coins> coinReaderCsv(){

        String csvFilePath = "src/main/resources/coins.csv";
        HashMap<String, Coins> cryptoMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            // Skip the header line if it exists
            String line = br.readLine();

            // Read each line from the CSV file
            while ((line = br.readLine()) != null) {
                // Split the line into fields

                String[] fields = line.split(",");

                // Extract information from the fields
                int rank = Integer.parseInt(fields[1].trim());
                String name = fields[2].trim();
                String symbol = fields[3].trim();
                double price = Double.parseDouble(fields[4].trim());
                long circulatingSupply = Long.parseLong(fields[5].trim());

                // Create a Crypto object
                Coins coins = new Coins();
                coins.setName(name);
                coins.setPrice(price);
                coins.setRank(rank);
                coins.setSymbol(symbol);
                coins.setVolume(circulatingSupply);

                cryptoMap.put(symbol, coins);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cryptoMap;
    }
}
