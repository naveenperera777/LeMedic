package com.medic.MainApp.DataMapper.ConsultationDataMapper;
import com.medic.MainApp.Models.ConsultationModels.Diagnosis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiagnosisDataMapper implements RowMapper<Diagnosis> {

    private static final Logger logger = LoggerFactory.getLogger(DiagnosisDataMapper.class);

    @Override
    public Diagnosis mapRow(ResultSet resultSet, int i) throws SQLException {

        logger.info("session data mapper {}" , resultSet.toString());

        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setSession_id(resultSet.getInt("session_id"));
        diagnosis.setComplain(resultSet.getString("complain"));
        diagnosis.setSigns(resultSet.getString("signs"));
        diagnosis.setGeneral_exam(resultSet.getString("general_exam"));
        diagnosis.setSystem_exam(resultSet.getString("system_exam"));
        diagnosis.setInvestigation(resultSet.getString("investigation"));
        return diagnosis;
    }
}
