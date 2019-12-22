package com.medic.MainApp.DataMapper.ConsultationDataMapper;
import com.medic.MainApp.Models.ConsultationModels.Pricing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;



public class PricingDataMapper implements RowMapper<Pricing> {

    private static final Logger logger = LoggerFactory.getLogger(SessionDataMapper.class);

    @Override
    public Pricing mapRow(ResultSet resultSet, int i) throws SQLException {

        logger.info("session data mapper {}" , resultSet.toString());

        Pricing pricing = new Pricing();
        pricing.setConsultationFees(resultSet.getDouble("consultationFees"));
        pricing.setMedicationFees(resultSet.getDouble("medicationFees"));
        pricing.setMiscellaneous(resultSet.getDouble("miscellaneous"));
        pricing.setTax(resultSet.getDouble("tax"));
        pricing.setTotal(resultSet.getDouble("total"));
        return  pricing;
    }
}