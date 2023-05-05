
package com.iiitb.healthcare_abha.Service;


import com.iiitb.healthcare_abha.DAO.DoctorInterface;
import com.iiitb.healthcare_abha.DAO.Employeeinterface;
import com.iiitb.healthcare_abha.DAO.Frontdesk_interface;
import com.iiitb.healthcare_abha.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
/*import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;*/
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//@RequiredArgsConstructor
public class FrontDeskService {
    @Autowired
    private Frontdesk_interface frontdeskInterface;

    @Autowired
    private Employeeinterface employeeinterface;


    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

    /*@Autowired
    private  PasswordEncoder passwordEncoder;*/

    /*public DoctorService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }*/

    public String register_frontdesk(FrontDeskHelper frontDeskHelper){





        Employee employee1=employeeinterface.findbyemail(frontDeskHelper.getEmail());




        if(employee1!=null){
            return  "frontdesk already registered";

        }


        Employee employee = new Employee();
        employee.setEmployee_name(frontDeskHelper.getFrontDeskName());
        employee.setEmployee_type("frontdesk");
        employee.setGender(frontDeskHelper.getGender());

        /*employee.setPassword(new BCryptPasswordEncoder().encode(doctorHelper.getPassword()));*/
        employee.setPassword(frontDeskHelper.getPassword());
        employee.setEmail(frontDeskHelper.getEmail());
        employee.setAddress(frontDeskHelper.getAddress());
        employee.setImage(frontDeskHelper.getImage());
        employee.setDepartment(frontDeskHelper.getDepartment());
        employee.setMobile_number(frontDeskHelper.getMobile());
        System.out.println("++++++++++++++++++++");
        System.out.println("++++++++++++++++++++" +frontDeskHelper.getDOB());
        employee.setDate_of_birth(frontDeskHelper.getDOB());
        employee.setImage(frontDeskHelper.getImage());
        employee.setJoining_date(frontDeskHelper.getJoining_date());
        employee.setAbha_Id(frontDeskHelper.getAbhaID());
        employee.setBlood_group(frontDeskHelper.getBloodGroup());

       /* Doctor doctor = new Doctor();
        doctor.setSpecialization(doctorHelper.getSpecialization());
        doctor.setDoctor_shift_start(doctorHelper.getShift_start());
        doctor.setDoctor_shift_end(doctorHelper.getShift_end());
        doctor.setDetails(doctorHelper.getDetails());*/
        FrontDesk frontDesk = new FrontDesk();
        frontDesk.setFrontdesk_shift_start(frontDeskHelper.getShift_start());
        frontDesk.setFrontdesk_shift_end(frontDeskHelper.getShift_end());
        frontDesk.setDetails(frontDeskHelper.getDetails());
        frontDesk.setEmployee(employee);

        frontdeskInterface.save(frontDesk);




        return "frontdesk sucessfully registered";

    }


    public String update_frontdesk_details(String email,FrontDeskHelper frontDeskHelper){

        Employee employee1  =employeeinterface.findbyemail(email);
        System.out.println("front desk updated");
        if(employee1==null){
            return "there is no frontdesk with that emailid";
        }

        Employee employee = new Employee();
        employee.setEmployee_id(employee1.getEmployee_id());
        employee.setEmployee_name(frontDeskHelper.getFrontDeskName());
        employee.setEmployee_type("frontdesk");
        employee.setGender(frontDeskHelper.getGender());
        employee.setPassword(frontDeskHelper.getPassword());
        employee.setEmail(frontDeskHelper.getEmail());
        employee.setAddress(frontDeskHelper.getAddress());
        employee.setImage(frontDeskHelper.getImage());
        employee.setDepartment(frontDeskHelper.getDepartment());
        employee.setMobile_number(frontDeskHelper.getMobile());
        System.out.println("++++++++++++++++++++");
        System.out.println("++++++++++++++++++++" +frontDeskHelper.getDOB());
        employee.setDate_of_birth(frontDeskHelper.getDOB());
        employee.setImage(frontDeskHelper.getImage());
        employee.setJoining_date(frontDeskHelper.getJoining_date());
        employee.setAbha_Id(frontDeskHelper.getAbhaID());
        employee.setBlood_group(frontDeskHelper.getBloodGroup());

        FrontDesk frontDesk = new FrontDesk();
        frontDesk.setFront_desk_id(employee1.getEmployee_id());
        frontDesk.setFrontdesk_shift_start(frontDeskHelper.getShift_start());
        frontDesk.setFrontdesk_shift_end(frontDeskHelper.getShift_end());
        frontDesk.setDetails(frontDeskHelper.getDetails());
        frontDesk.setEmployee(employee);


        frontdeskInterface.save(frontDesk);

        return "details updated sucessfully";



    }

    public Employee delete_frontdesk_details(String email){

        Employee employee1  =employeeinterface.findbyemail(email);
        if(employee1==null){
            return null;
        }

        frontdeskInterface.deleteById(employee1.getEmployee_id());

        return employee1;


    }

    public List<FrontDeskHelper> get_frontdesk_details(){
        List<FrontDesk> frontDeskList=frontdeskInterface.findAll();
        List<FrontDeskHelper> frontDeskHelperList = new ArrayList<>();

        for(int i=0;i<frontDeskList.size();i++){
        FrontDeskHelper frontDeskHelper = new FrontDeskHelper();
            //doctorHelper.setDoctor_id(employee1.getEmployee_id());
            //frontDeskHelper.setSpecialization();
            frontDeskHelper.setShift_start(frontDeskList.get(i).getFrontdesk_shift_start());
            frontDeskHelper.setShift_end(frontDeskList.get(i).getFrontdesk_shift_end());
            frontDeskHelper.setDetails(frontDeskList.get(i).getDetails());

            frontDeskHelper.setUserType("frontdesk");
            //doctorHelper.setJoining_date(doctorList.get(i).getEmployee().getJoining_date());
            frontDeskHelper.setFrontDeskName(frontDeskList.get(i).getEmployee().getEmployee_name());
            //doctorHelper.set("doctor");
            frontDeskHelper.setGender(frontDeskList.get(i).getEmployee().getGender());
            frontDeskHelper.setPassword(frontDeskList.get(i).getEmployee().getPassword());
            frontDeskHelper.setEmail(frontDeskList.get(i).getEmployee().getEmail());
            frontDeskHelper.setAddress(frontDeskList.get(i).getEmployee().getAddress());
            frontDeskHelper.setImage(frontDeskList.get(i).getEmployee().getImage());
            frontDeskHelper.setDepartment(frontDeskList.get(i).getEmployee().getDepartment());
            frontDeskHelper.setMobile(frontDeskList.get(i).getEmployee().getMobile_number());

            frontDeskHelper.setDOB(frontDeskList.get(i).getEmployee().getDate_of_birth());
            frontDeskHelper.setImage(frontDeskList.get(i).getEmployee().getImage());
            frontDeskHelper.setJoining_date(frontDeskList.get(i).getEmployee().getJoining_date());
            frontDeskHelper.setAbhaID(frontDeskList.get(i).getEmployee().getAbha_Id());
            frontDeskHelper.setBloodGroup(frontDeskList.get(i).getEmployee().getBlood_group());
            frontDeskHelperList.add(frontDeskHelper);

        }

        return frontDeskHelperList;
    }

    public String  login_of_doctor(login_helper l){
        System.out.println(l.getEmail()+"++++++++++++++"+l.getPassword());
        Employee e= employeeinterface.findbyemailandpassword(l.getEmail(),l.getPassword());
        if(e==null){
            return "wrong credintials";
        }
        return "login sucessful";

    }


    /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee= employeeinterface.findbyemail(username);
        return employee;
        //return new org.springframework.security.core.userdetails.User(employee.getEmail(), employee.getPassword(),employee.get new ArrayList<>());
        //return null;
    }*/
}

