package com.handsontwelve.twelvehomework.controller;

import com.handsontwelve.twelvehomework.dto.*;
import com.handsontwelve.twelvehomework.entity.*;
import com.handsontwelve.twelvehomework.service.AllServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AllController {
    private AllServices allServices;

    @Autowired
    public AllController(AllServices allServices){
        this.allServices = allServices;
    }

    @GetMapping("/a")
    public String checking(){
        return "Helo";
    }
    @PostMapping("/app/tenant")
    public ResponseEntity<TenantDto> addTenant(@RequestBody Tenant tenant){
        TenantDto tenantDto = allServices.addTenant(tenant);
        return new ResponseEntity<>(tenantDto,HttpStatus.OK);
    }

    @PostMapping("app/shifttype")
    public ResponseEntity<ShiftTypesDto> addShiftType(@RequestBody ShiftType shiftTypes){
        ShiftTypesDto shiftTypesDto = allServices.addShiftType(shiftTypes);
        return new ResponseEntity<>(shiftTypesDto,HttpStatus.OK);
    }

    @PostMapping("app/shift")
    public ResponseEntity<ShiftDto> addShift(@RequestBody Shift shift){
        ShiftDto shiftDto = allServices.addShift(shift);
        return new ResponseEntity<>(shiftDto,HttpStatus.OK);
    }

    @PostMapping("app/user")
    public ResponseEntity<UsersDto> addUser(@RequestBody Users users){
        UsersDto usersDto = allServices.addUser(users);
        return new ResponseEntity<>(usersDto,HttpStatus.OK);
    }

    @PostMapping("app/shiftuser")
    public ResponseEntity<ShiftUserDto> addShiftUser(@RequestBody ShiftUser shiftUser){
        ShiftUserDto shiftUserDto = allServices.addShiftUser(shiftUser);
        return new ResponseEntity<>(shiftUserDto,HttpStatus.OK);
    }

    @GetMapping("app/get")
    public ResponseEntity<Page<Users>> getAllUsers(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "50") int pageSize
    ) {
        pageNumber = Math.max(0, pageNumber);
        pageSize = Math.min(50, Math.max(1, pageSize));
        Page<Users> usersPage = allServices.getallUsers(pageNumber, pageSize);
        return new ResponseEntity<>(usersPage, HttpStatus.OK);
    }

    @DeleteMapping("app/user/{shiftuserId}")
    public ResponseEntity<UsersDto> deleteUser(@PathVariable("shiftuserId") UUID id){
        return new ResponseEntity<>(allServices.deleteUser(id),HttpStatus.OK);
    }

    @GetMapping("app/top")
    public ResponseEntity<List<Shift>> getTopThree(){
        return new ResponseEntity<>(allServices.getTopthree(),HttpStatus.OK);
    }

    @GetMapping("app/update")
    public ResponseEntity<Integer> update(@RequestParam String name,@RequestParam UUID id){
        return new ResponseEntity<>(allServices.updateUser(name,id),HttpStatus.OK);
    }




}
