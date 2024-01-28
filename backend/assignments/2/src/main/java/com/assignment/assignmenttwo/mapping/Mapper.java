package com.assignment.assignmenttwo.mapping;

import com.assignment.assignmenttwo.dto.ResponseForwardGeocoding;
import com.assignment.assignmenttwo.dto.ResponseReverseGeocoding;
import com.assignment.assignmenttwo.entity.LocationEntity;

public class Mapper {

    private Mapper() {
    }

    /**
     *
     * @param location
     * @return
     */
    public static ResponseForwardGeocoding convertToForwardResponse(LocationEntity location){
        return new ResponseForwardGeocoding(location.getLatitude(), location.getLongitude());
    }

    /**
     *
     * @param location
     * @return
     */
    public static ResponseReverseGeocoding convertToReverseResponse(LocationEntity location){
        return new ResponseReverseGeocoding(location.getLabel());
    }

    public static Mapper createMapper() {
        return new Mapper();
    }
}
