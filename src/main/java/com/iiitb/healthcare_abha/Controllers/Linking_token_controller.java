package com.iiitb.healthcare_abha.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Linking_token_controller {

    @Autowired
    private com.iiitb.healthcare_abha.Service.LinkingTokenService linkingTokenService;
   /* @PostMapping("/save_linking token")
    public void save_linking_token(){
        linkingTokenService.add_linking_token();

    }

*/
}
