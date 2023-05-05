package com.iiitb.healthcare_abha.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Data
@Entity
@Table(name = "appointments")
public class Appointements {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ïd")
    long id;
    @Column(name = "patientID")
    private Long patientID;



    @Column(name = "visitID")
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long visitId;


    @Column(name = "userType")
    @ColumnDefault("'patient'")
    private String userType;


   /* @ManyToOne
    @JoinColumn(name = "patientID", referencedColumnName = "patient_id", insertable = false, updatable = false)
    private Patient patient;*/


    @Column(name = "abhaID")
    private String abhaID;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "dob")
    private String DOB;

    @Column(name = "mobile")
    private Number mobile;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "disease")
    private String disease;

    @Column(name = "department")
    private String department;

    @Column(name = "time")
    private String time;

    @Column(name = "date")
    private String date;

    @Column(name = "gender")
    private String gender;


    @Column(name="docID")
    private Long docID;


   /* @ManyToOne
    @JoinColumn(name = "docID", referencedColumnName = "doctor_id", insertable = false, updatable = false)
    private Doctor doctor;
*/
}