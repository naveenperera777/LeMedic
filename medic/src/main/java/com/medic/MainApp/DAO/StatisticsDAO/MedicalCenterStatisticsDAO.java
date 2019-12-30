package com.medic.MainApp.DAO.StatisticsDAO;

import com.medic.MainApp.DTO.SessionPatientCountDto;
import com.medic.MainApp.DTO.TimeCountDto;
import com.medic.MainApp.DataMapper.StatisticsDataMapper.ConsultantReceiptDataMapper;
import com.medic.MainApp.DataMapper.StatisticsDataMapper.SessionPatientDataMapper;
import com.medic.MainApp.DataMapper.StatisticsDataMapper.TimeCountDataMapper;
import com.medic.MainApp.Models.ConsultationModels.Pricing;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Time;
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

    public List<Pricing> getPricingSummaryOfAConsultantByDate(String consultantId, String from, String to){
        String sql = "SELECT p.sessionId, p.consultationFees, p.medicationFees, p.tax, p.total, p.miscellaneous from pricing as p INNER JOIN session s on p.sessionId = s.session_id INNER JOIN users u ON u.id = s.consultant_id WHERE s.consultant_id = ? && s.timestamp BETWEEN ? and ?";
        return  jdbcTemplate.query(sql, new String[]{consultantId,from,to}, new ConsultantReceiptDataMapper());
    }

    public List<Pricing> getAllTimePricingSummaryOfAConsultant(String consultantId){
        String sql = "SELECT p.sessionId, p.consultationFees, p.medicationFees, p.tax, p.total, p.miscellaneous from pricing as p INNER JOIN session s on p.sessionId = s.session_id INNER JOIN users u ON u.id = s.consultant_id WHERE s.consultant_id = ?";
        return  jdbcTemplate.query(sql, new String[]{consultantId}, new ConsultantReceiptDataMapper());
    }

    public SessionPatientCountDto getTotalPatientsSessionsOfAConsultantByDate(String consultantId, String from, String to) {
        String sql = "SELECT COUNT(s.session_id) as sessionCount, COUNT(p.id) as patientCount from session as s INNER JOIN patient p ON s.patient_id = p.id WHERE s.consultant_id=? && s.timestamp BETWEEN ? and ?";
        return  jdbcTemplate.queryForObject(sql, new String[]{consultantId,from,to}, new SessionPatientDataMapper());
    }

    public SessionPatientCountDto getAllTimeTotalPatientsSessionsOfAConsultant(String consultantId) {
        String sql = "SELECT COUNT(s.session_id) as sessionCount, COUNT(p.id) as patientCount from session as s INNER JOIN patient p ON s.patient_id = p.id WHERE s.consultant_id=?";
        return  jdbcTemplate.queryForObject(sql, new String[]{consultantId}, new SessionPatientDataMapper());
    }
    //Admin ONLY
    public SessionPatientCountDto getAllTimeTotalPatientsSessionsOfAllConsultants() {
        String sql = "SELECT COUNT(s.session_id) as sessionCount, COUNT(p.id) as patientCount from session as s INNER JOIN patient p ON s.patient_id = p.id";
        return  jdbcTemplate.queryForObject(sql , new SessionPatientDataMapper());
    }

    public SessionPatientCountDto getTotalPatientsSessionsOfAllConsultantByDate( String from, String to) {
        String sql = "SELECT COUNT(s.session_id) as sessionCount, COUNT(p.id) as patientCount from session as s INNER JOIN patient p ON s.patient_id = p.id WHERE s.timestamp BETWEEN ? and ?";
        return  jdbcTemplate.queryForObject(sql, new String[]{from,to}, new SessionPatientDataMapper());
    }

    public List<Pricing> getAllTimePricingSummaryOfAllConsultant(){
        String sql = "SELECT p.sessionId, p.consultationFees, p.medicationFees, p.tax, p.total, p.miscellaneous from pricing as p INNER JOIN session s on p.sessionId = s.session_id INNER JOIN users u ON u.id = s.consultant_id";
        return  jdbcTemplate.query(sql, new ConsultantReceiptDataMapper());
    }

    public List<Pricing> getPricingSummaryOfAllConsultantByDate(String from, String to){
        String sql = "SELECT p.sessionId, p.consultationFees, p.medicationFees, p.tax, p.total, p.miscellaneous from pricing as p INNER JOIN session s on p.sessionId = s.session_id INNER JOIN users u ON u.id = s.consultant_id WHERE s.timestamp BETWEEN ? and ?";
        return  jdbcTemplate.query(sql, new String[]{from,to}, new ConsultantReceiptDataMapper());
    }

    public List<TimeCountDto> getSessionComparisonByDate(String type, String from, String to){
        String sql = "SELECT session.timestamp,COUNT(session.id) as total from session WHERE session.timestamp BETWEEN ? and ? GROUP BY YEAR(session.timestamp)";
        return  jdbcTemplate.query(sql, new String[]{from,to}, new TimeCountDataMapper());
    }





}
