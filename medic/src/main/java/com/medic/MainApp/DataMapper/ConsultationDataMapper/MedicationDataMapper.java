package com.medic.MainApp.DataMapper.ConsultationDataMapper;

import com.medic.MainApp.Models.ConsultationModels.Medication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicationDataMapper implements RowMapper<Medication> {

    private static final Logger logger = LoggerFactory.getLogger(MedicationDataMapper.class);

    @Override
    public Medication mapRow(ResultSet resultSet, int i) throws SQLException {

        logger.info("Medication data mapper {}" , resultSet.toString());

        Medication medication = new Medication();
        medication.setSession_id(resultSet.getInt("session_id"));
        medication.setMedical_management(resultSet.getString("medical_mgt"));
        medication.setSurgical_management(resultSet.getString("surgical_mgt"));
        medication.setNext_date(resultSet.getTimestamp("next_date"));
        medication.setRemarks(resultSet.getString("remarks"));

        return  medication;
    }
}