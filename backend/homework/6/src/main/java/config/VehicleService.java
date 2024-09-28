package config;

import beans.Speaker;
import beans.Tyre;
import beans.Vehicle;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
@Import({TyreService.class,SpeakerService.class})
public class VehicleService {
    protected static final ArrayList<Vehicle> allVehicles = new ArrayList<>();

    @Bean
    ArrayList<Vehicle> listVehicles(){
        return allVehicles;
    }

    @PostConstruct
    void initialize(){
        AnnotationConfigApplicationContext tyreContext = new AnnotationConfigApplicationContext(TyreService.class);
        AnnotationConfigApplicationContext speakerContext = new AnnotationConfigApplicationContext(SpeakerService.class);
        int total = 10;
        String currenttyre = "";
        String currentSpeaker ="";
        for(int i = 0 ; i < total ; i++){
            Vehicle vehicle = new Vehicle();
            if(i < total/2){
                 currenttyre = "mrf";
            }else {
                currenttyre ="bridgestone";
            }
            Tyre tyre = tyreContext.getBean(currenttyre,Tyre.class);
            vehicle.setTyre(tyre);

            if(i % 2 == 0){
                currentSpeaker ="sony";
            }else{
                currentSpeaker ="bose";
            }
            Speaker speaker = speakerContext.getBean(currentSpeaker,Speaker.class);
            vehicle.setSpeaker(speaker);
            vehicle.setPrice(vehicle.getSpeaker().getPrice() + vehicle.getTyre().getPrice());
            allVehicles.add(vehicle);
        }
    }
}
