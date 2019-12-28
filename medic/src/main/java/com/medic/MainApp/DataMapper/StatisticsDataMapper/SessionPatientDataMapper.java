package com.medic.MainApp.DataMapper.StatisticsDataMapper;
import com.medic.MainApp.DTO.SessionPatientCountDto;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SessionPatientDataMapper implements RowMapper<SessionPatientCountDto> {

    @Override
    public SessionPatientCountDto mapRow(ResultSet resultSet, int i) throws SQLException {

        SessionPatientCountDto dto = new SessionPatientCountDto();
        dto.setSessionCount(resultSet.getString("sessionCount"));
        dto.setPatientCount(resultSet.getString("patientCount"));
        return dto;
    }
}