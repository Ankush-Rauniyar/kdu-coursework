package com.handsontwelve.twelvehomework.dao;

import com.handsontwelve.twelvehomework.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {

    @Modifying
    @Query(value = "UPDATE users SET user_name = :userName WHERE user_id = :userId", nativeQuery = true)
    int updateUserDetails(@Param("userId") UUID userId, @Param("userName") String userName);
}