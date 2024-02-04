package com.project.smarthome.dao;

import com.project.smarthome.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device,String> {
    Optional<Device> findByKickstonId(String kickstonId);
}
