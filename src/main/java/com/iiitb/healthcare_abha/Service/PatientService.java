package com.iiitb.healthcare_abha.Service;

import com.iiitb.healthcare_abha.DAO.*;

import com.iiitb.healthcare_abha.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientDetails patientDetails;


   public String register_patient(Patient patient){


       if(patientDetails.find_abha_id(patient.getAbhaID())!=null){
           return "patient already exists";
       }
       if(patientDetails.find_email_id(patient.getEmail())!=null){
           return "patient already exists";
       }
       if(patientDetails.findbymobile(patient.getMobile())!=null){
           return "patient already exists";
       }

       patientDetails.save(patient);

      return "patient sucessfully registered";

   }

   public String update_patient_details(String abhaId,Patient patient){

       Patient p =patientDetails.find_abha_id(abhaId);
       if(p==null){
           return "there is no patient with these abhaid";
       }

       patient.setPatientID(p.getPatientID());
       patientDetails.save(patient);


      return "patient sucessfully updated";

   }


    public String delete_patient_details(String abhaId){

        Patient p =patientDetails.find_abha_id(abhaId);
        if(p==null){
            return "there is no patient with these abhaid";
        }


        patientDetails.deleteById(p.getPatientID());


        return "patient sucessfully deleted";

    }

    public List<Patient> get_all_patients(){
      return patientDetails.findAll();
    }

    public String  login_of_patient(login_helper l){
        System.out.println(l.getEmail()+"++++++++++++++"+l.getPassword());
        Patient e= patientDetails.findbyemailandpassword(l.getEmail(),l.getPassword());
        if(e==null){
            return "wrong credintials";
        }
        return "login sucessful";

    }



}