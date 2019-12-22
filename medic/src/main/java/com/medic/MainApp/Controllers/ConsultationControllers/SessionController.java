package com.medic.MainApp.Controllers.ConsultationControllers;

import com.medic.MainApp.Models.ConsultationModels.Pricing;
import com.medic.MainApp.Models.ConsultationModels.Session;
import com.medic.MainApp.Services.ConsultationServices.SessionService;
import com.medic.MainApp.Utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SessionController extends ResponseUtils {
    private final SessionService sessionService;
    private static final Logger logger = LoggerFactory.getLogger(SessionController.class);

    public SessionController(SessionService sessionService ){
        this.sessionService = sessionService;
    }

    @PostMapping("/session/set")
    public void saveUser(@RequestBody Session session){
        logger.info("setsession----->", session);
        sessionService.setSession(session);
    }

    @PostMapping("/session/pricing")
    public void savePricingDetails(@RequestBody Pricing pricing){
        sessionService.setPricing(pricing);
    }

    @GetMapping("/session/patient/{patientId}/all")
    public ResponseEntity getSessionsByPatientId(@PathVariable("patientId") String patientId ) {
        List<Session> sessionList = sessionService.getSessionsByPatientId(patientId);
        if (!sessionList.isEmpty()) {
            ResponseEntity responseEntity = successRetrieval(sessionList);
            return responseEntity;
        }
        return FailedRetrieval(sessionList);
    }


}
