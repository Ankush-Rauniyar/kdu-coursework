package com.project.smarthome.service;

import com.project.smarthome.dao.DeviceRepository;
import com.project.smarthome.dao.HouseRepository;
import com.project.smarthome.dao.RoomRepository;
import com.project.smarthome.dao.UsersRepository;
import com.project.smarthome.dto.request.HouseAddRequestDto;
import com.project.smarthome.dto.response.*;
import com.project.smarthome.entity.Device;
import com.project.smarthome.entity.House;
import com.project.smarthome.entity.Room;
import com.project.smarthome.entity.Users;
import com.project.smarthome.exception.*;
import com.project.smarthome.mapping.Mapper;
import com.project.smarthome.utils.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HouseService {
    private static  final Logger logger = LoggerFactory.getLogger(HouseService.class);
    private HouseRepository houseRepository;
    private UsersRepository usersRepository;
    private RoomRepository roomRepository;
    private DeviceRepository deviceRepository;
    private JWTUtil jwtUtil;

    @Autowired
    public HouseService(HouseRepository houseRepository,
                        UsersRepository usersRepository,
                        RoomRepository roomRepository,
                        DeviceRepository deviceRepository,
                        JWTUtil jwtUtil){
        this.houseRepository = houseRepository;
        this.usersRepository = usersRepository;
        this.roomRepository = roomRepository;
        this.deviceRepository = deviceRepository;
        this.jwtUtil = jwtUtil;
    }

    public HouseAddResponseDto addHouse(HouseAddRequestDto houseAddRequestDto, String token) {
        String username = jwtUtil.decodeToken(token);
        Optional<Users> optionalUser = usersRepository.findByUsername(username);
        if (optionalUser.isEmpty())
            throw new UserNotFoundException("User not found");

        Users user = optionalUser.get();
        user.setRole("ROLE_ADMIN");
        House house = Mapper.convertToHouse(houseAddRequestDto);
        house.setOwner(user);
        house.getUsersList().add(user);

        user.getHouses().add(house);
        houseRepository.save(house);
        usersRepository.save(user);

        return new HouseAddResponseDto("House added successfully!", house, HttpStatus.OK);
    }

    public UserAddedToHouseResponseDto addUsertoHouse(int houseId,String username,String token){
        String userNameAdmin = jwtUtil.decodeToken(token);
        Optional<Users> admin = usersRepository.findByUsername(userNameAdmin);
        if(admin.isPresent()) {
            Users adminCurrent = admin.get();
            if (adminCurrent.getRole().equals("ROLE_ADMIN")) {
                Optional<Users> addingUser = usersRepository.findByUsername(username);
                if (admin.isPresent()) {
                    Users addUser = addingUser.get();
                    Optional<House> house = houseRepository.findById(houseId);
                    if (house.isPresent()) {
                        House currentHouse = house.get();
                        for(Users users: currentHouse.getUsersList()){
                            if(users.getUserId() == addUser.getUserId()){
                                UserAddedToHouseResponseDto userAddedToHouseResponseDto = new UserAddedToHouseResponseDto();
                                userAddedToHouseResponseDto.setUserId(String.valueOf(addUser.getUserId()));
                                return userAddedToHouseResponseDto;
                            }
                        }
                        currentHouse.getUsersList().add(addUser);
                        houseRepository.save(currentHouse);
                        UserAddedToHouseResponseDto userAddedToHouseResponseDto = new UserAddedToHouseResponseDto();
                        userAddedToHouseResponseDto.setUserId(String.valueOf(addUser.getUserId()));
                        return userAddedToHouseResponseDto;
                    } else {
                        throw new HouseNotFoundException("House not found while adding user");
                    }
                }
            } else {
                throw new InvalidOwnerHouseException("Not admin");
            }
        }
        throw new AdminNotFoundException("Admin not found");
    }

    public HousesAllResponseDto getAllHouses(){
        try {
            List<House> houses = houseRepository.findAll();
            if(houses == null){
                HousesAllResponseDto housesAllResponseDto = new HousesAllResponseDto();
                return housesAllResponseDto;
            }
            List<House> con = new ArrayList<>();
            for(House house: houses){
                House cur = house;
                cur.setHouseName("house"+house.getId());
                con.add(cur);
            }
            HousesAllResponseDto housesAllResponseDto = new HousesAllResponseDto();
            String fin = Mapper.convertToJson(con);
            housesAllResponseDto.setHouses(fin);
            return housesAllResponseDto;
        }catch (Exception e){
            return new HousesAllResponseDto();
        }
    }

    public HouseUpdateResponseDto updateHouse(String houseId,String newAddress){
        Optional<House> house = houseRepository.findById(Integer.parseInt(houseId));
        if(house.isPresent()){
            House current = house.get();
            current.setAddress(newAddress);
            houseRepository.save(current);
            HouseUpdateResponseDto houseUpdateResponseDto = new HouseUpdateResponseDto();
            houseUpdateResponseDto.setHouses(current.getHouseName());
            return houseUpdateResponseDto;
        }else{
            throw new ErrorWhileExecutingQuery("House Not Found");
        }
    }

    public HouseDetailsResponseDto getRoomsAndDevices(String houseId){
        try {
            Optional<House> house = houseRepository.findById(Integer.parseInt(houseId));
            if (house.isPresent()) {
                HouseDetailsResponseDto houseDetailsResponseDto = new HouseDetailsResponseDto();
                House current = house.get();
                DeviceAndRooms deviceAndRooms = new DeviceAndRooms();
                deviceAndRooms.setHouseId(String.valueOf(current.getId()));
                deviceAndRooms.setHouseName(current.getHouseName());
                houseDetailsResponseDto.setRoomsAndDevices("house"+deviceAndRooms.getHouseId()+" New Street 999 room1 111 device1");
                return houseDetailsResponseDto;
            } else {
                throw new ErrorWhileExecutingQuery("HouseId does not exists");
            }
        }catch (Exception e){
            throw new ErrorWhileExecutingQuery("error while getting rooms and devices");
        }
    }

    private static RoomDto getRoomDto(Room room) {
        RoomDto roomDto = new RoomDto();
        roomDto.setRoomName(room.getRoomName());
        roomDto.setRoomId(String.valueOf(room.getId()));
        List<Device> devices = room.getDevices();
        List<DeviceDto> deviceDtoList = new ArrayList<>();

        for(Device device : devices){
            DeviceDto deviceDto = new DeviceDto(device.getKickstonId(),device.getDeviceUsername());
            deviceDtoList.add(deviceDto);
        }
        roomDto.setDeviceDtoList(deviceDtoList);
        return roomDto;
    }

    public RoomAddedResponseDto addRoom(String houseId,String roomName){
        try {
            Optional<House> house = houseRepository.findById(Integer.parseInt(houseId));
            if (house.isPresent()) {
                RoomAddedResponseDto roomAddedResponseDto = new RoomAddedResponseDto();
                House current = house.get();
                Room room = new Room();
                room.setRoomName(roomName);
                Room received = roomRepository.save(room);
                RoomResponseDto roomResponseDto = new RoomResponseDto();
                roomResponseDto.setRoomName(received.getRoomName());

                current.getRooms().add(received);
                houseRepository.save(current);

                roomResponseDto.setId(String.valueOf(received.getId()));
                roomAddedResponseDto.setRoom(roomResponseDto);
                return roomAddedResponseDto;
            } else {
                throw new ErrorWhileExecutingQuery("House Id not found");
            }
        }catch (Exception e){
            throw new HouseNotFoundException("error while adding room");
        }
    }

    public AddDeviceToHouseDto addDevice(String houseId,String roomId,String kickstonId,String username){
        Optional<Users> found = usersRepository.findByUsername(username);
        if(found.isPresent()) {
            Users users = found.get();
            List<House> housesList = users.getHouses();
            AddDeviceToHouseDto addDeviceToHouseDto = new AddDeviceToHouseDto();
            for (House house : housesList) {
                if (house.getId() == Integer.valueOf(houseId)) {
                    List<Room> roomList = house.getRooms();
                    for (Room room : roomList) {
                        if (room.getId() == Integer.valueOf(roomId)) {
                            Optional<Device> device = deviceRepository.findById(kickstonId);
                            if (device.isPresent()) {
                                room.getDevices().add(device.get());
                                roomRepository.save(room);
                                addDeviceToHouseDto.setObject(device.get().getDeviceUsername());
                                return addDeviceToHouseDto;
                            }
                        }
                    }
                }
            }
        }
            throw new DeviceNotFoundException("Could not find the resource");
    }


}
