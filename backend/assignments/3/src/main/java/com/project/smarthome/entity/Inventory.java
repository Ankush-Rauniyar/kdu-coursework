package com.project.smarthome.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "inventory")
public class Inventory {
    @Id
    @Column(name = "kickston_id")
    private String kickstonId;

    @Column(name="device_username")
    private String deviceUsername;

    @Column(name="device_password")
    private String devicePassword;

    @Column(name="manufacture_date_time")
    private String manufactureDateTime;

    @Column(name="manufacture_factory_place")
    private String manufactureFactoryPlace;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime updatedDate;
}
