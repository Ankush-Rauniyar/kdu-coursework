package spring.handson;

import beans.Vehicle;
import config.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        AnnotationConfigApplicationContext vehicleContext = new AnnotationConfigApplicationContext(VehicleService.class);
        List<Vehicle> vehicles = vehicleContext.getBean(List.class);
        Vehicle current = null;
        int currentprice = 0;
        for(Vehicle vehicle : vehicles){
            if(vehicle.getPrice() > currentprice){
                current = vehicle;
                currentprice = vehicle.getPrice();
            }
        }
     logger.info("{}",current.getPrice() +"-->" + current.getTyre().getBrand() + "<--" + current.getSpeaker().getBrand() );
    }
}