package com.project.smarthome.dao;

import com.project.smarthome.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {
    @Query
    public Optional<Users> findByUsername(String username);
}
