package com.medic.MainApp.DAO;

import com.medic.MainApp.DataMapper.PatientDataMapper;
import com.medic.MainApp.Models.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
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
        String sql = "SELECT * FROM patient";
        PatientDataMapper patientDataMapper = new PatientDataMapper();
        return jdbcTemplate.query(sql, patientDataMapper);
    }

    public List<Patient> getPatientById(String id){
        logger.info("Find Patient By id------{}",id);
        String sql = "SELECT * FROM patient WHERE id=?";
        PatientDataMapper patientDataMapper = new PatientDataMapper();
        return jdbcTemplate.query(sql,patientDataMapper,id);
    }

    public void addPatient(Patient patient){
        logger.info("Add patient DAO--->{}",patient.getPatient_id(),patient.getFirst_name(),patient.getLast_name(),patient.getGender(),patient.getNic(),patient.getCity(),patient.getDistrict(),patient.getEmail(),patient.getMobile());
        String sql = "INSERT INTO patient (id , firstname , lastname , gender , nic , city , district , email , mobile) VALUES ( ?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, patient.getPatient_id(),patient.getFirst_name(),patient.getLast_name(),patient.getGender(),patient.getNic(),patient.getCity(),patient.getDistrict(),patient.getEmail(),patient.getMobile());
    }

    public void updatePatient(Patient patient){
        logger.info("Update Patient DAO-----{}",patient.getPatient_id(),patient.getFirst_name(),patient.getLast_name(),patient.getGender(),patient.getNic(),patient.getCity(),patient.getDistrict(),patient.getEmail(),patient.getMobile());
        String sql = "UPDATE patient SET id=?, firstname=? , lastname=? , gender=? , nic=? , city=? , district=? , email=? , mobile=? WHERE  id=?";
          jdbcTemplate.update(sql, patient.getPatient_id(),patient.getFirst_name(),patient.getLast_name(),patient.getGender(),patient.getNic(),patient.getCity(),patient.getDistrict(),patient.getEmail(),patient.getMobile(),patient.getPatient_id());
    }
    public void deletePatient(String id){
        logger.info("Delete Patient DAO----{}",id);
        String sql = "DELETE FROM patient WHERE id=?";
        jdbcTemplate.update(sql,id);
    }

}
