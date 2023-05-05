package com.iiitb.healthcare_abha.Service;

import com.iiitb.healthcare_abha.DAO.Care_Context_Inteface;
import com.iiitb.healthcare_abha.Entity.CareContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CareContextService {
    @Autowired
    private Care_Context_Inteface careContextInteface;

    public void save_patient_and_authtoken(CareContext careContext){
        careContextInteface.save(careContext);

    }
    public  String get_auth_token(Long id){

        return careContextInteface.find_auth_token(id).getToken();
    }




}
