package com.handson.springhandsonthree.repository;

import com.handson.springhandsonthree.entity.Vehicle;
import com.handson.springhandsonthree.exceptions.BadOperationRequestException;
import com.handson.springhandsonthree.exceptions.VehicleNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

@Repository
public class VehicleRepository {
    private  ArrayList<Vehicle> allVehicles = new ArrayList<>();
    private Logger logger = LoggerFactory.getLogger(VehicleRepository.class);

    /**
     *
     * @param vehicle
     * @return
     */
    public  Vehicle addVehicle(Vehicle vehicle){
        int size = allVehicles.size();
            allVehicles.add(vehicle);
            if(size == allVehicles.size()){
                logger.error("Error while adding new vehicle");
                throw new BadOperationRequestException("adding a new vehicle.");
            }
            logger.info("Added new vehicle Successfully.");
            return vehicle;

    }

    /**
     *
     * @param id
     * @return
     * @throws VehicleNotFoundException
     */
    public  Vehicle getVehicle(int id) throws VehicleNotFoundException{
        for(Vehicle vehicle : allVehicles){
            if(vehicle.getId() == id){
                logger.info("received vehicle of id {} successfully.",id);
                return vehicle;
            }
        }
        logger.error("Could not get vehicle id of {}",id);
        throw new VehicleNotFoundException(id);
    }

    /**
     *
     * @param index
     * @param vehicle
     * @return
     */
    public  Vehicle updateVehicle(int index, Vehicle vehicle){
        if(index < 0 || index >= allVehicles.size()){
            logger.error("Could not access the index : {}",index);
            throw new BadOperationRequestException("updating a vehicle");
        }
        Vehicle current = allVehicles.get(index);
        current.setId(vehicle.getId());
        current.setModel(vehicle.getModel());
        current.setFactoryLocation(vehicle.getFactoryLocation());
        logger.info("updated the vehicle at index :{} successfully",index);
        return vehicle;
    }

    /**
     *
     * @param id
     * @return
     */
    public  Vehicle deleteVehicle(int id){
        for(Vehicle v : allVehicles){
            if(v.getId() == id){
               allVehicles.remove(v);
               logger.info("Removed vehicle of id : {} successfully",id);
               return v;
            }
        }
        logger.error("Could not delete vehicle  of id : {} - ERROR",id);
        throw new BadOperationRequestException("deleting a vehicle");
    }

    /**
     *
     * @param condition
     * @return
     */
    public Vehicle findRequired(String condition) {
        if ("maximum".equals(condition)) {
            logger.info("successfully retrieved most expensive vehicle.");
            return findVehicleWithExtremePrice(Comparator.comparing(Vehicle::getPrice), true);
        } else if ("minimum".equals(condition)) {
            logger.info("successfully retrieved least expensive vehicle.");
            return findVehicleWithExtremePrice(Comparator.comparing(Vehicle::getPrice), false);
        } else {
            logger.error("Unknown query was passed - ERROR");
            throw new BadOperationRequestException("finding based on query");
        }
    }

    /**
     *
     * @param comparator
     * @param findMax
     * @return
     */
    private Vehicle findVehicleWithExtremePrice(Comparator<Vehicle> comparator, boolean findMax) {
        Optional<Vehicle> result = findMax ? allVehicles.stream().max(comparator) : allVehicles.stream().min(comparator);
        return result.orElseThrow(() -> new BadOperationRequestException("No vehicles found during query operation"));
    }

}
