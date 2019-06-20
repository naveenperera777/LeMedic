package com.medic.MainApp.Controllers;


import com.medic.MainApp.Models.Patient;
import com.medic.MainApp.Services.PatientService;
import com.medic.MainApp.Utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/patient")
public class PatientController extends ResponseUtils {

    @Autowired
    PatientService patientService;
    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

    public PatientController() {
    }

    //Get Details of all patients
    @GetMapping("/patients")
    public ResponseEntity getAllPatients() {
        List<Patient> patientList = patientService.getAllPatients();
        if (!patientList.isEmpty()) {
            ResponseEntity responseEntity = successRetrieval(patientList);
            return responseEntity;
        }
        return FailedRetrieval(patientList);
    }

}
