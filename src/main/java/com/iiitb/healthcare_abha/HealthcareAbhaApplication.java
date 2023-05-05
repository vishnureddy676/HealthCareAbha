package com.iiitb.healthcare_abha;

//import com.iiitb.healthcare_abha.Controllers.PatientController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HealthcareAbhaApplication  {

    public static void main(String[] args) {

        SpringApplication.run(HealthcareAbhaApplication.class, args);
        //PatientController patientController = new PatientController();
        //patientController.getPatientDetails();
    }

    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

    /*@Override
    public void run(String... args) throws  Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("secretpassword"));
    }*/
}



