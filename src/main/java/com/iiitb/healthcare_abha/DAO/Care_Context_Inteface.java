package com.iiitb.healthcare_abha.DAO;

import com.iiitb.healthcare_abha.Entity.CareContext;
import com.iiitb.healthcare_abha.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Care_Context_Inteface  extends JpaRepository<CareContext,Long> {



    @Query("select c from CareContext c where c.patient_id= ?1")
    CareContext find_auth_token(Long patient_id);

}
