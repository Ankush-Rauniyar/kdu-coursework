package com.project.smarthome.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Device {
    @Id
    @Column(name="kickston_id")
    private String kickstonId;

    @Column(name="device_username")
    private String deviceUsername;

    @Column(name="device_password")
    private String devicePassword;
}
