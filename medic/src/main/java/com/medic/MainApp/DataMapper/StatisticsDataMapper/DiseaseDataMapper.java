package com.medic.MainApp.DataMapper.StatisticsDataMapper;


import com.medic.MainApp.DTO.PatientsByDiseaseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiseaseDataMapper implements RowMapper<PatientsByDiseaseDto> {

    private static final Logger logger = LoggerFactory.getLogger(GenderDataMapper.class);

    @Override
    public PatientsByDiseaseDto mapRow(ResultSet resultSet, int i) throws SQLException {

        PatientsByDiseaseDto dto = new PatientsByDiseaseDto();
        dto.setDisease(resultSet.getString("complain"));
        dto.setTotal(resultSet.getString("total"));
        return dto;

    }
}