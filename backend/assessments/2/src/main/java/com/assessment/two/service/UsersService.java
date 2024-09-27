package com.assessment.two.service;

import com.assessment.two.dao.UserRepository;
import com.assessment.two.dto.UserDto;
import com.assessment.two.entity.Users;
import com.assessment.two.exception.ErrorWhileExecutingQuery;
import com.assessment.two.mapping.Mapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsersService(UserRepository userRepository,PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public UserDto addUser(Users users){
        try {
            String password = users.getPassword();
            System.out.println(password);
            users.setRole("ROLE_"+users.getRole());
            users.setPassword(passwordEncoder.encode(password));

            Users now = (userRepository.save(users));
            now.setUsername("hello");

            return Mapper.convertToUserDto(userRepository.save(now));
        }catch (Exception e){
            throw new ErrorWhileExecutingQuery("error while adding user");
        }
    }
}
