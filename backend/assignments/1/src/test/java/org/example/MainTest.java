package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.databind.JsonNode;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the org.example.Main class functionalities.
 */
public class MainTest {

    private static Map<String, Coins> coinNameMap;
    private static Map<String, Coins> coinCodeMap;
    private static Coins coinOne;
    private static final List<Coins> coins = new ArrayList<>();

    /**
     * Sets up test data before running any tests.
     */
    @BeforeAll
    public static void populateData() {
        coinNameMap = new HashMap<>();
        coinCodeMap = new HashMap<>();

        Coins coinOne = new Coins(1, "Bitcoin", "BTC", 10000.0, 100L);
        Coins coinTwo = new Coins(2, "Ethereum", "ETH", 5000.0, 50L);
        Coins coinThree = new Coins(3, "Cardano", "ADA", 2000.0, 30L);
        Coins coinFour = new Coins(3, "Solana", "SOL", 1000.0, 150L);

        coins.add(coinOne);
        coins.add(coinTwo);
        coins.add(coinThree);
        coins.add(coinFour);

        coinNameMap.put(coinOne.getName(), coinOne);
        coinNameMap.put(coinTwo.getName(), coinTwo);

        coinCodeMap.put(coinOne.getSymbol(), coinOne);
        coinCodeMap.put(coinTwo.getSymbol(), coinTwo);
    }

    /**
     * Test case to validate the parsing of CSV files in the org.example.Main class.
     * This test ensures that the `parseCSV` method correctly reads and parses the content of a sample CSV file,
     * comparing the expected data with the actual parsed data, covering both coin and trader CSV files.
     *
     * @throws IOException If an I/O error occurs during the test.
     * @see Main#startReadingCoin(String)
     */
    @Test
    public void testParseCSV() throws IOException {
        // check for coins.csv
        Path coinCsvPath = Path.of("src/test/resources/coins.csv");
        ArrayList<String[]> expectedCoins = new ArrayList<>();
        expectedCoins.add(new String[]{"1", "Bitcoin", "BTC", "34194.58", "18938712"});
        expectedCoins.add(new String[]{"2", "Ethereum", "ETH", "2270.78", "119292815"});
        expectedCoins.add(new String[]{"3", "Tether", "USDT", "1.00", "78311766178"});
        expectedCoins.add(new String[]{"4", "BNB", "BNB", "351.39", "165116761"});
        expectedCoins.add(new String[]{"5", "USD Coin", "USDC", "1.00", "47861732704"});
        expectedCoins.add(new String[]{"6", "Cardano", "ADA", "1.02", "33550574442"});
        HashMap<String,Coins> actual = Main.startReadingCoin(String.valueOf(coinCsvPath));

        ArrayList<String[]> current = convertHashMapToArrayList(actual);

        Assertions.assertEquals(expectedCoins.size(), actual.size());
        for (int i = 0; i < expectedCoins.size(); i++) {
            String[] expectedRow = expectedCoins.get(i);
            String[] actualRow = current.get(i);
            Assertions.assertArrayEquals(expectedRow,actualRow);
        }

        //check for traders.csv
        Path traderCsvPath = Path.of("src/test/resources/traders.csv");
        ArrayList<String[]> expectedTraders = new ArrayList<>();
        expectedTraders.add(new String[]{"James", "Butt", "504-621-8927", "0x6048710a582fc9ebc9f46afd0fcda2f8"});
        expectedTraders.add(new String[]{"Josephine", "Darakjy", "810-292-9388", "0x5a1fcde6a86ea0dd483f33d81f35000f"});
        expectedTraders.add(new String[]{"Art", "Venere", "856-636-8749", "0xaf903c532c73b66c934f6e2356344bb0"});
        expectedTraders.add(new String[]{"Lenna", "Paprocki", "907-385-4412", "0xab190b6af9471e4c8e717418e940423c"});
        expectedTraders.add(new String[]{"Donette", "Foller", "513-570-1893", "0xbe3887c02d3d33e16ba49b3607c50e3a"});
        expectedTraders.add(new String[]{"Simona", "Morasca", "419-503-2484", "0xbd670dbca4260f5f1403b555bbe2dd9e"});
        HashMap<String,Trader> actualTraders = Main.startReadingTrader(String.valueOf(traderCsvPath));

        ArrayList<String[]> cur = convertHashMapToArrayListTrader(actualTraders);

        Assertions.assertEquals(expectedTraders.size(), actualTraders.size());

        for (int i = 0; i < expectedTraders.size(); i++) {
            String[] expectedRow = expectedCoins.get(i);
            String[] actualRow = cur.get(i);
            Assertions.assertArrayEquals(expectedRow, actualRow);
        }
    }

    /**
     * Comprehensive test case for validating the concurrent execution of transactions in the org.example.Main class.
     * This test checks the concurrent execution of transactions using JSON files with transaction data.
     * It creates a CountDownLatch to synchronize the completion of transactions across multiple threads.
     * After initiating the transactions, the test waits for a specified time for all threads to finish
     * using latch.await(), and then asserts specific conditions based on the test scenario.
     * The CountDownLatch is used to coordinate the completion of concurrent transactions.
     * In the org.example.ExecuteTransaction class, the latch.countDown() is called in the run method,
     * signaling that a transaction thread has completed its execution, and the latch count is decremented.
     *
     * @see Main#executeTransactions(JsonNode, CountDownLatch)
     * @see ExecuteTransaction
     */
    @Test
    public void testConcurrentTransactions() {
        JsonNode transactionArray;
        int numberOfThreads = 3;
        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        transactionArray = JsonProcessor.convertJson("src/test/resources/test_transaction_1.json");

        new Main();
        Main.executeTransactions(transactionArray, latch);


        try {
            latch.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(0, latch.getCount());
    }

    /**
     * Comprehensive test case for concurrent execution of transactions in the org.example.Main class.
     * This test uses a different JSON file ("test_transaction_2.json") for concurrent execution,
     * creating a CountDownLatch for synchronization. After initiating the transactions,
     * the test waits for a specified time for all threads to finish using latch.await(),
     * and then asserts specific conditions based on the test scenario.
     * The CountDownLatch is used to coordinate the completion of concurrent transactions.
     * In the org.example.ExecuteTransaction class, the latch.countDown() is called in the run method,
     * signaling that a transaction thread has completed its execution, and the latch count is decremented.
     *
     * @see Main#executeTransactions(JsonNode, CountDownLatch)
     * @see ExecuteTransaction
     */
    @Test
    public void testConcurrentTransactions1() {
        JsonNode transactionArray;
        int numberOfThreads = 3;
        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        transactionArray = JsonProcessor.convertJson("src/test/resources/test_transaction_2.json");

        new Main();
        Main.executeTransactions(transactionArray, latch);

        try {
            latch.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(1, latch.getCount());
    }

    /**
     * Comprehensive test case for validating concurrent execution
     * with a medium-sized transactions file.
     * This test checks the concurrent execution of transactions
     * using a medium-sized JSON file with transaction data.
     * It creates a CountDownLatch to synchronize the completion
     * of transactions across multiple threads.
     * After initiating the transactions, the test waits for a
     * specified time for all threads to finish using latch.await(),
     * and then asserts the latch count reached 0.
     *
     * @see Main#executeTransactions(JsonNode, CountDownLatch)
     * @see ExecuteTransaction
     */
    @Test
    public void testConcurrentTransactionsMediumFile() {
        JsonNode transactionArray;
        int numberOfThreads = 12;
        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        transactionArray = JsonProcessor.convertJson("src/test/resources/test_transaction_3.json");

        Main.executeTransactions(transactionArray, latch);

        try {
            latch.await(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(0, latch.getCount());
    }

    /**
     * Comprehensive test case for validating concurrent execution
     * with a large transactions file.
     * This test checks the concurrent execution of transactions
     * using a large JSON file with transaction data.
     * It creates a CountDownLatch to synchronize the completion
     * of transactions across multiple threads.
     * After initiating the transactions, the test waits for a
     * specified time for all threads to finish using latch.await(),
     * and then asserts the latch count reached 0.
     *
     * @see Main#executeTransactions(JsonNode, CountDownLatch)
     * @see ExecuteTransaction
     */
    @Test
    public void testConcurrentTransactionsLargeFile() {
        JsonNode transactionArray;
        int numberOfThreads = 20;
        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        transactionArray =JsonProcessor.convertJson("src/test/resources/test_transaction_4.json");

        Main.executeTransactions(transactionArray, latch);

        try {
            latch.await(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(0, latch.getCount());
    }

    /**
     * This test ensures that the `org.example.ExecuteTransaction` class implements the `Runnable` interface,
     * confirming that it is being used in a concurrent execution context.
     *
     * @see ExecuteTransaction
     */
    @Test
    void testExecuteTransactionImplementsRunnable() {
        // Create an instance of org.example.ExecuteTransaction
        ExecuteTransaction executeTransaction = new ExecuteTransaction(null);

        // Check if the org.example.ExecuteTransaction class implements the Runnable interface
        assertTrue(executeTransaction instanceof Runnable, "org.example.ExecuteTransaction should implement Runnable");
    }
    public static ArrayList<String[]> convertHashMapToArrayList(HashMap<String, Coins> coinMap) {
        ArrayList<String[]> arrayListOfArrays = new ArrayList<>();

        for (Map.Entry<String, Coins> entry : coinMap.entrySet()) {
            Coins coin = entry.getValue();

            // Create an array of primitive data from the Coin object
            String[] array = new String[5];
            array[0] = String.valueOf(coin.getRank());
            array[1] = String.valueOf(coin.getName());
            array[2] = String.valueOf(coin.getSymbol());
            array[3] = String.valueOf(coin.getPrice());
            array[4] = String.valueOf(coin.getVolume());

            // Add the array to the list
            arrayListOfArrays.add(array);
        }
        return arrayListOfArrays;
    }
    public static ArrayList<String[]> convertHashMapToArrayListTrader(HashMap<String, Trader> traderHashMap) {
        ArrayList<String[]> arrayListOfArrays = new ArrayList<>();

        for (Map.Entry<String, Trader> entry : traderHashMap.entrySet()) {
            Trader trader = entry.getValue();

            // Create an array of primitive data from the Coin object
            String[] array = new String[4];
            array[0] = String.valueOf(trader.getFirstName());
            array[1] = String.valueOf(trader.getLastName());
            array[2] = String.valueOf(trader.getPhone());
            array[3] = String.valueOf(trader.getWalletAdderss());

            // Add the array to the list
            arrayListOfArrays.add(array);
        }
        return arrayListOfArrays;
    }
}