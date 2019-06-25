package com.medic.MainApp.Controllers;


import com.medic.MainApp.Models.Patient;
import com.medic.MainApp.Services.PatientService;
import com.medic.MainApp.Utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController extends ResponseUtils {

    @Autowired
    PatientService patientService;
    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

    public PatientController() {
    }

    //Get Details of all patients
    @GetMapping("/patient/all")
    public ResponseEntity getAllPatients() {
        List<Patient> patientList = patientService.getAllPatients();
        if (!patientList.isEmpty()) {
            ResponseEntity responseEntity = successRetrieval(patientList);
            return responseEntity;
        }
        return FailedRetrieval(patientList);
    }

    //Add patient
    @PostMapping("/patient/add")
    public void addPatient(@RequestBody Patient patient){
        logger.info("PatientController-SavePatient--->Saving..");
        patientService.addPatient(patient);
    }

    //Update patient
    @PutMapping("/patient/update")
    public void updatePatient(@RequestBody Patient patient){
        logger.info("PatientController-Update----->Update");
        patientService.updatePatient(patient);

    }

    //Delete Patient
    @DeleteMapping("/patient/delete/{id}")
     public void deletePatient(@PathVariable String id){
        logger.info("PatientController--->Delete");
        patientService.deletePatient(id);
    }



}
