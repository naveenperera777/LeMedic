package com.medic.MainApp.Controllers.ConsultationControllers;

import com.medic.MainApp.Models.ConsultationModels.Medication;
import com.medic.MainApp.Services.ConsultationServices.MedicationService;
import com.medic.MainApp.Utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicationController extends ResponseUtils {
    private final MedicationService medicationService;
    private static final Logger logger = LoggerFactory.getLogger(SessionController.class);

    public MedicationController(MedicationService medicationService ){
        this.medicationService = medicationService;
    }


    @PostMapping("/medication/set")
    public void saveUser(@RequestBody Medication medication){
        logger.info("save medication----->", medication);
        medicationService.setMedication(medication);
    }
}
