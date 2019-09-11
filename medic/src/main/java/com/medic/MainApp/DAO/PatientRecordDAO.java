package com.medic.MainApp.DAO;

import com.medic.MainApp.Models.PatientRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PatientRecordDAO {
    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(PatientRecordDAO.class);


    public PatientRecordDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void savePatientRecord(PatientRecord patientRecord){
        logger.info("Patient Record DAO ---> save{} ");
        String sql = "INSERT INTO patient_record (patient_id , consultant_id , symptoms , medications) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, patientRecord.getPatient_id() , patientRecord.getConsultant_id() , patientRecord.getSymptoms() , patientRecord.getMedications());

    }

}
