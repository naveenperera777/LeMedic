package com.medic.MainApp.DAO.ConsultationDAO;

import com.medic.MainApp.Models.ConsultationModels.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SessionDAO {

    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(SessionDAO.class);


    public SessionDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setSesssion(Session sesssion){
        logger.info("Session DAO ---> set session {} ");
        String sql = "INSERT INTO session (patient_id , consultant_id , timestamp ) VALUES (?,?,?)";
        jdbcTemplate.update(sql,sesssion.getPatient_id(),sesssion.getConsultant_id(),sesssion.getTimestamp());

    }

//    public List getAllPatientRecordsByPatientId(String id){
//        logger.info("patient record DAO {}" , id);
//        String sql = "SELECT * FROM patient_record WHERE patient_id=?";
//        return jdbcTemplate.query(sql, new String[]{id} , new PatientRecordDataMapper());
//    }
}
