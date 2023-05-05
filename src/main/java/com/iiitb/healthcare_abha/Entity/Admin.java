package com.iiitb.healthcare_abha.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="admin")
public class Admin {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    long admin_id;



    @MapsId
    @JoinColumn(name = "admin_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Employee employee;


    @Column(name="education")
    private String education;


}
