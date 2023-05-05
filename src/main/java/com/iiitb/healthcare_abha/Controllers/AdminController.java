
package com.iiitb.healthcare_abha.Controllers;

import com.iiitb.healthcare_abha.DAO.Employeeinterface;
import com.iiitb.healthcare_abha.Entity.*;
//import com.iiitb.healthcare_abha.Service;
//import com.iiitb.healthcare_abha.JWT.JwtService;
import com.iiitb.healthcare_abha.Service.AdminService;
import com.iiitb.healthcare_abha.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
/*@Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;*/


    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register_admin(@RequestBody AdminHelper adminHelper){

        System.out.println("++++++++++++++++++++" +adminHelper.getDOB());
        Map<String, Object> response = new HashMap<>();




        if (adminService.register_admin(adminHelper).equals("admin already registered")){
            response.put("message", "admin already registered");

            return ResponseEntity.ok().body(response);

        }
        response.put("admin", adminHelper);
        response.put("message", "registered");

        return ResponseEntity.ok().body(response);

    }

    @PutMapping("/{email}")
    public ResponseEntity<Map<String, Object>> update_admin_details(@PathVariable String email, @RequestBody AdminHelper adminHelper){

        Map<String, Object> response = new HashMap<>();



        if(adminService.update_admin_details(email,adminHelper).equals("there is no admin with that emailid")){
            response.put("message", "there is no admin with that email id");

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        response.put("admin", adminHelper);
        response.put("message", "sucessfully updated");

        return ResponseEntity.ok().body(response);

    }

    @DeleteMapping ("/{email}")
    public ResponseEntity<Map<String, Object>> delete_admin_details(@PathVariable String email){
        Map<String, Object> response = new HashMap<>();
        Employee employee=adminService.delete_admin_details(email);

        if(employee==null){
            response.put("message", "there is no admin with that email id");

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        response.put("admin", employee);
        response.put("message", "sucessfully deleted");

        return ResponseEntity.ok().body(response);
    }

    @GetMapping ("/")
    public List<AdminHelper> get_admin_details(){







        return adminService.get_admin_details();

    }

    /*@Autowired
    private Employeeinterface employeeinterface;
    @PostMapping("/login")
    String  login_of_admin(@RequestBody login_helper l){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        l.getEmail(),
                        l.getPassword()
                )
        );
        Employee employee = employeeinterface.findbyemail(l.getEmail());

        if(employee==null) {
            return  "please passs correct email id";
        }
        String  jwtToken = jwtService.generateToken(employee);
        return jwtToken;

    }

*/






}

