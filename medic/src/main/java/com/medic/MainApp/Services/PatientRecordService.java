package com.medic.MainApp.Services;
import com.medic.MainApp.DAO.PatientRecordDAO;
import com.medic.MainApp.Models.PatientRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientRecordService {

    private static final Logger logger = LoggerFactory.getLogger(PatientRecordService.class);

    private final PatientRecordDAO patientRecordDAO;

    PatientRecordService(PatientRecordDAO patientRecordDAO){
        this.patientRecordDAO = patientRecordDAO;
    }


    public void savePatientRecord(PatientRecord patientRecord){
        patientRecordDAO.savePatientRecord(patientRecord);
    }


}
