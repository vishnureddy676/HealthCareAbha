package com.iiitb.healthcare_abha.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "reports")
public class Reports {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private long id;


        @Column(name = "doc_id")
        private long docID;

        @Column(name = "patient_id")
        private long patientID;


        @Column(name = "visit_id")
        private long visitID;


        @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
        @JoinColumn(name="Med_id")
        private List<Medicine> medicines;

       /* @Column(name = "extra_info")
        private String extraInfo;*/

        @Column(name = "patient_blood_group")
        private String patientBloodGroup;

        @Column(name = "patient_disease")
        private String patientDisease;

        @Column(name = "patient_temperature")
        private Double patientTemperature;

        @Column(name = "patient_weight")
        private Double patientWeight;

        @Column(name = "patient_bp")
        private String patientBP;

        @Column(name = "patient_glucose")
        private Double patientGlucose;

        @Column(name = "date")
        private String date;

        @Column(name = "time")
        private String time;

        @ElementCollection
        @CollectionTable(name = "images")
        private List<String> images;

        @Column(name = "created_at")
        private String createdAt;


        @Column(name="extraInfo")
        private String extrainfo;




        // Getters and setters
    }

