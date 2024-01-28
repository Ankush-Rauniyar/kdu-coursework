package com.assignment.assignmenttwo.service;

import com.assignment.assignmenttwo.dto.RequestReverseGeoCodingDto;
import com.assignment.assignmenttwo.dto.ResponseForwardGeocoding;
import com.assignment.assignmenttwo.dto.ResponseReverseGeocoding;
import com.assignment.assignmenttwo.entity.LocationEntity;
import com.assignment.assignmenttwo.mapping.Mapper;
import com.assignment.assignmenttwo.repository.LocationRepository;
import com.assignment.assignmenttwo.repository.ReverseLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    private LocationRepository locationRepository;
    private ReverseLocationRepository reverseLocationRepository;

    /**
     *
     * @param locationRepository
     * @param reverseLocationRepository
     */
    @Autowired
    public LocationService(LocationRepository locationRepository,ReverseLocationRepository reverseLocationRepository){
        this.reverseLocationRepository = reverseLocationRepository;
        this.locationRepository = locationRepository;
    }

    /**
     *
     * @param address
     * @return
     */
    public ResponseForwardGeocoding getLatitudeLongitude(String address){
        LocationEntity current = locationRepository.getCoordinates(address);
        return Mapper.convertToForwardResponse(current);
    }

    /**
     *
     * @param requestReverseGeoCodingDto
     * @return
     */
    public ResponseReverseGeocoding getAddressDetails(RequestReverseGeoCodingDto requestReverseGeoCodingDto){
        LocationEntity current = reverseLocationRepository.getAddressLabel(requestReverseGeoCodingDto.getLatitude(),requestReverseGeoCodingDto.getLongitude());
        return Mapper.convertToReverseResponse(current);
    }
}
