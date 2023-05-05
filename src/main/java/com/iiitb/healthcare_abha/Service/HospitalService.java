package com.iiitb.healthcare_abha.Service;

import com.iiitb.healthcare_abha.DAO.*;
import com.iiitb.healthcare_abha.Entity.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {

    @Autowired
    private PatientDetails patientDetails;
    @Autowired
    private DoctorInterface doctorInterface;
    @Autowired
    private AdminInterface adminInterface;
    @Autowired
    private Frontdesk_interface frontdeskInterface;
    @Autowired
    private Patient_Records_Details patient_records_details;
    @Autowired

    private AppointmentsInterface appointmentsInterface;



   public Hospital get_all_info(){


       Hospital hospital = new Hospital();
       hospital.setAppointmentNumbers(appointmentsInterface.findAll().size());
       hospital.setDocNumbers(doctorInterface.findAll().size());
       hospital.setPatientNumbers(patientDetails.findAll().size());
       hospital.setFrontDeskNumbers(frontdeskInterface.findAll().size());
       hospital.setReportsNumbers(patient_records_details.findAll().size());
       return hospital;




   }


}
