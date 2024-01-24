package com.handson.springhandsonthree.repository;

import com.handson.springhandsonthree.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;

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

    public Vehicle findRequired(String condition){
        if(condition.equals("maximum")){
            return allVehicles.stream()
                    .max(Comparator.comparing(vehicle -> vehicle.getPrice())).get();
        }else{
            return allVehicles.stream()
                    .min(Comparator.comparing(vehicle -> vehicle.getPrice())).get();
        }
    }
}
