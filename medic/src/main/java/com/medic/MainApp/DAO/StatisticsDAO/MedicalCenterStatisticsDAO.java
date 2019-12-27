package com.medic.MainApp.DAO.StatisticsDAO;

import com.medic.MainApp.DataMapper.StatisticsDataMapper.ConsultantReceiptDataMapper;
import com.medic.MainApp.Models.ConsultationModels.Pricing;
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
    //    public Object getTotalRevenueForMedicalCenter(){
    //        String sql = "SELECT p.sessionId,p.consultationFees,p.medicationFees,p.tax,p.miscellaneous,p.total from pricing as p INNER JOIN session s ON s.session_id = p.sessionId;"
    //    }

    public List<Pricing> getAllReceiptsOfAConsultant(String consultantId){
        String sql = "SELECT p.sessionId, p.consultationFees, p.medicationFees, p.tax, p.total, p.miscellaneous from pricing as p INNER JOIN session s on p.sessionId = s.session_id INNER JOIN users u ON u.id = s.consultant_id WHERE s.consultant_id = ?";
        return  jdbcTemplate.query(sql, new String[]{consultantId}, new ConsultantReceiptDataMapper());
    }

}
