package com.handsonspring.homeworkeleven.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AllresourcesTenantDto {
    private String name ;
    private String email;
    private String shiftTypeName;
    private String descripton;
    private String shiftName;
    private String timeStart;
    private String timeEnd;
    private boolean active = true;
    private String userName;
    private String dataStart;
    private String dataEnd;
    private short loggedIn = 0;
}
