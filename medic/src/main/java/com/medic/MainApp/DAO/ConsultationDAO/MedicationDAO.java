package com.medic.MainApp.DAO.ConsultationDAO;

import com.medic.MainApp.Models.ConsultationModels.Medication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class MedicationDAO {

    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(DiagnosisDAO.class);


    public MedicationDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setMedication(Medication medication){
        logger.info("Medication DAO ---> set medication {} ");
        String sql = "INSERT INTO medication (session_id , medical_mgt , surgical_mgt ,  next_date , remarks) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql,medication.getSession_id(),medication.getMedical_management(),medication.getSurgical_management(),medication.getNext_date(),medication.getRemarks());

    }
}
