package com.iiitb.healthcare_abha.Entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="patient")
public class Patient {

    /*@Column(name = "patient_id")

    Long patient_id;*/


    /*@Column(name = "abha_id",nullable = false)
    String abha_id;

    @Column(name = "aadhar_id")
    int aadhar_id;

    @Column(name = "patient_name")
    String patient_name;
    @Column(name = "mobile_number",nullable = false)
    int mobile_number;

    @Column(name = "email")
    String email;
    @Column(name = "password",nullable = false)
    String password;*/


    @Column(name = "user_type")
    private String userType = "patient";

    @Column(name = "patient_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long patientID;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "abha_id")
    private String abhaID;

    @Column(name = "mobile")
    private long mobile;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password = "password";

    @Column(name = "gender")
    private String gender;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "dob")
    private String DOB;

    @Column(name = "address")
    private String address;

    @Column(name = "image")
    private String image;

    @Column(name = "details")
    private String details;

    @Column(name = "date")
    private String date;


    @OneToMany(cascade =CascadeType.REMOVE,fetch = FetchType.LAZY)
    @JoinColumn(name ="patient_id")
    private List<Reports> patient_reports;


    @OneToMany(cascade =CascadeType.REMOVE,fetch = FetchType.LAZY)
    @JoinColumn(name ="patientId")
    private List<LinkingToken> linkingTokens;


 /*  @OneToMany(cascade =CascadeType.REMOVE,fetch =FetchType.LAZY)
    @JoinColumn(name ="patientID")
    private List<Patient_visit> patient_visits;*/


    @OneToMany(cascade=CascadeType.REMOVE,fetch = FetchType.LAZY)
    @JoinColumn(name="patientID")
    private List<Appointements> appointments;

}
