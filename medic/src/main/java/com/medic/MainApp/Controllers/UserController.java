package com.medic.MainApp.Controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
public class UserController {

    @RequestMapping("/user")
    public Response getAllUsers(){

    }


}
