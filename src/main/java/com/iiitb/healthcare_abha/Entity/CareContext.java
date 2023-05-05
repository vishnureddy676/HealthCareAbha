package com.iiitb.healthcare_abha.Entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

@Entity
@Data
@Table(name="carecontext")
public class CareContext {

    @Column(name="patient_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long patient_id;
    @Column(length = 65535)
    String token;


}
