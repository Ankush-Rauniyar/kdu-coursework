package com.handsontwelve.twelvehomework.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class ShiftType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID shiftTypeId;
    private String shiftTypeName;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="tenant_id")
    private Tenant tenant;
}
