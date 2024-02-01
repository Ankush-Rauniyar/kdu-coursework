package com.handsontwelve.twelvehomework.service;

import com.handsontwelve.twelvehomework.dao.*;
import com.handsontwelve.twelvehomework.dto.*;
import com.handsontwelve.twelvehomework.entity.*;
import com.handsontwelve.twelvehomework.exception.ErrorWhileExecutingQuery;
import com.handsontwelve.twelvehomework.mapping.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class AllServices {

    private TenantRepository tenantRepository;
    private ShiftTypesRepository shiftTypesRepository;
    private ShiftRepository shiftRepository;
    private UserRepository userRepository;
    private ShiftUserRepository shiftUserRepository;

    @Autowired
    public AllServices(TenantRepository tenantRepository,ShiftRepository shiftRepository,ShiftUserRepository shiftUserRepository,ShiftTypesRepository shiftTypesRepository,UserRepository userRepository){
        this.shiftRepository =shiftRepository;
        this.shiftTypesRepository = shiftTypesRepository;
        this.userRepository = userRepository;
        this.shiftUserRepository = shiftUserRepository;
        this.tenantRepository = tenantRepository;
    }

    public TenantDto addTenant(Tenant tenant){
        try {
            Tenant tenant1 = tenantRepository.save(tenant);
            return Mapper.convertToTenantDto(tenant1);
        }catch(Exception e){
            throw new ErrorWhileExecutingQuery("error in adding tenant");
        }
    }

    public ShiftTypesDto addShiftType(ShiftType shiftTypes){
        try {
            ShiftType current = shiftTypesRepository.save(shiftTypes);
            return Mapper.convertToShiftTypes(current);
        }catch (Exception e){
            throw new ErrorWhileExecutingQuery("error while adding shifttype");
        }
    }

    public ShiftDto addShift(Shift shift){
        try {
            Shift current = shiftRepository.save(shift);
            return Mapper.convertToShift(current);
        }catch (Exception e){
            throw new ErrorWhileExecutingQuery("error while adding shift");
        }
    }

    public UsersDto addUser(Users users){
        try {
            Users current = userRepository.save(users);
            return Mapper.convertToUsersDto(current);
        }catch (Exception e){
            throw new ErrorWhileExecutingQuery("error while adding users");
        }
    }

    public ShiftUserDto addShiftUser(ShiftUser shiftUser){
        try {
            ShiftUser current = shiftUserRepository.save(shiftUser);
            return Mapper.convertToShiftUserDto(current);
        }catch (Exception e){
            throw new ErrorWhileExecutingQuery("error while adding shift user");
        }
    }

    public Page<Users> getallUsers(int pageNumber, int pageSize) {
        try {
            Pageable pageable = PageRequest.of(pageNumber, pageSize);
            return userRepository.findAll(pageable);
        }catch (Exception e){
            throw new ErrorWhileExecutingQuery("error while adding users");
        }
    }

    public UsersDto deleteUser(UUID id){
        try{

        userRepository.deleteById(id);
        throw new ErrorWhileExecutingQuery("Deleted User successfully");
        }
        catch (Exception r){
            throw new ErrorWhileExecutingQuery("error while deleting user");
        }
    }

    public List<Shift> getTopthree() {
        try {
            return shiftRepository.findAll();
        }catch (Exception e){
            throw new ErrorWhileExecutingQuery("error while getting top three");
        }
    }
    public int updateUser(String userName,UUID id){
        try {
            return userRepository.updateUserDetails(id, userName);
        }catch (Exception e){
            throw new ErrorWhileExecutingQuery("error while updating user");
        }
    }

}
