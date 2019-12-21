package com.medic.MainApp.DAO.StatisticsDAO;

import com.medic.MainApp.DTO.AreaDiseaseDistributionDto;
import com.medic.MainApp.DTO.PatientsByAreaDto;
import com.medic.MainApp.DTO.PatientsByDiseaseDto;
import com.medic.MainApp.DTO.PatientsByGenderDto;
import com.medic.MainApp.DataMapper.StatisticsDataMapper.AreaDataMapper;
import com.medic.MainApp.DataMapper.StatisticsDataMapper.AreaDiseaseDistributionDataMapper;
import com.medic.MainApp.DataMapper.StatisticsDataMapper.DiseaseDataMapper;
import com.medic.MainApp.DataMapper.StatisticsDataMapper.GenderDataMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class PatientStatisticsDAO {

    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(PatientStatisticsDAO.class);

    public PatientStatisticsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getAllPatientCount(){
        String sql = "SELECT COUNT(*) FROM patient";
        return jdbcTemplate.queryForObject(sql ,Integer.class);
    }

    public List<PatientsByGenderDto> getPatientCountByGender(){
       String sql = "SELECT gender, COUNT(gender) as total FROM patient group by gender";
        return jdbcTemplate.query(sql , new GenderDataMapper());
    }

    public List getDiseaseList(){
        String sql = "SELECT distinct complain from session";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    public List<PatientsByDiseaseDto> getPatientCountByDisease(){
        String sql = "SELECT complain, COUNT(complain) as total from session group by complain";
        return jdbcTemplate.query(sql, new DiseaseDataMapper());
    }

    public List<PatientsByAreaDto> getPatientCountByArea(){
        String sql = "SELECT district, COUNT(district) as total from patient group by district";
        return  jdbcTemplate.query(sql , new AreaDataMapper());
    }

    public List<AreaDiseaseDistributionDto> getDiseaseDistributionOfAnArea(String district){
        String sql = "SELECT p.district, s.complain, COUNT(s.complain) as total from session AS s INNER JOIN patient as p ON s.patient_id = p.id WHERE  p.district = ? GROUP BY s.complain";
        return  jdbcTemplate.query(sql , new String[]{district} , new AreaDiseaseDistributionDataMapper());
    }

    public List<AreaDiseaseDistributionDto> getAreaDistributionOfADisease (String disease){
        String sql = "SELECT s.complain, p.district, COUNT(s.complain) as total from session AS s INNER JOIN patient as p ON s.patient_id = p.id WHERE s.complain = ? GROUP BY p.district";
        return  jdbcTemplate.query(sql , new String[]{disease} , new AreaDiseaseDistributionDataMapper());
    }


}
