package questionthree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class ExchangePosition {
    private static final Logger logger = LoggerFactory.getLogger(ExchangePosition.class);
    
    public <T> void changeposition(T[] array,int first,int second){
        logger.info("before changing index {}", Arrays.toString(array));
        T temp = array[first];
        array[first] = array[second];
        array[second] = temp;
        logger.info("after changing index {}", Arrays.toString(array));
    }
}
