package com.iiitb.healthcare_abha.DAO;


import com.iiitb.healthcare_abha.Entity.Patient;
import com.iiitb.healthcare_abha.Entity.Reports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportsInterface extends JpaRepository<Reports,Long> {
    @Query("select r from Reports r where r.id = ?1")
    Reports find_report_id(Long reportId);

    Reports deleteById(long id);

}
