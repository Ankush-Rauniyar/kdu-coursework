package com.handson.springhandsonthree.controller;

import com.handson.springhandsonthree.dto.VehicleDto;
import com.handson.springhandsonthree.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/add")
    public ResponseEntity<VehicleDto> createVehicle(@RequestBody VehicleDto vehicleDto){
        VehicleDto current = vehicleService.createVehicle(vehicleDto);
        return new ResponseEntity<>(current, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<VehicleDto> getVehicle(@PathVariable("id") int id){
        VehicleDto current = vehicleService.accessVehicle(id);
        return new ResponseEntity<>(current,HttpStatus.OK);
    }

    @PutMapping("/change")
    public ResponseEntity<VehicleDto> modifyVehicle(@RequestBody VehicleDto vehicleDto){
        VehicleDto current = vehicleService.upgradeVehicle(vehicleDto);
        return new ResponseEntity<>(current,HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<VehicleDto> eraseVehicle(@PathVariable("id") int id){
        VehicleDto vehicleDto = vehicleService.removeVehicle(id);
        return new ResponseEntity<>(vehicleDto,HttpStatus.OK);
    }

    @GetMapping("/expense")
    public ResponseEntity<VehicleDto> sortVehicle(@RequestParam String condition){
        VehicleDto current = vehicleService.findVehicleExpense(condition);
        return new ResponseEntity<>(current,HttpStatus.OK);
    }

}
