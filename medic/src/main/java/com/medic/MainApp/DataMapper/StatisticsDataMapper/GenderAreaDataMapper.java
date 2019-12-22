package com.medic.MainApp.DataMapper.StatisticsDataMapper;
import com.medic.MainApp.DTO.GenderAreaDto;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenderAreaDataMapper implements RowMapper<GenderAreaDto> {

    @Override
    public GenderAreaDto mapRow(ResultSet resultSet, int i) throws SQLException {

        GenderAreaDto dto = new GenderAreaDto();
        dto.setGender(resultSet.getString("gender"));
        dto.setDistrict(resultSet.getString("district"));
        dto.setTotal(resultSet.getString("total"));
        return dto;

    }
}