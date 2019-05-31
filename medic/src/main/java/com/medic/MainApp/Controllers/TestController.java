package com.medic.MainApp.Controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TestController {

@RequestMapping("/")
public String healthcheck() throws IOException{

    return "Server is working!";
}

}
