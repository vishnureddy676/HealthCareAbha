package com.iiitb.healthcare_abha.Controllers;


import com.iiitb.healthcare_abha.Entity.DoctorHelper;
import com.iiitb.healthcare_abha.Entity.Patient;
import com.iiitb.healthcare_abha.Entity.Patient_Records;
import com.iiitb.healthcare_abha.Entity.login_helper;
import com.iiitb.healthcare_abha.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patient")
public class PatientController {


    @Autowired
    private PatientService patientService;





    @PostMapping ("/register")
    public ResponseEntity<Map<String, Object>>  register_patient(@RequestBody Patient patient){
        Map<String, Object> response = new HashMap<>();
     String s=patientService.register_patient(patient);
     if(s.equals("patient already exists")){
         response.put("message","patient already exists");

         return ResponseEntity.ok().body(response);
     }
        response.put("patient",patient);
        response.put("message","patient registered sucessfully");
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{abhaId}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable String abhaId,@RequestBody Patient patient){
        Map<String, Object> response = new HashMap<>();
        String s= patientService.update_patient_details(abhaId,patient);
      if(s.equals("there is no patient with these abhaid")){
          response.put("message","there is no patient with these abhaid");

          return ResponseEntity.ok().body(response);
      }
        response.put("patient",patient);
        response.put("message","patient updated sucessfully");
        return ResponseEntity.ok().body(response);

    }

    @DeleteMapping ("/{abhaId}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable String abhaId){
        Map<String, Object> response = new HashMap<>();
        String s=patientService.delete_patient_details(abhaId);

        if(s.equals("there is no patient with these abhaid")){
            response.put("message","there is no patient with these abhaid");

            return ResponseEntity.ok().body(response);
        }
        //response.put("patient",patient);
        response.put("message","patient with this abhaId "+ abhaId +"deleted sucessfully");
        return ResponseEntity.ok().body(response);

    }

    @GetMapping("/")
    public ResponseEntity<List<Patient>> get_patient_details(){

        return ResponseEntity.ok().body(patientService.get_all_patients());
    }




    @PostMapping("/login")
    String  login_of_patient(@RequestBody login_helper l){

        return patientService.login_of_patient(l);

    }

}