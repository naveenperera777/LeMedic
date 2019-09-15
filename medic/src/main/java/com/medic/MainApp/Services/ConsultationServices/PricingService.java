package com.medic.MainApp.Services.ConsultationServices;

import com.medic.MainApp.DAO.ConsultationDAO.PricingDAO;
import com.medic.MainApp.Models.ConsultationModels.Pricing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PricingService {
    private final PricingDAO pricingDAO;
    private static final Logger logger = LoggerFactory.getLogger(MedicationService.class);

    public PricingService(PricingDAO pricingDAO){
        this.pricingDAO = pricingDAO;
    }

    public void setPricing(Pricing pricing){
        pricingDAO.setPricing(pricing);
    }
}
