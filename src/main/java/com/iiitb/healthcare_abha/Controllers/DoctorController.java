package com.iiitb.healthcare_abha.Controllers;

//import com.iiitb.healthcare_abha.Service;
import com.iiitb.healthcare_abha.DAO.Employeeinterface;
import com.iiitb.healthcare_abha.Entity.DoctorHelper;
import com.iiitb.healthcare_abha.Entity.Employee;
import com.iiitb.healthcare_abha.Entity.login_helper;

//import com.iiitb.healthcare_abha.JWT.JwtService;
import com.iiitb.healthcare_abha.JWT.JwtService;
import com.iiitb.healthcare_abha.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/*import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;*/
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/doctor")
public class DoctorController {


    @Autowired
    private DoctorService doctorService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @PreAuthorize("hasAnyAuthority('doctor','admin')")
    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>>  register_doctor(@RequestBody DoctorHelper doctorHelper) {

        System.out.println("++++++++++++++++++++" + doctorHelper.getDOB());
        Map<String, Object> response = new HashMap<>();

        if(doctorService.register_doctor(doctorHelper).equals("doctor already registered")){
            response.put("message", "doctor already registered");

            return ResponseEntity.ok().body(response);
        }

        response.put("doctor", doctorHelper);
        response.put("message", "registered");

        return ResponseEntity.ok().body(response);

    }
    @PreAuthorize("hasAnyAuthority('doctor','admin')")
    @PutMapping("/{email}")
    public ResponseEntity<Map<String, Object>> update_doctor_details(@PathVariable String email, @RequestBody DoctorHelper doctorHelper) {
        Map<String, Object> response = new HashMap<>();


         if(doctorService.update_Doctor_details(email, doctorHelper).equals("there is no doctor with that emailid")){
             response.put("message", "there is no doctor with that email id");

             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
         }
        response.put("doctor", doctorHelper);
        response.put("message", "sucessfully updated");

        return ResponseEntity.ok().body(response);
         //return

    }
    @PreAuthorize("hasAnyAuthority('doctor','admin')")
    @DeleteMapping("/{email}")
    public ResponseEntity<Map<String, Object>> delete_doctor_details(@PathVariable String email) {

        Map<String, Object> response = new HashMap<>();
       Employee employee= doctorService.delete_doctor_details(email);

        if(employee==null){
            response.put("message", "there is no doctor with that email id");

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        response.put("doctor", employee);
        response.put("message", "sucessfully deleted");

        return ResponseEntity.ok().body(response);

    }

    @PreAuthorize("hasAnyAuthority('doctor','admin')")
    @GetMapping("/")
    public ResponseEntity<List<DoctorHelper>> get_doctor_details() {


        return ResponseEntity.ok().body(doctorService.get_doctor_details());

    }

    @Autowired
    private Employeeinterface employeeinterface;

    @PostMapping("/login")
    String login_of_doctor(@RequestBody login_helper l) throws Exception {





            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            l.getEmail(),
                            l.getPassword()
                    )
            );
            UserDetails userDetails=doctorService.loadUserByUsername( l.getEmail());

            System.out.println(userDetails.getAuthorities());

            String  jwtToken = jwtService.generateToken(userDetails);
            return jwtToken;
        }



     /* var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);*/

       /* String jwtToken = jwtService.generateToken(l);
        return jwtToken;*/


}










