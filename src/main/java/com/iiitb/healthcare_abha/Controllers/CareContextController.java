/*
package com.iiitb.healthcare_abha.Controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iiitb.healthcare_abha.CareContext.CareContext_helper;
import com.iiitb.healthcare_abha.CareContext.Cc2;
import com.iiitb.healthcare_abha.CareContext.Link;
import com.iiitb.healthcare_abha.CareContext.Patient_p;
import com.iiitb.healthcare_abha.Entity.CareContext;
import com.iiitb.healthcare_abha.NgrokJasonHelper.Root2;
import com.iiitb.healthcare_abha.Service.CareContextService;
//import com.iiitb.healthcare_abha.Service.PatientService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
*/
/**//*

@RestController
@CrossOrigin(maxAge = 3600)
public class CareContextController {

    @Autowired
    private PatientController patientController;

    @Autowired
    private  LoginController loginController;
    private long patient_id;

    @Autowired
    private PatientService patientService;
    @Autowired
    private CareContextService careContextService;


    @PostMapping("/carecontext")
    public String care_Context(@RequestBody CC_Abha_id ccAbhaId) throws JsonProcessingException {
        System.out.println("++++++++++carecontextcalled++++++++++");
    System.out.println(ccAbhaId.getAbha());
     Long id =patientService.given_abha_id(ccAbhaId.getAbha());

     String serviceAuthToken= careContextService.get_auth_token(id);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.add("X-CM-ID","sbx");
        headers.add("Authorization", "Bearer " + loginController.ngrok_main());

        CareContext_helper careContextHelper = new CareContext_helper();
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        careContextHelper.setRequestId(randomUUIDString);
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ss.SSSSSS");
        df.setTimeZone(tz);
        String nowasISO = df.format(new Date());
        System.out.println(nowasISO);
        careContextHelper.setTimestamp(nowasISO);
        Link link = new Link();
        link.setAccessToken(serviceAuthToken);
        Patient_p patient_p = new Patient_p();
        patient_p.setReferenceNumber("PUID-"+String.valueOf(id));
        System.out.println("PUID-"+String.valueOf(id));
        patient_p.setDisplay(ccAbhaId.getDisplay1());
        ArrayList<Cc2> arrayList= new ArrayList<Cc2>();
        Cc2 cc2 = new Cc2();
        cc2.setDisplay(ccAbhaId.getDisplay2());
        cc2.setReferenceNumber(randomUUIDString);
        arrayList.add(cc2);
        patient_p.setCareContexts(arrayList);
        link.setPatient(patient_p);
        careContextHelper.setLink(link);

        String curr_body=new ObjectMapper().writeValueAsString(careContextHelper);
        HttpEntity<String> httpEntity = new HttpEntity<>(curr_body, headers);

        ResponseEntity<Object> objectResponseEntity=restTemplate.exchange("https://dev.abdm.gov.in/gateway/v0.5/links/link/add-contexts", HttpMethod.POST, httpEntity,Object.class);
        System.out.println(objectResponseEntity.getStatusCode());
        //transactionId=root2.getBody().getAuth().getTransactionId();
        //System.out.println(result);
        //root2

        return "200 ok";



    }









}

@Data
 class CC_Abha_id{
    public String abha;
    String display1;
    String display2;
    String message;



}
*/
