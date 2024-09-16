package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void executeTransactions(JsonNode jsonTransactions, CountDownLatch latch){
        ExecuteTransaction.countDownLatch = latch;
        int size = jsonTransactions.size();
        ExecutorService executorService = Executors.newFixedThreadPool(200);
        for(JsonNode jsonObject : jsonTransactions){
            ExecuteTransaction executeTransaction = new ExecuteTransaction(jsonObject);
            executorService.submit(executeTransaction);
        }
        executorService.shutdown();

    }


    public static void main(String[] args){
        ExecuteTransaction executeTransaction = new ExecuteTransaction(null);
        String csvFilePath = "src/main/resources/traders.csv";
        HashMap<String,Trader> trades = startReadingTrader(csvFilePath);

        executeTransaction.setHashMapTraders(trades);
        String csvFilePath2 = "src/main/resources/coins.csv";

        HashMap<String,Coins> coins = startReadingCoin(csvFilePath2);

        executeTransaction.setHashMapCoins(coins);


        String filePath = "src/main/resources/small_transaction.json";
        JsonNode jsonNodeTransactions = JsonProcessor.convertJson(filePath);
        if(jsonNodeTransactions == null){
            logger.info("could not read json file");
        }else{
            logger.info("read json file successfully");
        }


        CountDownLatch countDownLatch = new CountDownLatch(jsonNodeTransactions.size());

        executeTransactions(jsonNodeTransactions,countDownLatch);

        try {
            countDownLatch.await();
        }catch (InterruptedException e){
            logger.info("\ncountdown latch await failed ---\n");
        }



        HashMap<String,Trader> traderHashMap = executeTransaction.getHashMapTraders();
        HashMap<String, Coins> coinHashMap = executeTransaction.getHashMapCoins();

        HashMap<String,String> coinsConversion = nameToSymbols(coinHashMap);
        while(true) {
            logger.info("\n retrieve coin details : 1 \n display top N coins in market :2 \n show trader's portfolio : 3 \n show total loss or profit : 4 \n show top 5 traders and bottom 5 traders : 5");
            Scanner sc = new Scanner(System.in);
            int options = sc.nextInt();
            if (options == 1) {
                logger.info("\n coin name : 1 \ncoin symbol :2");
                int choice = sc.nextInt();
                String coinDetails = sc.next();
                if (choice == 2) {
                    showCoinDetails(coinDetails, coinHashMap);
                } else if (choice == 1) {
                    String symbolCoin = coinsConversion.get(coinDetails);
                    showCoinDetails(symbolCoin, coinHashMap);
                }
            } else if (options == 2) {
                logger.info("top how much :");
                int n = sc.nextInt();
                displayTopCoins(coinHashMap, n);
            } else if (options == 3) {
                String wallet = sc.next();
                getPortfolio(wallet, traderHashMap);
            } else if (options == 4) {
                String wallet = sc.next();
                showPortfolioStatus(wallet, traderHashMap);
            } else if (options == 5) {
                showTopBottom(traderHashMap);
            }else if(options == 6){
                break;
            }
        }
    }

    public static void showTopBottom(HashMap<String,Trader> traderHashMap){
        logger.info("top five traders :");
        List<String> topFiveTraders = traderHashMap.values().stream()
                .sorted((c1, c2) -> Double.compare(c2.status, c1.status))
                .limit(5)
                .map(trader -> trader.getFirstName() + trader.getLastName())
                .collect(Collectors.toList());
        topFiveTraders.forEach(logger::info);

        logger.info("bottom five traders :");
        List<String> bottomFiveTraders = traderHashMap.values().stream()
                .sorted((c1, c2) -> Double.compare(c1.status, c2.status))
                .limit(5)
                .map(trader -> trader.getFirstName() + trader.getLastName())
                .collect(Collectors.toList());
        bottomFiveTraders.forEach(logger::info);
    }
    public static void showPortfolioStatus(String wallet,HashMap<String,Trader> traderHashMap){
        Trader trader = traderHashMap.get(wallet);
        double current = trader.status;
        logger.info("Current profit : {}",current);
    }
    public static void getPortfolio(String wallet,HashMap<String,Trader> traderHashMap){
        Trader trader = traderHashMap.get(wallet);
        HashMap<String,Long> hm = trader.portfolio;
        for (HashMap.Entry<String, Long> entry : hm.entrySet()) {
            String symbol = entry.getKey();
            Long volume = entry.getValue();
            logger.info("{} : {}",symbol,volume);
        }
    }

    public static void displayTopCoins(HashMap<String, Coins> coinHashMap, int n){

        List<String> topCoins = coinHashMap.values().stream()
                .sorted((c1, c2) -> Double.compare(c2.getPrice(), c1.getPrice()))
                .limit(n)
                .map(coins -> coins.getName())
                .collect(Collectors.toList());
        logger.info("Top {} coins based on price:",n);
        topCoins.forEach(logger::info);

    }

    public static HashMap<String,String> nameToSymbols(Map<String, Coins> coinsMap){
        HashMap<String,String> hm = new HashMap<>();
        for (HashMap.Entry<String, Coins> entry : coinsMap.entrySet()) {
            String symbol = entry.getKey();
            Coins crypto = entry.getValue();
            String name = crypto.getName();
            hm.put(name,symbol);
        }
        return hm;
    }

    public static void showCoinDetails(String symbol,Map<String, Coins> coinHashMap){
        Coins current = coinHashMap.get(symbol);
        logger.info("Name: {}",current.getName());
        logger.info("Symbol: {}",current.getSymbol());
        logger.info("Price: {}",current.getPrice());
        logger.info("Circulating Supply: {}",current.getVolume());
        logger.info("-----------------------");
    }

    public static HashMap<String,Trader> startReadingTrader(String path){
        return CsvReader.readTraderCsv(path);
    }
    public static HashMap<String,Coins> startReadingCoin(String path){
        return CsvReader.coinReaderCsv(path);
    }
}
