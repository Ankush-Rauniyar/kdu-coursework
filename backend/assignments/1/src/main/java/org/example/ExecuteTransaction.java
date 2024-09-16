package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class ExecuteTransaction  implements Runnable{

    private final static Logger logger = LoggerFactory.getLogger(ExecuteTransaction.class);
    public static HashMap<String, Trader> hashMapTraders;
    public static HashMap<String, Coins> hashMapCoins;

    private JsonNode jsonNode;

    public static CountDownLatch countDownLatch;
    private static final ReentrantLock tradersLock = new ReentrantLock();
    private static final ReentrantLock coinsLock = new ReentrantLock();

    public ExecuteTransaction(JsonNode jsonNode){
        this.jsonNode = jsonNode;

    }
    public synchronized void setHashMapTraders(HashMap<String,Trader> traderHashMap){
        this.hashMapTraders = traderHashMap;
    }

    public synchronized void setHashMapCoins(HashMap<String,Coins> coinsHashMap){
        this.hashMapCoins = coinsHashMap;
    }

    public synchronized HashMap<String,Trader> getHashMapTraders(){
        return this.hashMapTraders;
    }

    public synchronized HashMap<String, Coins> getHashMapCoins() {
        return hashMapCoins;
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }


    public void run(){
        logger.info("initating transaction");
//sta
        JsonNode transaction = this.getJsonNode();
        String type = transaction.get("type").asText();
        JsonNode data = transaction.get("data");
        int counter = 1;
        while(true) {
            boolean state = false;
            logger.info("{}",type);
            if(type.equals("BUY")) {
                 state = buyCall(data);
            } else if (type.equals("SELL")) {
                 state = sellCall(data);
            } else if (type.equals("UPDATE_PRICE")) {
                state = updatePrice(data);
            } else if (type.equals("ADD_VOLUME")) {
                state = addVolume(data);
            }
            if(state){
                countDownLatch.countDown();
                break;
            }else{

                try {
                    Thread.sleep(100);
                    logger.info("slept - {}",type);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    logger.warn("Thread interrupted while sleeping.");
                }
                if(counter > 10){
                    countDownLatch.countDown();
                    break;
                }
                counter++;
            }
        }
        logger.info("transaction completed successfully");
    }
    private String getBlockHash() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder transactionHash = new StringBuilder();
        Random rnd = new Random();
        for (double i = 0; i < 199999999; i++) {
            i = i;
        }
        while (transactionHash.length() < 128) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            transactionHash.append(SALTCHARS.charAt(index));
        }
        String hashCode = transactionHash.toString();
        return "0x" + hashCode.toLowerCase();
    }

public static boolean buyCall(JsonNode data) {
    String wallet = data.get("wallet_address").asText();
    String symbol = data.get("coin").asText();
    long vol = data.get("quantity").asLong();

    tradersLock.lock();
    try {
        Trader trader = hashMapTraders.get(wallet);
        if (trader == null) {
            logger.error("Trader not found for wallet: {}", wallet);
            return false;
        }

        Coins coins = hashMapCoins.get(symbol);
        if (coins == null) {
            logger.error("Coin not found for symbol: {}", symbol);
            return false;
        }

        long currentVolume = coins.getVolume();
        if (currentVolume < vol) {
            logger.info("Insufficient volume to buy. Symbol: {}, Current Volume: {}, Requested Volume: {}", symbol, currentVolume, vol);
            return false;
        }

        HashMap<String, Long> portfolio = trader.portfolio;
        HashMap<String, Double> priceHistory = trader.boughtPrice;

        coinsLock.lock();
        try {
            if (!portfolio.containsKey(symbol)) {
                portfolio.put(symbol, vol);
            } else {
                long prev = portfolio.get(symbol);
                portfolio.put(symbol, vol + prev);
            }

            coins.setVolume(currentVolume - vol);
            priceHistory.put(symbol, hashMapCoins.get(symbol).getPrice());
            logger.info("Buy successful. Symbol: {}, Volume: {}", symbol, vol);
            trader.setStatus(trader.getStatus() + (-1 * vol * coins.getPrice()));
            return true;
        } finally {
            coinsLock.unlock();
        }
    } finally {
        tradersLock.unlock();
    }
}


public static boolean sellCall(JsonNode data) {
    String symbol = data.get("coin").asText();
    String wallet = data.get("wallet_address").asText();
    long vol = data.get("quantity").asLong();

    tradersLock.lock();
    try {
        Trader trader = hashMapTraders.get(wallet);
        if (trader == null) {
            logger.error("Trader not found for wallet: {}", wallet);
            return false;
        }

        HashMap<String, Long> portfolio = trader.portfolio;
        if (!portfolio.containsKey(symbol)) {
            logger.info("Cannot sell. Symbol not found in portfolio. Symbol: {}, Wallet: {}", symbol, wallet);
            return true;
        }

        long currentVolume = portfolio.get(symbol);

        logger.info("Before Sell. Symbol: {}, Wallet: {}, Current Volume: {}, Requested Volume: {}", symbol, wallet, currentVolume, vol);

        if (vol == currentVolume) {
            portfolio.remove(symbol);
            double profitLoss = (hashMapCoins.get(symbol).getPrice() - trader.boughtPrice.get(symbol)) * vol;
            trader.setStatus(trader.getStatus() + profitLoss);
            trader.boughtPrice.remove(symbol);
            logger.info("Sell successful. Symbol: {}, Volume: {}, Profit/Loss: {}", symbol, vol, profitLoss);
            return true;
        } else if (vol < currentVolume) {
            portfolio.put(symbol, currentVolume - vol);
            double profitLoss = (hashMapCoins.get(symbol).getPrice() - trader.boughtPrice.get(symbol)) * vol;
            trader.setStatus(trader.getStatus() + profitLoss);
            logger.info("Sell successful. Symbol: {}, Volume: {}, Profit/Loss: {}", symbol, vol, profitLoss);
            return true;
        } else {
            logger.info("Cannot sell. Requested volume greater than current volume. Symbol: {}, Requested Volume: {}, Current Volume: {}", symbol, vol, currentVolume);
            return true;
        }
    } finally {
        tradersLock.unlock();
    }
}


    public static boolean updatePrice(JsonNode data){
        String symbol = data.get("coin").asText();
        Coins current = hashMapCoins.get(symbol);

        double price = data.get("price").asDouble();
        current.setPrice(price);
        return true;

    }
    public static boolean addVolume(JsonNode data){
        String symbol = data.get("coin").asText();
        long volume = data.get("volume").asLong();
        Coins current = hashMapCoins.get(symbol);
        long curVol = current.getVolume();
        current.setVolume(curVol + volume);
        return true;
    }


}
