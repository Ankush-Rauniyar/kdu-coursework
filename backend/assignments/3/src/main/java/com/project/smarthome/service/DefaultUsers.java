package com.project.smarthome.service;

import com.project.smarthome.dao.UsersRepository;
import com.project.smarthome.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DefaultUsers implements CommandLineRunner {

    UsersRepository userRepository;


    PasswordEncoder passwordEncoder;
    @Autowired
    public DefaultUsers(UsersRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args)  {
        Users admin = new Users();
        admin.setUsername("ankush");
        admin.setName("ANkush R");
        admin.setFirstName("ank");
        admin.setLastName("rauni");
        admin.setPassword(passwordEncoder.encode("password"));
        admin.setEmailId("ankush@gmail.com");
        admin.setRole("ROLE_ADMIN");
        userRepository.save(admin);

        Users normal = new Users();
        normal.setName("raunak R");
        normal.setFirstName("raunak");
        normal.setLastName("rauni");
        normal.setUsername("customer");
        normal.setEmailId("customer@gmail.com");
        normal.setRole("ROLE_USER");
        normal.setPassword(passwordEncoder.encode("password"));
        userRepository.save(normal);
    }
}
