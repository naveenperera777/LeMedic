package com.medic.MainApp.Controllers;


import com.medic.MainApp.Models.PatientRecord;
import com.medic.MainApp.Services.PatientRecordService;
import com.medic.MainApp.Utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PatientRecordController extends ResponseUtils {

    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);
    private final PatientRecordService patientRecordService;


    public PatientRecordController(PatientRecordService patientRecordService){
        this.patientRecordService = patientRecordService;
    }

//    Get a patient record by id
//    @GetMapping("/record/{id}")
//    public ResponseEntity getPatientRecordById(String id){
//        List patientRecord = patientRecordService.getPatientRecordById(id);
//    }
//
//    Get all records for a particular patient
//    @GetMapping("/record/patient/{id}")
//    public ResponseEntity getAllRecordsOfAPatient(String patientId){
//        List patientRecords = patientRecordService.getAllRecordsOfAPatient(patientId);
//        return patientRecords;
//    }

    //Get all patient records
    @GetMapping("/record/patient/{id}/all")
    public ResponseEntity getAllPatientRecords(@PathVariable String id){
        List AllPatientRecords = patientRecordService.getAllPatientRecordsByPatientId(id);
        if (AllPatientRecords != null) {
           return successRetrieval(AllPatientRecords);
        }
        return FailedRetrieval(AllPatientRecords);

    }
//
    //Save a patient record
    @PostMapping("/record/patient/save")
    public void savePatientRecord(@RequestBody PatientRecord patientRecord){
        patientRecordService.savePatientRecord(patientRecord);
    }



}
