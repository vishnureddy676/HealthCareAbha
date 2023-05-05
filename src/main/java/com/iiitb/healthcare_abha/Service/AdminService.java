package com.iiitb.healthcare_abha.Service;

import com.iiitb.healthcare_abha.DAO.AdminInterface;
import com.iiitb.healthcare_abha.DAO.Employeeinterface;
import com.iiitb.healthcare_abha.DAO.Frontdesk_interface;
import com.iiitb.healthcare_abha.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;*/
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService  {

    @Autowired
    private Employeeinterface employeeinterface;

    @Autowired
    private AdminInterface adminInterface;

    public String register_admin(AdminHelper adminHelper){





        Employee employee1=employeeinterface.findbyemail(adminHelper.getEmail());




        if(employee1!=null){
            return  "admin already registered";

        }


        Employee employee = new Employee();
        employee.setEmployee_name(adminHelper.getAdminName());
        employee.setEmployee_type("admin");
        employee.setGender(adminHelper.getGender());
        employee.setPassword((adminHelper.getPassword()));
        System.out.println();
        employee.setEmail(adminHelper.getEmail());
        employee.setAddress(adminHelper.getAddress());
        employee.setImage(adminHelper.getImage());
        //employee.setDepartment(adminHelper.getD());
        employee.setMobile_number(adminHelper.getMobile());
        System.out.println("++++++++++++++++++++");
        System.out.println("++++++++++++++++++++" +adminHelper.getDOB());
        employee.setDate_of_birth(adminHelper.getDOB());
        employee.setImage(adminHelper.getImage());
        employee.setJoining_date(adminHelper.getJoiningDate());
        employee.setAbha_Id(adminHelper.getAbhaID());
        employee.setBlood_group(adminHelper.getBloodGroup());

        Admin admin = new Admin();
        admin.setEducation(adminHelper.getEducation());

        admin.setEmployee(employee);

        adminInterface.save(admin);




        return "admin sucessfully registered";

    }


    public String update_admin_details(String email,AdminHelper adminHelper){

        Employee employee1  =employeeinterface.findbyemail(email);
        if(employee1==null){
            return "there is no admin with that emailid";
        }
        Employee employee = new Employee();
        employee.setEmployee_id(employee1.getEmployee_id());
        employee.setEmployee_name(adminHelper.getAdminName());
        employee.setEmployee_type("admin");
        employee.setGender(adminHelper.getGender());
        employee.setPassword(adminHelper.getPassword());
        employee.setEmail(adminHelper.getEmail());
        employee.setAddress(adminHelper.getAddress());
        employee.setImage(adminHelper.getImage());
        //employee.setDepartment(adminHelper.getD());
        employee.setMobile_number(adminHelper.getMobile());
        System.out.println("++++++++++++++++++++");
        System.out.println("++++++++++++++++++++" +adminHelper.getDOB());
        employee.setDate_of_birth(adminHelper.getDOB());
        employee.setImage(adminHelper.getImage());
        employee.setJoining_date(adminHelper.getJoiningDate());
        employee.setAbha_Id(adminHelper.getAbhaID());
        employee.setBlood_group(adminHelper.getBloodGroup());

        Admin admin = new Admin();
        admin.setEducation(adminHelper.getEducation());

        admin.setEmployee(employee);



        admin.setAdmin_id(employee1.getEmployee_id());


        adminInterface.save(admin);

        return "details updated sucessfully";



    }

    public Employee delete_admin_details(String email){

        Employee employee1  =employeeinterface.findbyemail(email);
        if(employee1==null){
            return null;
        }

        adminInterface.deleteById(employee1.getEmployee_id());

        return employee1;


    }

    public List<AdminHelper> get_admin_details(){
        List<Admin> adminList=adminInterface.findAll();
        List<AdminHelper> adminHelperList = new ArrayList<>();

        for(int i=0;i< adminList.size();i++){
            AdminHelper adminHelper= new AdminHelper();
            //doctorHelper.setDoctor_id(employee1.getEmployee_id());
            adminHelper.setEducation(adminList.get(i).getEducation());

            adminHelper.setUserType("admin");
            adminHelper.setJoiningDate(adminList.get(i).getEmployee().getJoining_date());
            adminHelper.setAdminName(adminList.get(i).getEmployee().getEmployee_name());
            //adminHelper.set("doctor");
            adminHelper.setGender(adminList.get(i).getEmployee().getGender());
            adminHelper.setPassword(adminList.get(i).getEmployee().getPassword());
            adminHelper.setEmail(adminList.get(i).getEmployee().getEmail());
            adminHelper.setAddress(adminList.get(i).getEmployee().getAddress());
            adminHelper.setImage(adminList.get(i).getEmployee().getImage());
            //adminHelper.setDepartment(adminList.get(i).getEmployee().getDepartment());
            adminHelper.setMobile(adminList.get(i).getEmployee().getMobile_number());

            adminHelper.setDOB(adminList.get(i).getEmployee().getDate_of_birth());
            adminHelper.setImage(adminList.get(i).getEmployee().getImage());
            //adminHelper.setJoining_date(adminList.get(i).getEmployee().getJoining_date());
            adminHelper.setAbhaID(adminList.get(i).getEmployee().getAbha_Id());
            adminHelper.setBloodGroup(adminList.get(i).getEmployee().getBlood_group());
            adminHelperList.add(adminHelper);

        }

        return adminHelperList;
    }

    public String  login_of_admin(login_helper l){
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
        return new org.springframework.security.core.userdetails.User(employee.getEmail(), employee.getPassword(), new ArrayList<>());
        //return null;
    }*/



}