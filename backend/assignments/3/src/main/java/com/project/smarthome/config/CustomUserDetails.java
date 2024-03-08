package com.project.smarthome.config;

import com.project.smarthome.dao.UsersRepository;
import com.project.smarthome.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomUserDetails implements UserDetailsService {
    private final UsersRepository userRepository;

    @Autowired
    public CustomUserDetails(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optionalUserModel = userRepository.findByUsername(username);
        Users users = null;
        if(optionalUserModel.isPresent())   users = optionalUserModel.get();
        String userUsername;
        String userPassword;
        List<GrantedAuthority> authorities;

        if (users == null) {
            throw new UsernameNotFoundException("User details not found for user: ".concat(username).concat(". Please register first."));
        } else {
            userUsername = users.getUsername();
            userPassword = users.getPassword();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(users.getRole()));
        }
        return new User(userUsername, userPassword, authorities);
    }
}
