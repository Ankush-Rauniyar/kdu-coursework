package spring.respository;

import entities.Vehicle;
import config.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class InventoryStore {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(InventoryStore.class);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(VehicleService.class);
        List<Vehicle> factoryone = context.getBean("factoryone",List.class);

        List<Vehicle> factorytwo = context.getBean("factorytwo",List.class);

        List<Vehicle> allVehicles = new ArrayList<>();
        allVehicles.addAll(factoryone);
        allVehicles.addAll(factorytwo);

        Vehicle minimum = new Vehicle();
        minimum.setPrice(Integer.MAX_VALUE);

        Vehicle maximum = new Vehicle();
        maximum.setPrice(Integer.MIN_VALUE);

        for(Vehicle v : allVehicles){
            if(v.getPrice() < minimum.getPrice()){
                minimum = v;
            }
            if(v.getPrice() > maximum.getPrice()){
                maximum = v;
            }
        }

        logger.info("The maximum price of the vehicle is {}, made in {}, speaker of {}, tyre of {}",maximum.getPrice(),maximum.getFactory(),maximum.getSpeaker().getBrand(),maximum.getTyre().getBrand());

        logger.info("The minimum price of the vehicle is {}, made in {}, speaker of {}, tyre of {}",minimum.getPrice(),minimum.getFactory(),minimum.getSpeaker().getBrand(),minimum.getTyre().getBrand());
    }
}