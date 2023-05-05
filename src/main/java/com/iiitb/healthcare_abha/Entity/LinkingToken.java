package com.iiitb.healthcare_abha.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="linking_token_table")
@Entity
@Data
public class LinkingToken {



   /* @EmbeddedId
    private linking_token_pks id;
*/
   @Id
   @Column(name = "patientId")
   private Long patientID;

    @Column(name = "visitId")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long visitId;
    @Column(name="linking_token")
    public String linking_token;


   /*@ManyToOne
    @JoinColumn(name = "patientID", referencedColumnName = "patient_id",insertable=false, updatable=false)
    private Patient patient;*/


   /* public void setLinking_token(String linking_token) {
        this.linking_token = linking_token;
    }*/
}
