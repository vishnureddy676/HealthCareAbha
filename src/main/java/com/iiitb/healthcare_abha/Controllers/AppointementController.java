package com.iiitb.healthcare_abha.Controllers;


import com.iiitb.healthcare_abha.Entity.Appointements;
import com.iiitb.healthcare_abha.Entity.Appointemnts_pks;
import com.iiitb.healthcare_abha.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointementController {



    @Autowired
    private AppointmentService appointmentService;


    @GetMapping("/")
   public List<Appointements> get_all_appointemnts(){
      return  appointmentService.get_all_appointemnts();


    }

    @GetMapping("/create")
    public String create_appointement(@RequestBody Appointements appointements){

        return  appointmentService.create_appointement(appointements);


    }

    @PutMapping("/{pid}/{visitid}")
    public String update_appointement(@PathVariable long pid, @PathVariable long visitid,@RequestBody Appointements appointements){
        return appointmentService.update_appointement(pid, visitid, appointements);
    }

    @DeleteMapping ("/{pid}/{visitid}")
    public String delete_appointement(@PathVariable long pid, @PathVariable long visitid){
        return appointmentService.delete_appointement(pid, visitid);
    }






}
