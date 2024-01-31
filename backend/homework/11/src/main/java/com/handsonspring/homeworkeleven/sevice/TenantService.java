package com.handsonspring.homeworkeleven.sevice;

import com.handsonspring.homeworkeleven.dao.TenantRepository;
import com.handsonspring.homeworkeleven.dto.AllresourcesTenantDto;
import com.handsonspring.homeworkeleven.dto.ResponseDto;
import com.handsonspring.homeworkeleven.dto.TenantDto;
import com.handsonspring.homeworkeleven.dto.UpdateDto;
import com.handsonspring.homeworkeleven.entity.*;
import com.handsonspring.homeworkeleven.mapping.Mapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantService {
    private TenantRepository tenantRepository;

    @Autowired
    public TenantService(TenantRepository tenantRepository){
        this.tenantRepository = tenantRepository;
    }

    public ResponseDto addOnlyTenant(TenantDto tenantDto){
        Tenant tenant = Mapper.convertToTenant(tenantDto);
        String id = tenantRepository.addTenant(tenant.getName(),tenant.getEmail());
        tenant.setTenantId(id);
        ResponseDto responseDto = new ResponseDto();
        responseDto.addItem("TenantId" + id);
        return responseDto;
    }

    public ResponseDto addOtherItems(AllresourcesTenantDto allresourcesTenantDto){
        ResponseDto responseDto = new ResponseDto();

        String tenantId = tenantRepository.addTenant(allresourcesTenantDto.getName(), allresourcesTenantDto.getEmail());
        Tenant tenant = new Tenant(tenantId,allresourcesTenantDto.getName(),allresourcesTenantDto.getEmail());

        String shiftTypeId = tenantRepository.addShiftType(allresourcesTenantDto.getShiftTypeName(),allresourcesTenantDto.getDescripton(),tenantId);
        ShiftTypes shiftTypes = new ShiftTypes(shiftTypeId, allresourcesTenantDto.getShiftTypeName(),allresourcesTenantDto.getDescripton(),tenant.getTenantId());

        Shift shift = new Shift("", allresourcesTenantDto.getShiftName(),allresourcesTenantDto.getDataStart(),allresourcesTenantDto.getDataEnd(),allresourcesTenantDto.getTimeStart(),allresourcesTenantDto.getTimeEnd(),tenantId);
        String shiftId = tenantRepository.addShift(shift,tenantId,shiftTypeId);
        shift.setShiftId(shiftId);

        Users users = new Users("", allresourcesTenantDto.getUserName(), allresourcesTenantDto.getLoggedIn(),tenantId);
        String userId = tenantRepository.addUsers(users,tenantId);
        users.setUserId(userId);

        String shiftUser = tenantRepository.addshiftUser(shiftId,userId,tenantId);
        ShiftUser shiftUser1 = new ShiftUser(shiftUser,shiftId,userId,tenantId);
        shiftUser1.setShiftUserId(shiftUser);

        responseDto.addItem("tenantId : "+ tenantId);
        responseDto.addItem("shiftTypeId : "+ shiftTypes.getShiftTypeId());
        responseDto.addItem("shiftId :"+shiftId);
        responseDto.addItem("userId :"+ userId);
        responseDto.addItem("shiftUserId : "+ shiftUser);
        return responseDto;
    }

    public ResponseDto updateItem(UpdateDto updateDto){
        String id = tenantRepository.updateUser(updateDto.getUserName(), updateDto.getTenantId());
        ResponseDto responseDto = new ResponseDto();
        responseDto.addItem("TenantId" + updateDto.getTenantId());
        responseDto.addItem("UserId :"+ id);
        return responseDto;
    }
}
