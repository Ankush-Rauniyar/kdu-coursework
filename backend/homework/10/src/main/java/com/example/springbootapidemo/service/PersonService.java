package com.example.springbootapidemo.service;

import com.example.springbootapidemo.dao.UserDAO;
import com.example.springbootapidemo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {


    private UserDAO personDAO;

    @Autowired
    public PersonService(UserDAO userDAO){
        this.personDAO = userDAO;
    }

    public void addPerson(Person person){
        personDAO.addPerson(person);
    }

    public Person getPersonById(int id){
        return personDAO.getPersonByIdx(id);
    }

    public String getRoleById(int id){
        return personDAO.getRoleByPersonIdx(id);
    }

    public Person getPersonUsername(String name){
        for(Person p : personDAO.getAllPersons()){
            if(p.getUsername().equals(name)){
                return p;
            }
        }
        return null;
    }
}
