package com.iiitb.healthcare_abha.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class patient_record_pks implements Serializable {



    //private Book book;

    //@ManyToOne
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long patient_id;



        @Column(name = "visit_id")
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long visit_id;

        public patient_record_pks( Long patient_id, long visit_id) {
            this.patient_id = patient_id;
            this.visit_id = visit_id;
        }

    public patient_record_pks() {

    }
}

