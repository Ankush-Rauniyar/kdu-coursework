package config;

import entities.Speaker;
import entities.Tyre;
import entities.Vehicle;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Import({TyreService.class,SpeakerService.class})
public class VehicleService {

    private final Tyre mrfTyre;
    private final Tyre bridgestoneTyre;
    private final Speaker sonySpeaker;
    private final Speaker boseSpeaker;

    /**
     *
     * @param mrfTyre
     * @param bridgestoneTyre
     * @param sonySpeaker
     * @param boseSpeaker
     */
    @Autowired
    public VehicleService(@Qualifier("mrf") Tyre mrfTyre,
                          @Qualifier("bridgestone") Tyre bridgestoneTyre,
                          @Qualifier("sony") Speaker sonySpeaker,
                          @Qualifier("bose") Speaker boseSpeaker){
        this.mrfTyre = mrfTyre;
        this.boseSpeaker = boseSpeaker;
        this.bridgestoneTyre = bridgestoneTyre;
        this.sonySpeaker = sonySpeaker;
    }

    protected static final ArrayList<Vehicle> factoryOneVehicle = new ArrayList<>();
    protected static final ArrayList<Vehicle> factoryTwoVehicle = new ArrayList<>();

    /**
     *
     * @return List<Vehicle>
     */
    @Bean(name = "factoryone")
    List<Vehicle> listVehiclesOne() {
       return factoryOneVehicle;
    }

    /**
     *
     * @return List<Vehicle>
     */
    @Bean(name = "factorytwo")
    List<Vehicle> listVehiclesTwo() {
        return factoryTwoVehicle;
    }

    /**
     * @author Ankush Rauniyar
     */
    @PostConstruct
    void initialize(){
        int total = 4;
        for(int i = 0 ; i < total ; i++){
            Vehicle vehicle = new Vehicle();
            Vehicle vehicle1 = new Vehicle();

            Tyre tyre = (i < total/2) ? mrfTyre : bridgestoneTyre;
            vehicle.setTyre(tyre);
            vehicle1.setTyre(tyre);

            Speaker speaker = (i % 2 == 0) ? sonySpeaker:boseSpeaker;
            vehicle.setSpeaker(speaker);
            vehicle1.setSpeaker(speaker);

            vehicle.setPrice(800 + vehicle.getSpeaker().getPrice() + vehicle.getTyre().getPrice());
            vehicle1.setPrice(1200 + vehicle1.getSpeaker().getPrice() + vehicle1.getTyre().getPrice());
            vehicle.setFactory("Factory 1");
            vehicle1.setFactory("Factory 2");

            factoryOneVehicle.add(vehicle);
            factoryTwoVehicle.add(vehicle1);
        }
    }
}
