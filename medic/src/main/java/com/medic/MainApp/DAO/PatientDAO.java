package com.medic.MainApp.DAO;

import com.medic.MainApp.DataMapper.PatientDataMapper;
import com.medic.MainApp.Models.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientDAO {

    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);

    public PatientDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Patient> getAllPatients(){
        String sql = "SELECT * FROM Patient";
        PatientDataMapper patientDataMapper = new PatientDataMapper();
        return jdbcTemplate.query(sql, patientDataMapper);
    }

}
