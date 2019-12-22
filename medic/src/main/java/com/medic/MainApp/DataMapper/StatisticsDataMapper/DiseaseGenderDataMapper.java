package com.medic.MainApp.DataMapper.StatisticsDataMapper;
import com.medic.MainApp.DTO.DiseaseGenderDto;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DiseaseGenderDataMapper implements RowMapper<DiseaseGenderDto> {

    @Override
    public DiseaseGenderDto mapRow(ResultSet resultSet, int i) throws SQLException {

        DiseaseGenderDto dto = new DiseaseGenderDto();
        dto.setGender(resultSet.getString("gender"));
        dto.setComplain(resultSet.getString("complain"));
        dto.setTotal(resultSet.getString("total"));
        return dto;

    }
}