package com.medic.MainApp.DataMapper.StatisticsDataMapper;
import com.medic.MainApp.DTO.ConsultantLeaderBoardDto;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultantLeaderboardDataMapper implements RowMapper<ConsultantLeaderBoardDto> {

    @Override
    public ConsultantLeaderBoardDto mapRow(ResultSet resultSet, int i) throws SQLException {

        ConsultantLeaderBoardDto dto = new ConsultantLeaderBoardDto();
        dto.setId(resultSet.getString("id"));
        dto.setFirstName(resultSet.getString("firstname"));
        dto.setLastName(resultSet.getString("lastname"));
        dto.setCount(resultSet.getString("sessionCount"));
        return dto;

    }
}