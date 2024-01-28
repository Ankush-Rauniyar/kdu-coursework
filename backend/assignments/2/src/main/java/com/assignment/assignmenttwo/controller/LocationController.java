package com.assignment.assignmenttwo.controller;

import com.assignment.assignmenttwo.dto.RequestReverseGeoCodingDto;
import com.assignment.assignmenttwo.dto.ResponseForwardGeocoding;
import com.assignment.assignmenttwo.dto.ResponseReverseGeocoding;
import com.assignment.assignmenttwo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
    private LocationService locationService;

    /**
     *
     * @param locationService
     */
    @Autowired
    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    /**
     *
     * @param address@Cacheable(cacheNames = "reverse-geocoding",key="{#latitude,#longitude}")
     * @return
     */
    @GetMapping("/geocoding")
    public ResponseEntity<ResponseForwardGeocoding> getCoordinates(@RequestParam String address){
        ResponseForwardGeocoding responseForwardGeocoding = locationService.getLatitudeLongitude(address);
        return new ResponseEntity<>(responseForwardGeocoding, HttpStatus.OK);
    }

    /**
     *
     * @param latitude
     * @param longitude
     * @return
     */
    @GetMapping("/reverse-geocoding")
    public ResponseEntity<String> getAddress(@RequestParam String latitude, @RequestParam String longitude){
        RequestReverseGeoCodingDto requestReverseGeoCoding = new RequestReverseGeoCodingDto(latitude,longitude);
        ResponseReverseGeocoding responseReverseGeocoding = locationService.getAddressDetails(requestReverseGeoCoding);
        return new ResponseEntity<>(responseReverseGeocoding.getAddress(),HttpStatus.OK);
    }
}
