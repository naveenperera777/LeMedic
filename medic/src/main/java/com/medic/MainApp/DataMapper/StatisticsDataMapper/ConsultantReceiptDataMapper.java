package com.medic.MainApp.DataMapper.StatisticsDataMapper;
import com.medic.MainApp.Models.ConsultationModels.Pricing;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultantReceiptDataMapper implements RowMapper<Pricing> {

    @Override
    public Pricing mapRow(ResultSet resultSet, int i) throws SQLException {

        Pricing dto = new Pricing();
        dto.setSessionId(resultSet.getString("sessionId"));
        dto.setConsultationFees(resultSet.getDouble("consultationFees"));
        dto.setMedicationFees(resultSet.getDouble("medicationFees"));
        dto.setMiscellaneous(resultSet.getDouble("miscellaneous"));
        dto.setTax(resultSet.getDouble("tax"));
        dto.setTotal(resultSet.getDouble("total"));
        return dto;

    }
}