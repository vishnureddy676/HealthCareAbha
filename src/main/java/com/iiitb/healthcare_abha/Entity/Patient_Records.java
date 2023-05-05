package com.iiitb.healthcare_abha.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="Patient_Records")
public class Patient_Records {

    @EmbeddedId
    private patient_record_pks id;
    @Column(name = "abha_id",nullable = false)
   private String abha_id;
    @Column(name = "patient_name")
   private String patient_name;



   /* @Column(name = "DateAndTime", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date DateAndTime;*/

    @Column(name="analysis")
  private String analysis;


   // @Lob
    @Column(name = "reports_url")
    private String reports_url;

    //@Lob
    @Column(name = "prescription_url")
    private String prescription_url;

//    @JoinColumn(name = "doctor_id",columnDefinition = )
//    @ManyToOne(targetEntity = Doctor.class,fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
//    private Doctor doctor;
//
//    @Column(name = "doctor_id",updatable = false,insertable =false)
//    private Long doctor_id_fk;
//
    /*@Column(name = "doctor_id_fky", columnDefinition = "BIGINT, foreign key (doctor_id_fky) REFERENCES Doctor(doctor_id)")
   private Long doctor_id;*/


         @Column(name="doctor_id")
         private long doctor_id;



}
