package com.iiitb.healthcare_abha.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class linking_token_pks implements Serializable {



        //private Book book;

        //@ManyToOne
        //@GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "patientID")
        private Long patientID;



        @Column(name = "visit_id")
        //@GeneratedValue(strategy = GenerationType.AUTO)
        private Long visit_id;

        public linking_token_pks( Long patient_id, long visit_id) {
            this.patientID = patient_id;
            this.visit_id = visit_id;
        }

    public linking_token_pks() {


        }
}
