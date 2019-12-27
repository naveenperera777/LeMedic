package com.medic.MainApp.DAO.StatisticsDAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MedicalCenterStatisticsDAO {

    private final JdbcTemplate jdbcTemplate;

    public MedicalCenterStatisticsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Admin only
    public Object getTotalRevenueForMedicalCenter(){
        String sql = "SELECT p.sessionId,p.consultationFees,p.medicationFees,p.tax,p.miscellaneous,p.total from pricing as p INNER JOIN session s ON s.session_id = p.sessionId;"
    }

    public List getAllReceiptsOfAConsultant(String consultantId){
      String sql =   "SELECT * FROM pricing LEFT JOIN session on pricing.sessionId = session.session_id WHERE session.consultant_id = '?'";
    }



}
