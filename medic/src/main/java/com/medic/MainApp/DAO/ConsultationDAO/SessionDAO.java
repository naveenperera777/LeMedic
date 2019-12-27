package com.medic.MainApp.DAO.ConsultationDAO;

import com.medic.MainApp.DataMapper.ConsultationDataMapper.SessionDataMapper;
import com.medic.MainApp.Models.ConsultationModels.Pricing;
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
        String sql = "INSERT INTO session (patient_id , consultant_id , timestamp, session_id, complain, signs , general_exam,system_exam,investigation,medical_management,surgical_management,next_date,remarks) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,sesssion.getPatient_id(),sesssion.getConsultant_id(),sesssion.getTimestamp(), sesssion.getSession_id(), sesssion.getComplain(),sesssion.getSigns(), sesssion.getGeneral_exam(), sesssion.getSystem_exam(),sesssion.getInvestigation(),sesssion.getMedical_management(),sesssion.getMedical_management(),sesssion.getNext_date(),sesssion.getRemarks());

    }

    public void setPricing(Pricing pricing){
        String sql = "INSERT INTO pricing (sessionId,consultationFees,medicationFees,tax,miscellaneous,total) VALUES(?,?,?,?,?,?)";
        jdbcTemplate.update(sql,pricing.getSessionId(),pricing.getConsultationFees(),pricing.getMedicationFees(),pricing.getTax(),pricing.getMiscellaneous(),pricing.getTotal());
    }

    public List getSessionsByPatientId(String patientId){
        String sql = "SELECT * FROM session WHERE patient_id=?";
        return jdbcTemplate.query(sql, new String[]{patientId} , new SessionDataMapper());
    }

//    public List getAllPatientRecordsByPatientId(String id){
//        logger.info("patient record DAO {}" , id);
//        String sql = "SELECT * FROM patient_record WHERE patient_id=?";
//        return jdbcTemplate.query(sql, new String[]{id} , new PatientRecordDataMapper());
//    }
}
