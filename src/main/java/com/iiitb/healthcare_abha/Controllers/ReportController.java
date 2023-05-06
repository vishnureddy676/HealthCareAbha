package com.iiitb.healthcare_abha.Controllers;

import com.iiitb.healthcare_abha.Entity.DoctorHelper;
import com.iiitb.healthcare_abha.Entity.Reports;
import com.iiitb.healthcare_abha.Service.ReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportsService reportsService;


    @PostMapping("/create")
  public ResponseEntity<Map<String, Object>> create_report(@RequestBody Reports reports){
        Map<String, Object> response = new HashMap<>();
       //System.out.println(reports.getDocID());
       if(reportsService.create_report(reports).equals("reports saved")){
           response.put("message","report created sucessfully");
           return ResponseEntity.ok().body(response);
       }

        response.put("message","report created failed");
        return ResponseEntity.ok().body(response);


       }

       @GetMapping("/files")
    public  ResponseEntity<List<byte[]>> getAllFiles(@RequestBody ArrayList<String> files) throws IOException {
           List<byte[]> images = reportsService.getAllFiles(files);





           //return new ResponseEntity<>(body, headers, HttpStatus.OK);*/
           return ResponseEntity.status(HttpStatus.OK)
                   .contentType(MediaType.APPLICATION_JSON)
                   .body(images);




    }


    @PutMapping("/{reportId}")
    public ResponseEntity<Map<String, Object>> updateReport(@RequestBody Reports reports ,@PathVariable long reportId){

       Reports reports1= reportsService.updateReport(reports,reportId);
        Map<String, Object> response = new HashMap<>();
        response.put("mesaage","reports updated sucessfully");
        response.put("reports",reports1);
        return ResponseEntity.ok().body(response);
    }


    @DeleteMapping ("/{reportId}")
    public ResponseEntity<Map<String, Object>> deleteReport(@PathVariable long reportId){

        Reports reports1= reportsService.deleteReport(reportId);
        Map<String, Object> response = new HashMap<>();
        response.put("mesaage","reports deleted  sucessfully");
        response.put("reports",reports1);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/")
    public ResponseEntity<List<Reports>> getAllReports() {


        return ResponseEntity.ok().body(reportsService.getAllReports());

    }






}
