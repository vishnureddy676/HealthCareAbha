package com.iiitb.healthcare_abha.Service;

//import com.iiitb.healthcare_abha.DAO.Linking_token_interface;
import com.iiitb.healthcare_abha.Entity.LinkingToken;
import com.iiitb.healthcare_abha.Entity.linking_token_pks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkingTokenService {

/*    @Autowired
    private Linking_token_interface linkingTokenInterface;*/
/*public  void add_linking_token(){
    LinkingToken linkingToken = new LinkingToken();
    linkingToken.setLinking_token("abcd");
    linking_token_pks linkingTokenPks = new linking_token_pks();
    linkingTokenPks.setPatientID(Long.valueOf(2));

   long l =linkingTokenInterface.countByIdAndStatus(Long.valueOf(1));
    linkingTokenPks.setVisit_id(l+1);
    linkingToken.setId(linkingTokenPks);

    linkingTokenInterface.save(linkingToken);
}*/



}
