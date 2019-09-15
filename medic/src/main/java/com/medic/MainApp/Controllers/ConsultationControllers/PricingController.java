package com.medic.MainApp.Controllers.ConsultationControllers;

import com.medic.MainApp.Models.ConsultationModels.Pricing;
import com.medic.MainApp.Services.ConsultationServices.PricingService;
import com.medic.MainApp.Utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PricingController extends ResponseUtils {
    private final PricingService pricingService;
    private static final Logger logger = LoggerFactory.getLogger(PricingController.class);

    public PricingController(PricingService pricingService ){
        this.pricingService = pricingService;
    }


    @PostMapping("/pricing/set")
    public void saveUser(@RequestBody Pricing pricing){
        logger.info("save pricing----->", pricing);
        pricingService.setPricing(pricing);
    }
}
