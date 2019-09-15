package com.medic.MainApp.Controllers.ConsultationControllers;

import com.medic.MainApp.Models.ConsultationModels.Diagnosis;
import com.medic.MainApp.Services.ConsultationServices.DiagnosisService;
import com.medic.MainApp.Utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiagnosisController extends ResponseUtils {
    private final DiagnosisService diagnosisService;
    private static final Logger logger = LoggerFactory.getLogger(SessionController.class);

    public DiagnosisController(DiagnosisService diagnosisService ){
        this.diagnosisService = diagnosisService;
    }


    @PostMapping("/diagnosis/set")
    public void saveUser(@RequestBody Diagnosis diagnosis){
        logger.info("save diagnosis----->", diagnosis);
        diagnosisService.setDiagnosis(diagnosis);
    }
}
