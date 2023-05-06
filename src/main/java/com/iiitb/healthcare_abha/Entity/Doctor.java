package com.iiitb.healthcare_abha.Entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="doctor")
public class Doctor {

    /*@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    long admin_id;*/

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    long doctor_id;




    @MapsId
    @JoinColumn(name = "doctor_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Employee employee;
    @Column(name = "specialization")
    private String specialization;


    @Column(name = "doctor_shift_start")
    private String doctor_shift_start;

    @Column(name = "doctor_shift_end")

    private String doctor_shift_end;


    @OneToMany(cascade=CascadeType.REMOVE)
    @JoinColumn(name="doc_id")
    private List<Reports> patient_reports;

   /* @OneToMany(cascade=CascadeType.REMOVE)
    @JoinColumn(name="docId")
    private List<Appointements> appointments;*/

    @OneToMany(cascade=CascadeType.REMOVE)
    @JoinColumn(name="docID")
    private List<Appointements> appointments;
    @Column(name="details")
    private String details;

}
