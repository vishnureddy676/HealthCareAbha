package com.iiitb.healthcare_abha.DAO;

import com.iiitb.healthcare_abha.Entity.Doctor;
import com.iiitb.healthcare_abha.Entity.Employee;
import com.iiitb.healthcare_abha.Entity.Patient_Records;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorInterface extends JpaRepository<Doctor,Long> {

    @Override
    List<Doctor> findAll();

    //Doctor findById(long doctor_id);
    @Query("select d from Doctor d where d.doctor_id = ?1")
    Doctor findAllByDoctor_id(Long patient_id);



    /*@Query("DELETE FROM Doctor WHERE doctor_id = ?1")*/
    Doctor deleteById(long id);



}

