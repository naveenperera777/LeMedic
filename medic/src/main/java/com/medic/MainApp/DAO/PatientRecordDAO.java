package com.medic.MainApp.DAO;

import com.medic.MainApp.DataMapper.PatientDataMapper;
import com.medic.MainApp.DataMapper.PatientRecordDataMapper;
import com.medic.MainApp.Models.PatientRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public List getAllPatientRecordsByPatientId(String id){
        logger.info("patient record DAO {}" , id);
        String sql = "SELECT * FROM patient_record WHERE patient_id=?";
        return jdbcTemplate.query(sql, new String[]{id} , new PatientRecordDataMapper());
    }

}
