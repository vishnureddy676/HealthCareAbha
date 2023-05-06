package com.iiitb.healthcare_abha.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "medic0")
public class Medicine {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Id
    long id;

    @Column(name = "med_name")
    private String medName;

    @Column(name = "dosage")
    private Double dosage;

    @Column(name = "duration")
    private String duration;

   /*@Column(name = "Med_id")
    private long Med_id;*/


    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Med_id",referencedColumnName = "id")
    private Reports report;
}
