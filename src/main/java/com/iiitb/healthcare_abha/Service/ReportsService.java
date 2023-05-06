package com.iiitb.healthcare_abha.Service;

import com.iiitb.healthcare_abha.Controllers.ReportController;
import com.iiitb.healthcare_abha.DAO.MedicineInterface;
import com.iiitb.healthcare_abha.DAO.ReportsInterface;
import com.iiitb.healthcare_abha.Entity.Medicine;
import com.iiitb.healthcare_abha.Entity.Prescription;
import com.iiitb.healthcare_abha.Entity.Reports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class ReportsService {

    @Autowired
    private ReportsInterface reportsInterface;
    @Autowired
    private MedicineInterface medicineInterface;

   public String create_report(Reports reports){
       System.out.println("++++++++++++++++++++++"+ reports.getCreatedAt());
     //reports.getMedicines()
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
    public List<byte[]> getAllFiles(ArrayList<String> files) throws IOException {
      List<byte[]> images= new ArrayList<>();
        for (int i = 0; i<files.size(); i++) {
            String filePath = FOLDER_PATH + files.get(i);
            byte[] image = Files.readAllBytes(new File(filePath).toPath());
            System.out.println(image);
            String base64Image = Base64.getEncoder().encodeToString(image);
            System.out.println(base64Image);
            //images.add(i,image);
            //ByteArrayResource resource1 = new ByteArrayResource(image);
            images.add(image);
        }


        return images;
    }

   /* public String get_all_report(Reports reports){

    }*/

    public Reports updateReport(Reports reports,long reportId){

       Reports reports1= reportsInterface.find_report_id(reportId);

        reports.setId(reports1.getId());
        reportsInterface.save(reports);

        return reports;

    }

    public Reports deleteReport(long reportId){

        Reports reports= reportsInterface.deleteById(reportId);



        return reports;

    }
    public List<Reports> getAllReports(){

        List<Reports>reports = reportsInterface.findAll();
        for (int i = 0; i < reports.size(); i++) {
            System.out.println(reports.get(i));
        }


        return reports;

    }





}
