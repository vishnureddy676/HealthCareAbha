package com.iiitb.healthcare_abha.DAO;

import com.iiitb.healthcare_abha.Entity.Admin;
import com.iiitb.healthcare_abha.Entity.Doctor;
import com.iiitb.healthcare_abha.Entity.Employee;
import com.iiitb.healthcare_abha.Entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminInterface extends JpaRepository<Admin,Long> {

    @Query("select a from Admin a where a.admin_id = ?1")
    Admin findAllByAdmin_id(Long admin_id);


}
