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
        session.setConsultant_id(resultSet.getInt("consultant_id"));
        session.setPatient_id(resultSet.getInt("patient_id"));
        session.setTimestamp(resultSet.getTimestamp("timestamp"));
        return session;
    }
}
