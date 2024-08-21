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
public class ShiftUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID shiftUserId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shift_id")
    private Shift shiftId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private Users userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="tenant_id")
    private Tenant tenantId;
}
