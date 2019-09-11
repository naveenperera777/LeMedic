package com.medic.MainApp.DataMapper;
import com.medic.MainApp.Models.PatientRecord;
import com.medic.MainApp.Models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientRecordDataMapper implements RowMapper<PatientRecord> {

    private static final Logger logger = LoggerFactory.getLogger(PatientRecordDataMapper.class);

    @Override
    public PatientRecord mapRow(ResultSet resultSet, int i) throws SQLException {

        logger.info("userdatamapper {}" , resultSet.toString());

        PatientRecord patientRecord = new PatientRecord();
        patientRecord.setPatient_id(resultSet.getString("patient_id"));
        patientRecord.setConsultant_id(resultSet.getString("consultant_id"));
        patientRecord.setMedications(resultSet.getString("medications"));
        patientRecord.setSymptoms(resultSet.getString("symptoms"));

        return patientRecord;
    }
}
