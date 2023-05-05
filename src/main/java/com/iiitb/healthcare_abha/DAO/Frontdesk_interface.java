package com.iiitb.healthcare_abha.DAO;

import com.iiitb.healthcare_abha.Entity.Admin;
import com.iiitb.healthcare_abha.Entity.Doctor;
import com.iiitb.healthcare_abha.Entity.FrontDesk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Frontdesk_interface extends JpaRepository<FrontDesk,Long> {
    @Override
    List<FrontDesk> findAll();

    //Doctor findById(long doctor_id);
   /* @Query("select d from FrontDesk d where d.front_desk_id = ?1")
    FrontDesk findAllByDoctor_id(Long patient_id);*/



    /*@Query("DELETE FROM Doctor WHERE doctor_id = ?1")*/
    FrontDesk deleteById(long id);
}
