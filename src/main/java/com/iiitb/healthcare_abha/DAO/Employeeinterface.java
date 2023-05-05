package com.iiitb.healthcare_abha.DAO;


import com.iiitb.healthcare_abha.Entity.Employee;
import com.iiitb.healthcare_abha.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Employeeinterface extends JpaRepository<Employee,Long> {

    @Query("select e from Employee e where e.email = ?1")
    Employee findbyemail(String email);

    @Query("select e from Employee e where e.email = ?1 and e.password=?2")
    Employee findbyemailandpassword(String email,String password);




}
