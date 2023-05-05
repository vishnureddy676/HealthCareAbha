package com.iiitb.healthcare_abha.DAO;

import com.iiitb.healthcare_abha.Entity.Admin;
import com.iiitb.healthcare_abha.Entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineInterface extends JpaRepository<Medicine,Long> {
}
