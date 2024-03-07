package com.example.springbootapidemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    String name;
    int age;

    String password;

    String phoneNo;
}

/***
 * {
 *     "laptop_name": "",
 *     "laptop_model": "",
 *     "laptop_color": "",
 *     "user_name": "",
 *     "user_age": ""
 * }
 *
 * {
 *     "laptop_id" :
 *     "user_roll_no":
 * }
 *
 *
 */
