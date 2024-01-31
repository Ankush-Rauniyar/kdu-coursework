package com.handsonspring.homeworkeleven.controller;

import com.handsonspring.homeworkeleven.dto.AllresourcesTenantDto;
import com.handsonspring.homeworkeleven.dto.ResponseDto;
import com.handsonspring.homeworkeleven.dto.TenantDto;
import com.handsonspring.homeworkeleven.dto.UpdateDto;
import com.handsonspring.homeworkeleven.sevice.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TenantController {
    TenantService tenantService;

    @Autowired
    public TenantController(TenantService tenantService){
        this.tenantService = tenantService;
    }

    @PostMapping("/tenant/add")
    public ResponseEntity<ResponseDto> addTenant(@RequestBody TenantDto tenantDto){
        return new ResponseEntity<>(tenantService.addOnlyTenant(tenantDto), HttpStatus.OK);
    }

    @PostMapping("/tenant/all")
    public ResponseEntity<ResponseDto> addAllDetails(@RequestBody AllresourcesTenantDto allresourcesTenantDto){
        return  new ResponseEntity<>(tenantService.addOtherItems(allresourcesTenantDto),HttpStatus.OK);
    }

    @PostMapping("/tenant/update")
    public ResponseEntity<ResponseDto> updateItem(@RequestBody UpdateDto updateDto){
        return new ResponseEntity<>(tenantService.updateItem(updateDto),HttpStatus.OK);
    }
}
