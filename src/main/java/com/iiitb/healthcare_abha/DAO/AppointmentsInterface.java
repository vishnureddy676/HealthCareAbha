package com.iiitb.healthcare_abha.DAO;

import com.iiitb.healthcare_abha.Entity.Appointements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AppointmentsInterface extends JpaRepository<Appointements,Long> {



    @Query("select p  from Appointements p where p.patientID = ?1 and p.visitId=?2")
    Appointements findByIdAndStatus(Long id1,Long id2);
    //@Query(value = "delete from Appointements p WHERE p.patientID = ?1 and p.visitId=?2",nativeQuery = true)
    void deleteById(Long id1);

}
