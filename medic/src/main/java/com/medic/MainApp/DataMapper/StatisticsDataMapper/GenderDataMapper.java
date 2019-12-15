package com.medic.MainApp.DataMapper.StatisticsDataMapper;
import com.medic.MainApp.DTO.PatientsByGenderDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GenderDataMapper implements RowMapper<PatientsByGenderDto> {

    private static final Logger logger = LoggerFactory.getLogger(GenderDataMapper.class);

    @Override
    public PatientsByGenderDto mapRow(ResultSet resultSet, int i) throws SQLException {

        PatientsByGenderDto dto = new PatientsByGenderDto();
        dto.setGender(resultSet.getString("gender"));
        dto.setTotal(resultSet.getString("total"));
        return dto;

    }
}