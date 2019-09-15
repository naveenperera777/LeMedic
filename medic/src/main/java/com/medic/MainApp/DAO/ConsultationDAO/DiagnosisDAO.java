package com.medic.MainApp.DAO.ConsultationDAO;

import com.medic.MainApp.Models.ConsultationModels.Diagnosis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DiagnosisDAO {
    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(DiagnosisDAO.class);


    public DiagnosisDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setDiagnosis(Diagnosis diagnosis){
        logger.info("Diagnosis DAO ---> set diagnosis {} ");
        String sql = "INSERT INTO diagnosis (session_id , complain , signs ,  general_exam , system_exam , investigation) VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(sql,diagnosis.getSession_id(),diagnosis.getComplain(),diagnosis.getSigns(),diagnosis.getGeneral_exam(),diagnosis.getSystem_exam(),diagnosis.getInvestigation());

    }
}
