package com.iiitb.healthcare_abha.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
public class Hospital {


    private Integer docNumbers;


        private Integer patientNumbers;


        private Integer frontDeskNumbers;

        private Integer appointmentNumbers;

        private Integer reportsNumbers;
}
