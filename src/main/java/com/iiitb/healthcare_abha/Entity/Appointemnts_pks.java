package com.iiitb.healthcare_abha.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class Appointemnts_pks implements Serializable {



    //private Book book;

    //@ManyToOne
    //@GeneratedValue(strategy = GenerationType.IDENTITY)




  /*  public Appointemnts_pks( Long patient_id, long visit_id) {
        this.patientID = patient_id;
        this.visitId = visit_id;
    }*/

    public Appointemnts_pks() {


    }
}
