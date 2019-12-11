package com.medic.MainApp.DataMapper.ConsultationDataMapper;


import com.medic.MainApp.Models.ConsultationModels.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SessionDataMapper implements RowMapper<Session> {

    private static final Logger logger = LoggerFactory.getLogger(SessionDataMapper.class);

    @Override
    public Session mapRow(ResultSet resultSet, int i) throws SQLException {

        logger.info("session data mapper {}" , resultSet.toString());

        Session session = new Session();
        session.setConsultant_id(resultSet.getString("consultant_id"));
        session.setPatient_id(resultSet.getString("patient_id"));
        session.setTimestamp(resultSet.getTimestamp("timestamp"));
        session.setSession_id(resultSet.getString("session_id"));
        session.setComplain(resultSet.getString("complain"));
        session.setSigns(resultSet.getString("signs"));
        session.setGeneral_exam(resultSet.getString("general_exam"));
        session.setSystem_exam(resultSet.getString("system_exam"));
        session.setInvestigation(resultSet.getString("investigation"));
        session.setMedical_management(resultSet.getString("medical_management"));
        session.setSurgical_management(resultSet.getString("surgical_management"));
        session.setNext_date(resultSet.getDate("next_date"));
        session.setRemarks(resultSet.getString("remarks"));
        return session;
    }
}
