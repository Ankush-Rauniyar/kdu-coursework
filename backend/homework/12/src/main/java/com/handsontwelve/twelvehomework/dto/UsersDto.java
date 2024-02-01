package com.handsontwelve.twelvehomework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor

public class UsersDto {
    private UUID usersId;
    private String userName;
}
