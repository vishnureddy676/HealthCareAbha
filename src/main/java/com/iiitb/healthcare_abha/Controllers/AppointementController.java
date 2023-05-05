package com.iiitb.healthcare_abha.Controllers;


import com.iiitb.healthcare_abha.Entity.Appointements;
import com.iiitb.healthcare_abha.Entity.Appointemnts_pks;
import com.iiitb.healthcare_abha.Entity.DoctorHelper;
import com.iiitb.healthcare_abha.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/appointment")
public class AppointementController {



    @Autowired
    private AppointmentService appointmentService;


    @GetMapping("/")
   public ResponseEntity<List<Appointements>> get_all_appointemnts(){
       return ResponseEntity.ok().body(appointmentService.get_all_appointemnts());


    }

    @GetMapping("/create")
    public ResponseEntity<Map<String, Object>> create_appointement(@RequestBody Appointements appointements){
        Map<String, Object> response = new HashMap<>();
        appointmentService.create_appointement(appointements);
        //if(s.equals("appointemnt created"))

            response.put("message", "Appointment created sucessfully");

        return ResponseEntity.ok().body(response);

    }

    @PutMapping("/{pid}/{visitid}")
    public  ResponseEntity<Map<String, Object>> update_appointement(@PathVariable long pid, @PathVariable long visitid,@RequestBody Appointements appointements){
        Map<String, Object> response = new HashMap<>();
        if(appointmentService.update_appointement(pid, visitid, appointements).equals("there is no appointement of type to update")){
            response.put("message","Appointment with " + pid +"not fount");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        response.put("message", "Appointment with " + pid +"updated");

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping ("/{pid}/{visitid}")
    public ResponseEntity<Map<String, Object>> delete_appointement(@PathVariable long pid, @PathVariable long visitid){
        Map<String, Object> response = new HashMap<>();

       if(appointmentService.delete_appointement(pid, visitid).equals("there is no appointement of type to delete")){
           response.put("message","Appointment with " + pid +"not fount");
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
       }
        //response.put("doctor", employee);
        response.put("message", "Appointment with " + pid +"not found");

        return ResponseEntity.ok().body(response);
    }






}
