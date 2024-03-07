package com.handsonspring.homeworkeleven.mapping;

import com.handsonspring.homeworkeleven.dto.TenantDto;
import com.handsonspring.homeworkeleven.entity.Tenant;

public class Mapper {
    public static Tenant convertToTenant(TenantDto tenantDto){
        return new Tenant("",tenantDto.getName(), tenantDto.getEmail());
    }
}
