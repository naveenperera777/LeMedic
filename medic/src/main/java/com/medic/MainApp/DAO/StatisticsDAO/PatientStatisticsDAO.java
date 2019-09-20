package com.medic.MainApp.DAO.StatisticsDAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


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

}
