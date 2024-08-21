package com.handsontwelve.twelvehomework.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    private String userName;
    private short loggedIn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tenantId")
    private Tenant tenantId;
}
