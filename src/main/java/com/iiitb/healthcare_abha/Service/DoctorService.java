
package com.iiitb.healthcare_abha.Service;


import com.iiitb.healthcare_abha.DAO.DoctorInterface;
import com.iiitb.healthcare_abha.DAO.Employeeinterface;
import com.iiitb.healthcare_abha.Entity.Doctor;
import com.iiitb.healthcare_abha.Entity.DoctorHelper;
import com.iiitb.healthcare_abha.Entity.Employee;
import com.iiitb.healthcare_abha.Entity.login_helper;
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
public class DoctorService {
    @Autowired
    private DoctorInterface doctorInterface;

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

    public String register_doctor(DoctorHelper doctorHelper){





  Employee employee1=employeeinterface.findbyemail(doctorHelper.getEmail());




  if(employee1!=null){
     return  "doctor already registered";

  }


      Employee employee = new Employee();
      employee.setEmployee_name(doctorHelper.getDocName());
      employee.setEmployee_type("doctor");
      employee.setGender(doctorHelper.getGender());

      /*employee.setPassword(new BCryptPasswordEncoder().encode(doctorHelper.getPassword()));*/
        employee.setPassword(doctorHelper.getPassword());
      employee.setEmail(doctorHelper.getEmail());
      employee.setAddress(doctorHelper.getAddress());
      employee.setImage(doctorHelper.getImage());
      employee.setDepartment(doctorHelper.getDepartment());
      employee.setMobile_number(doctorHelper.getMobile());
        System.out.println("++++++++++++++++++++");
      System.out.println("++++++++++++++++++++" +doctorHelper.getDOB());
      employee.setDate_of_birth(doctorHelper.getDOB());
      employee.setImage(doctorHelper.getImage());
      employee.setJoining_date(doctorHelper.getJoining_date());
      employee.setAbha_Id(doctorHelper.getAbhaID());
      employee.setBlood_group(doctorHelper.getBloodGroup());

      Doctor doctor = new Doctor();
      doctor.setSpecialization(doctorHelper.getSpecialization());
      doctor.setDoctor_shift_start(doctorHelper.getShift_start());
      doctor.setDoctor_shift_end(doctorHelper.getShift_end());
      doctor.setDetails(doctorHelper.getDetails());
      doctor.setEmployee(employee);

      doctorInterface.save(doctor);




        return "doctor sucessfully registered";

    }


    public String update_Doctor_details(String email,DoctorHelper doctorHelper){

     Employee employee1  =employeeinterface.findbyemail(email);
      if(employee1==null){
          return "there is no doctor with that emailid";
      }

        Employee employee = new Employee();
        employee.setEmployee_id(employee1.getEmployee_id());
        employee.setEmployee_name(doctorHelper.getDocName());
        employee.setEmployee_type("doctor");
        employee.setGender(doctorHelper.getGender());
        employee.setPassword(doctorHelper.getPassword());
        employee.setEmail(doctorHelper.getEmail());
        employee.setAddress(doctorHelper.getAddress());
        employee.setImage(doctorHelper.getImage());
        employee.setDepartment(doctorHelper.getDepartment());
        employee.setMobile_number(doctorHelper.getMobile());
        System.out.println("++++++++++++++++++++");
        System.out.println("++++++++++++++++++++" +doctorHelper.getDOB());
        employee.setDate_of_birth(doctorHelper.getDOB());
        employee.setImage(doctorHelper.getImage());
        employee.setJoining_date(doctorHelper.getJoining_date());
        employee.setAbha_Id(doctorHelper.getAbhaID());
        employee.setBlood_group(doctorHelper.getBloodGroup());

        Doctor doctor = new Doctor();
        doctor.setDoctor_id(employee1.getEmployee_id());
        doctor.setSpecialization(doctorHelper.getSpecialization());
        doctor.setDoctor_shift_start(doctorHelper.getShift_start());
        doctor.setDoctor_shift_end(doctorHelper.getShift_end());
        doctor.setDetails(doctorHelper.getDetails());
        doctor.setEmployee(employee);

        doctorInterface.save(doctor);

        return "details updated sucessfully";



    }

    public Employee delete_doctor_details(String email){

        Employee employee1  =employeeinterface.findbyemail(email);
        if(employee1==null){
            return null;
        }

        doctorInterface.deleteById(employee1.getEmployee_id());

        return employee1;


    }

    public List<DoctorHelper> get_doctor_details(){
        List<Doctor> doctorList=doctorInterface.findAll();
        List<DoctorHelper> doctorHelperList = new ArrayList<>();

        for(int i=0;i< doctorList.size();i++){
            DoctorHelper doctorHelper= new DoctorHelper();
            //doctorHelper.setDoctor_id(employee1.getEmployee_id());
            doctorHelper.setSpecialization(doctorList.get(i).getSpecialization());
            doctorHelper.setShift_start(doctorList.get(i).getDoctor_shift_start());
            doctorHelper.setShift_end(doctorList.get(i).getDoctor_shift_end());
            doctorHelper.setDetails(doctorList.get(i).getDetails());

           doctorHelper.setUserType("doctor");
            //doctorHelper.setJoining_date(doctorList.get(i).getEmployee().getJoining_date());
            doctorHelper.setDocName(doctorList.get(i).getEmployee().getEmployee_name());
            //doctorHelper.set("doctor");
            doctorHelper.setGender(doctorList.get(i).getEmployee().getGender());
            doctorHelper.setPassword(doctorList.get(i).getEmployee().getPassword());
            doctorHelper.setEmail(doctorList.get(i).getEmployee().getEmail());
            doctorHelper.setAddress(doctorList.get(i).getEmployee().getAddress());
            doctorHelper.setImage(doctorList.get(i).getEmployee().getImage());
            doctorHelper.setDepartment(doctorList.get(i).getEmployee().getDepartment());
            doctorHelper.setMobile(doctorList.get(i).getEmployee().getMobile_number());

            doctorHelper.setDOB(doctorList.get(i).getEmployee().getDate_of_birth());
            doctorHelper.setImage(doctorList.get(i).getEmployee().getImage());
            doctorHelper.setJoining_date(doctorList.get(i).getEmployee().getJoining_date());
            doctorHelper.setAbhaID(doctorList.get(i).getEmployee().getAbha_Id());
            doctorHelper.setBloodGroup(doctorList.get(i).getEmployee().getBlood_group());
            doctorHelperList.add(doctorHelper);

        }

       return doctorHelperList;
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

