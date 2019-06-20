package com.medic.MainApp.DataMapper;

import com.medic.MainApp.Models.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientDataMapper implements RowMapper<Patient> {

    private static final Logger logger = LoggerFactory.getLogger(PatientDataMapper.class);

    @Override
    public Patient mapRow(ResultSet resultSet, int i) throws SQLException {

        Patient patient = new Patient();
        patient.setPatient_id(resultSet.getString("id"));
        patient.setFirst_name(resultSet.getString("firstname"));
        patient.setLast_name(resultSet.getString("lastname"));
        patient.setCity(resultSet.getString("city"));
        patient.setDistrict(resultSet.getString("district"));
        patient.setGender(resultSet.getString("gender"));
        patient.setNic(resultSet.getString("nic"));
        patient.setEmail(resultSet.getString("email"));
        patient.setMobile(resultSet.getInt("mobile"));

        return patient;

    }


}
