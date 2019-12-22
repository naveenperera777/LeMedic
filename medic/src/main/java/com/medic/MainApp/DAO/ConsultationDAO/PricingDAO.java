package com.medic.MainApp.DAO.ConsultationDAO;

import com.medic.MainApp.Models.ConsultationModels.Pricing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PricingDAO {
    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(PricingDAO.class);


    public PricingDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setPricing(Pricing pricing){

    }
}
