package com.handsontwelve.twelvehomework.mapping;

import com.handsontwelve.twelvehomework.dto.*;
import com.handsontwelve.twelvehomework.entity.*;

public class Mapper {

    private Mapper(){

    }
    public static TenantDto convertToTenantDto(Tenant tenant){
        return new TenantDto(tenant.getTenantId(), tenant.getName());
    }

    public static ShiftTypesDto convertToShiftTypes(ShiftType shiftTypes){
        return new ShiftTypesDto(shiftTypes.getShiftTypeId(),shiftTypes.getShiftTypeName(),shiftTypes.getShiftTypeId());
    }

    public static ShiftDto convertToShift(Shift shift){
        return new ShiftDto(shift.getShiftId(),shift.getShiftName());
    }

    public static UsersDto convertToUsersDto(Users users){
        return  new UsersDto(users.getUserId(),users.getUserName());
    }

    public static ShiftUserDto convertToShiftUserDto(ShiftUser shiftUser){
        return  new ShiftUserDto(shiftUser.getShiftUserId());
    }
}
