package com.iiitb.healthcare_abha.Controllers;

import com.iiitb.healthcare_abha.Entity.Hospital;
import com.iiitb.healthcare_abha.Service.AdminService;
import com.iiitb.healthcare_abha.Service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/hospital")
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    @GetMapping("/")
   public  Hospital get_all_details(){

     return hospitalService.get_all_info();

    }





}
