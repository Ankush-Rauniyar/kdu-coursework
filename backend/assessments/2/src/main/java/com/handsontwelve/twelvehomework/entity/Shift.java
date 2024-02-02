package com.handsontwelve.twelvehomework.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID shiftId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="shift_type_id")
    private ShiftType shiftTypeId;

    private String shiftName;
    private Timestamp dateStart;
    private Timestamp dateEnd;
    private Timestamp timeStart;
    private Timestamp timeEnd;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="tenant_id")
    private Tenant tenantId;
}
