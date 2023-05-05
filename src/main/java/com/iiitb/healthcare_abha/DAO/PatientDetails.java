package com.iiitb.healthcare_abha.DAO;


import com.iiitb.healthcare_abha.Entity.Employee;
import com.iiitb.healthcare_abha.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDetails extends JpaRepository<Patient,Long> {


 @Query("select p from Patient p where p.patientID = ?1")
 Patient find_patient_id(Long patient_id);

 @Query("select p from Patient p where p.abhaID = ?1")
 Patient find_abha_id(String abha_id);

 @Query("select p from Patient p where p.email = ?1")
 Patient find_email_id(String email);

 @Query("select p from Patient p where p.mobile = ?1")
 Patient findbymobile(long mobile);



Patient deleteById(long patientID);
 @Query("select e from Patient e where e.email = ?1 and e.password=?2")
 Patient findbyemailandpassword(String email, String password);


}
