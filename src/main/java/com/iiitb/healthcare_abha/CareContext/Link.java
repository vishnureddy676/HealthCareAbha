package com.iiitb.healthcare_abha.CareContext;

public class Link {
        private String accessToken;
        Patient_p PatientObject;


        // Getter Methods

        public String getAccessToken() {
            return accessToken;
        }

        public Patient_p getPatient() {
            return PatientObject;
        }

        // Setter Methods

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public void setPatient(Patient_p patientObject) {
            this.PatientObject = patientObject;
        }
    }

