package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class JsonProcessor {
    private static final Logger logger = LoggerFactory.getLogger(JsonProcessor.class);
    public static JsonNode convertJson(String path){
        // Read and parse the JSON file
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readTree(new File(path));


        } catch (IOException e) {
            logger.info("could not convert json file tp JSonNode");
            return null;
        }
    }
}
