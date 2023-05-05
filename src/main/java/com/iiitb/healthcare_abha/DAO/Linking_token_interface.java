package com.iiitb.healthcare_abha.DAO;

import com.iiitb.healthcare_abha.Entity.FrontDesk;
import com.iiitb.healthcare_abha.Entity.LinkingToken;
import com.iiitb.healthcare_abha.Entity.linking_token_pks;
import com.iiitb.healthcare_abha.Entity.patient_record_pks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface Linking_token_interface extends JpaRepository<LinkingToken, linking_token_pks> {


    @Query("select count(*) from LinkingToken l where l.patientID = ?1")
    long countByIdAndStatus(Long id);

    @Query("select l from LinkingToken l where l.patientID = ?1")
    LinkingToken findLinkingTokenbyId(long id);

}

