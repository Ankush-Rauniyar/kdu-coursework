package com.project.smarthome.controller;
import com.project.smarthome.dto.request.*;
import com.project.smarthome.dto.response.*;
import com.project.smarthome.service.DeviceService;
import com.project.smarthome.service.HouseService;
import com.project.smarthome.service.InventoryService;
import com.project.smarthome.service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController()
public class AllController {
    private UsersService usersService;
    private HouseService houseService;
    private InventoryService inventoryService;
    private DeviceService deviceService;
    private static final Logger logger = LoggerFactory.getLogger(AllController.class);

    @Autowired
    public AllController(UsersService usersService,
                         HouseService houseService,
                         InventoryService inventoryService,
                         DeviceService deviceService)
    {
        this.usersService= usersService;
        this.houseService = houseService;
        this.inventoryService = inventoryService;
        this.deviceService =deviceService;

    }

    @PostMapping("/api/v1/auth/register")
    public UserRegisterResponseDto registerUser(@RequestBody UserRegisterRequestDto userRegisterRequestDto){

        UserRegisterResponseDto userRegisterResponseDto = usersService.addUser(userRegisterRequestDto);
        return userRegisterResponseDto;
    }

    @PostMapping("/api/v1/house")
    public HouseAddResponseDto addHouse(@RequestBody HouseAddRequestDto houseRegisterRequestDto, HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("Authorization").substring(7);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return houseService.addHouse(houseRegisterRequestDto,token);
    }

    @PostMapping("/api/v1/house/{houseId}/add-user")
    public UserAddedToHouseResponseDto addUserToHouse(@PathVariable String houseId,@RequestBody UserAddToHouseRequestDto userAddToHouseRequestDto,HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("Authorization").substring(7);
        try{
            Integer i = Integer.parseInt(houseId);
        }
        catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
        return houseService.addUsertoHouse(Integer.parseInt(houseId),userAddToHouseRequestDto.getUsername(),token);
    }

    @GetMapping("/api/v1/house")
    public HousesAllResponseDto getHousesList(){
        return houseService.getAllHouses();
    }

    @PutMapping("/api/v1/house")
    public HouseUpdateResponseDto updateHouseAddress(@RequestParam String houseId,@RequestBody NewAddressOfHouseDto newAddressOfHouseDto ){
        return houseService.updateHouse(houseId,newAddressOfHouseDto.getAddress());
    }

    @GetMapping("/api/v1/house/{houseId}")
    public HouseDetailsResponseDto getRoomsAndDevices(@PathVariable String houseId){
        return houseService.getRoomsAndDevices(houseId);
    }

    @PostMapping("/api/v1/room")
    public RoomAddedResponseDto addRoom(@RequestParam String houseId,@RequestBody RoomRequestDto roomRequestDto){
        return houseService.addRoom(houseId,roomRequestDto.getRoomName());
    }

    @GetMapping("/api/v1/inventory")
    public InventoryListResponseDto getAllInventory(){
        return inventoryService.getAllDevices();
    }

    @PostMapping("api/v1/inventory")
    public AddInventoryResponseDto addInventory(@RequestBody AddInventoryRequestDto addInventoryRequestDto){
        return inventoryService.addInventory(addInventoryRequestDto);
    }

    @PostMapping("/api/v1/device/register")
    public RegisterDeviceResponseDto registerDevice(@RequestBody RegisterDeviceRequestDto registerDeviceRequestDto){

        return deviceService.addDevice(registerDeviceRequestDto);
    }

    @PostMapping("/api/v1/device/add")
    public AddDeviceToHouseDto addDevice(@RequestBody AddDeviceRequestDto addDeviceRequestDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return houseService.addDevice(addDeviceRequestDto.getHouseId(),addDeviceRequestDto.getRoomId(),addDeviceRequestDto.getKickstonId(),username);
    }

}
