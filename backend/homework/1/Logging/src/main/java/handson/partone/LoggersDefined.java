package handson.partone;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class LoggersDefined {
    private static Logger logger = LoggerFactory.getLogger(LoggersDefined.class);
    public void loggingStoringing(String message){
        logger.info(message);
    }

    public static Logger getLoggerMessage(){
        return logger;
    }

}
