package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class JsonFileReader {
    class StringUtils { // Compliant

        private StringUtils() {
            throw new IllegalStateException("Utility class");
        }
    }
    private static final Logger logger = LoggerFactory.getLogger(JsonFileReader.class);
    public static JsonNode convertJson(){
        String filePath = "src/main/resources/small_transaction.json";
        // Read and parse the JSON file
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readTree(new File(filePath));


        } catch (IOException e) {
            logger.info("could not convert json file tp JSonNode");
            return null;
        }
    }
}
