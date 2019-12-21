package com.medic.MainApp.DataMapper.StatisticsDataMapper;

import com.medic.MainApp.DTO.AreaDiseaseDistributionDto;
import com.medic.MainApp.DTO.PatientsByAreaDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AreaDiseaseDistributionDataMapper implements RowMapper<AreaDiseaseDistributionDto> {

    @Override
    public AreaDiseaseDistributionDto mapRow(ResultSet resultSet, int i) throws SQLException {

        AreaDiseaseDistributionDto dto = new AreaDiseaseDistributionDto();
        dto.setDistrict(resultSet.getString("district"));
        dto.setDisease(resultSet.getString("complain"));
        dto.setTotal(resultSet.getString("total"));
        return dto;

    }
}