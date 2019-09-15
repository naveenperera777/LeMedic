package com.medic.MainApp.Controllers.ConsultationControllers;

import com.medic.MainApp.Models.ConsultationModels.Session;
import com.medic.MainApp.Services.ConsultationServices.SessionService;
import com.medic.MainApp.Utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SessionController extends ResponseUtils {
    private final SessionService sessionService;
    private static final Logger logger = LoggerFactory.getLogger(SessionController.class);

    public SessionController(SessionService sessionService ){
        this.sessionService = sessionService;
    }

    //Get details of all sessions
//    @GetMapping("/sessions")
//    public ResponseEntity getAllUsers(){
//        List users = sessionService.getAllSessions();
//        logger.info("users {}" ,users);
//        if (!users.isEmpty()) {
//            ResponseEntity responseEntity = successRetrieval(users);
//            return responseEntity;
//        }
//        return FailedRetrieval(users);
//    }


    @PostMapping("/session/set")
    public void saveUser(@RequestBody Session session){
        logger.info("setsession----->", session);
        sessionService.setSession(session);
    }

}
