package com.medic.MainApp.DataMapper.StatisticsDataMapper;

import com.medic.MainApp.DTO.PatientsByAreaDto;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AreaDataMapper implements RowMapper<PatientsByAreaDto> {

    @Override
    public PatientsByAreaDto mapRow(ResultSet resultSet, int i) throws SQLException {

        PatientsByAreaDto dto = new PatientsByAreaDto();
        dto.setDistrict(resultSet.getString("district"));
        dto.setDisease(resultSet.getString("complain"));
        dto.setTotal(resultSet.getString("total"));
        return dto;

    }
}