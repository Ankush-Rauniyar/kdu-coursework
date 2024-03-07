package com.handson.springhandsonthree.repository;

import com.handson.springhandsonthree.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class VehicleRepository {
    private  ArrayList<Vehicle> allVehicles = new ArrayList<>();

    public  Vehicle addVehicle(Vehicle vehicle){
        allVehicles.add(vehicle);
        return vehicle;
    }

    public  Vehicle getVehicle(int id){
        for(Vehicle vehicle : allVehicles){
            if(vehicle.getId() == id){
                return vehicle;
            }
        }
        return null;
    }

    public  Vehicle updateVehicle(int index, Vehicle vehicle){
        Vehicle current = allVehicles.get(index);
        current.setId(vehicle.getId());
        current.setModel(vehicle.getModel());
        current.setFactoryLocation(vehicle.getFactoryLocation());
        return vehicle;
    }

    public  Vehicle deleteVehicle(int id){
        for(Vehicle v : allVehicles){
            if(v.getId() == id){
                allVehicles.remove(v);
                return v;
            }
        }
        return null;
    }

    public Vehicle findRequired(String condition) {
        if ("maximum".equals(condition)) {
            return findVehicleWithExtremePrice(Comparator.comparing(Vehicle::getPrice), true);
        } else if ("minimum".equals(condition)) {
            return findVehicleWithExtremePrice(Comparator.comparing(Vehicle::getPrice), false);
        } else {
            throw new IllegalArgumentException("Invalid condition: " + condition);
        }
    }

    private Vehicle findVehicleWithExtremePrice(Comparator<Vehicle> comparator, boolean findMax) {
        Optional<Vehicle> result = findMax ? allVehicles.stream().max(comparator) : allVehicles.stream().min(comparator);
        return result.orElseThrow(() -> new NoSuchElementException("No vehicles found"));
    }

}
