package com.iiitb.healthcare_abha.Controllers;

//import com.iiitb.healthcare_abha.Service;
import com.iiitb.healthcare_abha.DAO.Employeeinterface;
import com.iiitb.healthcare_abha.Entity.DoctorHelper;
import com.iiitb.healthcare_abha.Entity.Employee;
import com.iiitb.healthcare_abha.Entity.FrontDeskHelper;
import com.iiitb.healthcare_abha.Entity.login_helper;

//import com.iiitb.healthcare_abha.JWT.JwtService;
import com.iiitb.healthcare_abha.JWT.JwtService;
import com.iiitb.healthcare_abha.Service.DoctorService;
import com.iiitb.healthcare_abha.Service.FrontDeskService;
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
@RequestMapping("/frontdesk")
public class FrontDeskController {


    @Autowired
    private FrontDeskService frontDeskService;

    //@Autowired
    //private JwtService jwtService;

    //@Autowired
    //private AuthenticationManager authenticationManager;
    @PreAuthorize("hasAnyAuthority('frontdesk','admin')")
    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>>  register_frontdesk(@RequestBody FrontDeskHelper frontDeskHelper) {

        //System.out.println("++++++++++++++++++++" + doctorHelper.getDOB());
        Map<String, Object> response = new HashMap<>();

        if(frontDeskService.register_frontdesk(frontDeskHelper).equals("frontdesk already registered")){
            response.put("message", "frontdesk already registered");

            return ResponseEntity.ok().body(response);
        }

        response.put("frontdesk", frontDeskHelper);
        response.put("message", "registered");

        return ResponseEntity.ok().body(response);

    }
    @PreAuthorize("hasAnyAuthority('frontdesk','admin')")
    @PutMapping("/{email}")
    public ResponseEntity<Map<String, Object>> update_frontdesk_details(@PathVariable String email, @RequestBody FrontDeskHelper frontDeskHelper) {
        Map<String, Object> response = new HashMap<>();


        if(frontDeskService.update_frontdesk_details(email, frontDeskHelper).equals("there is no frontdesk with that emailid")){
            response.put("message", "there is no frontdesk with that email id");

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        response.put("frontdesk", frontDeskHelper);
        response.put("message", "sucessfully updated");

        return ResponseEntity.ok().body(response);
        //return

    }
    @PreAuthorize("hasAnyAuthority('frontdesk','admin')")
    @DeleteMapping("/{email}")
    public ResponseEntity<Map<String, Object>> delete_frontdesk_details(@PathVariable String email) {

        Map<String, Object> response = new HashMap<>();
        Employee employee= frontDeskService.delete_frontdesk_details(email);

        if(employee==null){
            response.put("message", "there is no frontdesk with that email id");

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        response.put("frontdesk", employee);
        response.put("message", "sucessfully deleted");

        return ResponseEntity.ok().body(response);

    }
    @PreAuthorize("hasAnyAuthority('frontdesk','admin')")
    //@PreAuthorize("hasAuthority('doctor')")
    @GetMapping("/")
    public ResponseEntity<List<FrontDeskHelper>> get_frontdesk_details() {


        return ResponseEntity.ok().body(frontDeskService.get_frontdesk_details());

    }

    @Autowired
    private Employeeinterface employeeinterface;

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping("/login")
    String  login_of_frontdesk(@RequestBody login_helper l){
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

}










