package com.iiitb.healthcare_abha.Controllers;


import com.iiitb.healthcare_abha.Entity.Patient;
import com.iiitb.healthcare_abha.Entity.Patient_Records;
import com.iiitb.healthcare_abha.Entity.login_helper;
import com.iiitb.healthcare_abha.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {


    @Autowired
    private PatientService patientService;





    @PostMapping ("/register")
    public String register_patient(@RequestBody Patient patient){

     return patientService.register_patient(patient);

    }

    @PutMapping("/{abhaId}")
    public String update(@PathVariable String abhaId,@RequestBody Patient patient){
        return patientService.update_patient_details(abhaId,patient);
    }

    @DeleteMapping ("/{abhaId}")
    public String delete(@PathVariable String abhaId){
        return patientService.delete_patient_details(abhaId);
    }

    @GetMapping("/")
    public List<Patient> get_patient_details(){
        return patientService.get_all_patients();
    }



    @PostMapping("/login")
    String  login_of_patient(@RequestBody login_helper l){

        return patientService.login_of_patient(l);

    }

}