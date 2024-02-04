package com.project.smarthome.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String address;
    private String houseName;


    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonBackReference
    private Users owner;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Users> usersList = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER)
    private List<Room> rooms = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime updatedDate;

}
