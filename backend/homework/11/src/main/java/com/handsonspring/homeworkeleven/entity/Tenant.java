package com.handsonspring.homeworkeleven.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Tenant {
    private String tenantId;
    private String name;
    private String email;
}

