package com.iiitb.healthcare_abha.DAO;

import com.iiitb.healthcare_abha.Entity.Patient;
import com.iiitb.healthcare_abha.Entity.Patient_Records;
import com.iiitb.healthcare_abha.Entity.Reports;
import com.iiitb.healthcare_abha.Entity.patient_record_pks;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Patient_Records_Details extends JpaRepository<Reports, Long> {

   /* @Query("select count(*) from Patient_Records p where p.id.patient_id = ?1")
    long countByIdAndStatus(Long id);


    @Query("select p from Patient_Records p where p.id.patient_id = ?1")
    List<Patient_Records> findAllById_Patient_id(Long patient_id);

    @Query("select p from Patient_Records p")
    List<Patient_Records> findallpatientrecords();*/

}
