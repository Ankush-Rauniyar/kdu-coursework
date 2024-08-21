package assessment.one;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerFile {

    private static final Logger logger = LoggerFactory.getLogger(LoggerFile.class);
    public static void displayLogs(String msg){
        logger.info("{}",msg);
    }
}
