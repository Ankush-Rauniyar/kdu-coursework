package com.handsonspring.homeworkeleven.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Users {
    private String userId;
    private String userName;
    private short loggedIn = 0;
    private String tenantId;
}
