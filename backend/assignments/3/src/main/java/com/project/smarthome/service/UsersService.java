package com.project.smarthome.service;

import com.project.smarthome.dao.UsersRepository;
import com.project.smarthome.dto.request.UserRegisterRequestDto;
import com.project.smarthome.dto.response.UserRegisterResponseDto;
import com.project.smarthome.entity.Users;
import com.project.smarthome.mapping.Mapper;
import com.project.smarthome.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private UsersRepository usersRepository;
    private JWTUtil jwtUtil;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public UsersService(UsersRepository usersRepository,
                        JWTUtil jwtUtil,
                        PasswordEncoder passwordEncoder){
        this.usersRepository = usersRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }
    public UserRegisterResponseDto addUser(UserRegisterRequestDto userRegisterRequestDto){
        Users users = Mapper.convertToUser(userRegisterRequestDto);
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        usersRepository.save(users);
        UserRegisterResponseDto current = new UserRegisterResponseDto();
        current.setToken(jwtUtil.getTokenNew(userRegisterRequestDto));
        return current;
    }
}
