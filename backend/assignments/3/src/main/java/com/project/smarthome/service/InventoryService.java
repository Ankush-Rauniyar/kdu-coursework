package com.project.smarthome.service;

import com.project.smarthome.dao.InventoryRepository;
import com.project.smarthome.dto.request.AddInventoryRequestDto;
import com.project.smarthome.dto.response.AddInventoryResponseDto;
import com.project.smarthome.dto.response.InventoryListResponseDto;
import com.project.smarthome.dto.response.InventoryStockDto;
import com.project.smarthome.entity.Inventory;
import com.project.smarthome.exception.ErrorWhileExecutingQuery;
import com.project.smarthome.mapping.Mapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class InventoryService {
    private InventoryRepository inventoryRepository;
    @Autowired
    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    public InventoryListResponseDto getAllDevices(){
        try {
            List<Inventory> inventoryList = inventoryRepository.findAll();
            InventoryListResponseDto inventoryListResponseDto = new InventoryListResponseDto();
            String innt = Mapper.convertToJson(inventoryList);
            inventoryListResponseDto.setInventory(innt);
            return inventoryListResponseDto;
        }catch (Exception e){
            throw new ErrorWhileExecutingQuery("error while accessing inventoryList");
        }
    }

    public AddInventoryResponseDto addInventory(AddInventoryRequestDto addInventoryRequestDto){
        Inventory inventory = Mapper.convertToInventory(addInventoryRequestDto);
        Inventory current = inventoryRepository.save(inventory);

        AddInventoryResponseDto addInventoryResponseDto = new AddInventoryResponseDto();
        addInventoryResponseDto.setObject(current.getDeviceUsername());
        return addInventoryResponseDto;
    }

}
