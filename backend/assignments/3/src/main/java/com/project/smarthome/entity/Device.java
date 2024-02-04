package com.project.smarthome.entity;

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
    private String kickstonId;
    private String deviceUsername;
    private String devicePassword;
}
