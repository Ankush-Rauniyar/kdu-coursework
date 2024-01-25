package com.handson.springhandsonthree.controller;

import com.handson.springhandsonthree.dto.ResponseDto;
import com.handson.springhandsonthree.dto.VehicleDto;
import com.handson.springhandsonthree.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class VehicleController {
    private VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseDto> createVehicle(@RequestBody VehicleDto vehicleDto){
        ResponseDto current = vehicleService.createVehicle(vehicleDto);
        return new ResponseEntity<>(current, HttpStatus.CREATED);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDto> getVehicle(@PathVariable("id") int id){
        ResponseDto current = vehicleService.accessVehicle(id);
        return new ResponseEntity<>(current,HttpStatus.OK);
    }

    @PutMapping("/change")
    public ResponseEntity<ResponseDto> modifyVehicle(@RequestBody VehicleDto vehicleDto){
        ResponseDto current = vehicleService.upgradeVehicle(vehicleDto);
        return new ResponseEntity<>(current,HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<ResponseDto> eraseVehicle(@PathVariable("id") int id){
        ResponseDto responseDto = vehicleService.removeVehicle(id);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }

    @GetMapping("/expense")
    public ResponseEntity<ResponseDto> sortVehicle(@RequestParam String condition){
        ResponseDto current = vehicleService.findVehicleExpense(condition);
        return new ResponseEntity<>(current,HttpStatus.OK);
    }

}
