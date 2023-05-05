package com.iiitb.healthcare_abha.DAO;

import com.iiitb.healthcare_abha.Entity.Doctor;
import com.iiitb.healthcare_abha.Entity.Patient;
import com.iiitb.healthcare_abha.Entity.Patient_visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientVisitInterface extends JpaRepository<Patient_visit,Long> {

    @Query("select d from  Patient_visit d where d.patientID = ?1")
    List<Patient_visit> findAllByPatient_id(Long patientID);







}
