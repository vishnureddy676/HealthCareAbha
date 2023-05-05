package com.iiitb.healthcare_abha.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Patient_visit")
public class Patient_visit {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    long Id;

    @Column(name = "patientId")
    private Long patientID;

    @Column(name = "visitId")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long visitId;


   /* @Id
    @Column(name = "patient_id")
    private Long patientID;

    @Column(name = "visitId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long visitId;*/
/*

    @EmbeddedId
    @AttributeOverrides( {
            @AttributeOverride(name="patientId", column = @Column(name="patientId") ),
            @AttributeOverride(name="visitId", column = @Column(name="visitId") )

    } )
    private Patient_visit_pks patient_visitId;

*/

   /* @ManyToOne
    @JoinColumn(name = "patientID", referencedColumnName = "patient_id",insertable=false, updatable=false)
    private Patient patient;*/








}
