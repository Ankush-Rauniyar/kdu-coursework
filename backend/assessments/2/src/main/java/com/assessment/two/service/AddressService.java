package com.assessment.two.service;

import com.assessment.two.dao.AddressRepository;
import com.assessment.two.dto.AddressDto;
import com.assessment.two.entity.Address;
import com.assessment.two.exception.ErrorWhileExecutingQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    /**
     *
     * @param address
     * @return
     */
    public AddressDto addAddress(Address address){
        try {
            Address current = addressRepository.save(address);
            return new AddressDto(current.getAddressId(), current.getAddressName());
        }catch (Exception e){
            throw new ErrorWhileExecutingQuery("error while adding address");
        }
    }
}
