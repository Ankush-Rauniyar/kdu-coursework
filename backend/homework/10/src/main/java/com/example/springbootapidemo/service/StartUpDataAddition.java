package com.example.springbootapidemo.service;

import com.example.springbootapidemo.dao.UserDAO;
import com.example.springbootapidemo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StartUpDataAddition implements CommandLineRunner {


    UserDAO personDAO;


    PasswordEncoder passwordEncoder;

    @Autowired
    public StartUpDataAddition(UserDAO userDAO,PasswordEncoder passwordEncoder){
        this.personDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        personDAO.addPerson(new Person("Rohit", "rohit", passwordEncoder.encode("Testing123"), "ROLE_ADMIN"));
        personDAO.addPerson(new Person("Ajay", "ajay", passwordEncoder.encode("Testing123"), "ROLE_USER"));
    }
}
