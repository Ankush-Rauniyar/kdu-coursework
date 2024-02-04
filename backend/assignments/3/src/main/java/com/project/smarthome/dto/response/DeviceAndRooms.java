package com.project.smarthome.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceAndRooms {
    private String houseId;
    private String houseName;
    private String houseAddress;
    private List<RoomDto> roomDtoList;
}
