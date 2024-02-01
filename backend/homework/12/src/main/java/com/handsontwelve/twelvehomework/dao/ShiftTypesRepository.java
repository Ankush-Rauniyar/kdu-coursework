package com.handsontwelve.twelvehomework.dao;

import com.handsontwelve.twelvehomework.entity.ShiftType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShiftTypesRepository extends JpaRepository<ShiftType, UUID> {
}
