package com.iiitb.healthcare_abha.Controllers;

import com.iiitb.healthcare_abha.Entity.Reports;
import com.iiitb.healthcare_abha.Service.ReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportsService reportsService;


    @PostMapping("/create")
  public String create_report(@RequestBody Reports reports){

       System.out.println(reports.getDocID());
           return reportsService.create_report(reports);

       }

       @GetMapping("/images")
    public ResponseEntity<?> get_all_reports() throws IOException {


               byte[] imageData=reportsService.get_all_reports();
           return ResponseEntity.status(HttpStatus.OK)
                   .contentType(MediaType.valueOf("image/png"))
                   .body(imageData);



    }


}
