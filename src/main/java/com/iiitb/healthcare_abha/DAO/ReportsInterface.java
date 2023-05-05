package com.iiitb.healthcare_abha.DAO;


import com.iiitb.healthcare_abha.Entity.Reports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportsInterface extends JpaRepository<Reports,Long> {



}
