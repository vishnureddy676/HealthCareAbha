package com.iiitb.healthcare_abha.Service;

import com.iiitb.healthcare_abha.DAO.AppointmentsInterface;
import com.iiitb.healthcare_abha.DAO.PatientVisitInterface;
import com.iiitb.healthcare_abha.Entity.Appointements;
import com.iiitb.healthcare_abha.Entity.Appointemnts_pks;
import com.iiitb.healthcare_abha.Entity.Patient_visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {


    @Autowired
    private AppointmentsInterface appointmentsInterface;

    @Autowired
    private PatientVisitInterface patientVisitInterface;

    public List<Appointements> get_all_appointemnts(){

        return appointmentsInterface.findAll();

    }

    public String create_appointement(Appointements appointements){
      List<Patient_visit> patient_visit= patientVisitInterface.findAllByPatient_id(appointements.getPatientID());

      long visit_id=1;
        Patient_visit patient_visit1 = new Patient_visit();
      if(patient_visit.isEmpty()){

          patient_visit1.setPatientID(appointements.getPatientID());
          patient_visit1.setVisitId(visit_id);


          patientVisitInterface.save(patient_visit1);

      }
      else{
          visit_id=patient_visit.size()+1;
          patient_visit1.setPatientID(appointements.getPatientID());
          patient_visit1.setVisitId(visit_id);
          patientVisitInterface.save(patient_visit1);


      }


      appointements.setVisitId(visit_id);
      appointmentsInterface.save(appointements);






        return "appointemnt created";


    }

    public String update_appointement(long p_id,long visitid,Appointements appointements){

        Appointements appointements1 =appointmentsInterface.findByIdAndStatus(p_id,visitid);
        if(appointements1==null){
            return "there is no appointement of type to update";
        }
        appointements.setId(appointements1.getId());
        appointements.setVisitId(visitid);
        appointements.setPatientID(p_id);
        //appointements.setId(appointemntsPks);

        appointmentsInterface.save(appointements);

        return "update appointments";
    }

    public String delete_appointement(long p_id,long visitid){

        Appointements appointements1 =appointmentsInterface.findByIdAndStatus(p_id,visitid);
        if(appointements1==null){
            return "there is no appointement of type to delete";
        }


        appointmentsInterface.deleteById(appointements1.getId());

        return "deleted appointments";
    }






}
