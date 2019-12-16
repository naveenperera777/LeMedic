package com.medic.MainApp.DAO.StatisticsDAO;

import com.medic.MainApp.DTO.PatientsByGenderDto;
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

}
