package com.iiitb.healthcare_abha.Controllers;


import com.iiitb.healthcare_abha.Entity.DoctorHelper;
import com.iiitb.healthcare_abha.Entity.Patient;
import com.iiitb.healthcare_abha.Entity.Patient_Records;
import com.iiitb.healthcare_abha.Entity.login_helper;
import com.iiitb.healthcare_abha.JWT.JwtService;
import com.iiitb.healthcare_abha.Service.DoctorService;
import com.iiitb.healthcare_abha.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
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




    @PreAuthorize("hasAnyAuthority('patient','admin')")
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
    @PreAuthorize("hasAnyAuthority('patient','admin')")
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
    @PreAuthorize("hasAnyAuthority('patient','admin')")
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
    @PreAuthorize("hasAnyAuthority('patient','admin')")
    @GetMapping("/")
    public ResponseEntity<List<Patient>> get_patient_details(){

        return ResponseEntity.ok().body(patientService.get_all_patients());
    }

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/login")
    String  login_of_patient(@RequestBody login_helper l){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        l.getEmail(),
                        l.getPassword()
                )
        );
        UserDetails userDetails=doctorService.loadUserByUsername(l.getEmail());

        System.out.println(userDetails.getAuthorities());

        String  jwtToken = jwtService.generateToken(userDetails);
        return jwtToken;

    }

}