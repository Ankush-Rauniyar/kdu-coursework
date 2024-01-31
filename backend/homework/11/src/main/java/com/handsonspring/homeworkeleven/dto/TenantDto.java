package com.handsonspring.homeworkeleven.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TenantDto {
    private String name;
    private String email;
}
