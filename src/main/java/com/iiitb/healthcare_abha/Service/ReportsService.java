package com.iiitb.healthcare_abha.Service;

import com.iiitb.healthcare_abha.Controllers.ReportController;
import com.iiitb.healthcare_abha.DAO.MedicineInterface;
import com.iiitb.healthcare_abha.DAO.ReportsInterface;
import com.iiitb.healthcare_abha.Entity.Medicine;
import com.iiitb.healthcare_abha.Entity.Prescription;
import com.iiitb.healthcare_abha.Entity.Reports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportsService {

    @Autowired
    private ReportsInterface reportsInterface;
    @Autowired
    private MedicineInterface medicineInterface;

   public String create_report(Reports reports){
       System.out.println("++++++++++++++++++++++"+ reports.getCreatedAt());
       Reports reports1=reportsInterface.save(reports);

    /*List<Medicine>medicineList= reports.getMedicines();
    List<Medicine>medicineList1= new ArrayList<>();
    for(int i=0;i<medicineList.size();i++){
        Medicine medicine = new Medicine();
        medicine.setDosage(medicineList.get(i).getDosage());
        medicine.setDuration(medicineList.get(i).getDuration());
        medicine.setMedName(medicineList.get(i).getMedName());
        medicine.setMed_id(reports1.getId());
        medicineList1.add(medicine);

    }

    medicineInterface.saveAll(medicineList1);*/


       return "reports saved";

    }

    private final String FOLDER_PATH="C:\\Users\\sivas\\OneDrive\\Documents\\Downloads\\images\\";
    public byte[] get_all_reports() throws IOException {

        String filePath=FOLDER_PATH+"medical-prescription-7611575.jpg";
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }

   /* public String get_all_report(Reports reports){

    }*/

}
