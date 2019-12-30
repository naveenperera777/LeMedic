package com.medic.MainApp.DataMapper.StatisticsDataMapper;
import com.medic.MainApp.DTO.TimeCountDto;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TimeCountDataMapper implements RowMapper<TimeCountDto> {

    @Override
    public TimeCountDto mapRow(ResultSet resultSet, int i) throws SQLException {

        TimeCountDto dto = new TimeCountDto();
        dto.setTimestamp(resultSet.getString("timestamp"));
        dto.setTotal(resultSet.getString("total"));
        return dto;
    }
}