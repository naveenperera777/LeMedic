package com.medic.MainApp.Controllers.StatisticsController;
import com.medic.MainApp.DTO.PatientsByAreaDto;
import com.medic.MainApp.DTO.PatientsByDiseaseDto;
import com.medic.MainApp.DTO.PatientsByGenderDto;
import com.medic.MainApp.Services.StatisticsServices.PatientStatisticsService;
import com.medic.MainApp.Utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("statistics")
public class PatientStatisticsController extends ResponseUtils {

    private final PatientStatisticsService patientStatisticsService;
    private static final Logger logger = LoggerFactory.getLogger(PatientStatisticsController.class);

    @Autowired
    public PatientStatisticsController(PatientStatisticsService patientStatisticsService){
        this.patientStatisticsService = patientStatisticsService;
    }

    @GetMapping("/patient/count/total")
    public ResponseEntity getAllPatientCount(){
        int count = patientStatisticsService.getAllPatientCount();
        logger.info("patient record controller {}" ,count);
          return successRetrieval(count);
    }

    @GetMapping("/patient/count/gender")
    public ResponseEntity getPatientCountByGender(){
        List<PatientsByGenderDto> count = patientStatisticsService.getPatientCountByGender();
        logger.info("patient record controller {}" ,count);
        return successRetrieval(count);
    }

    @GetMapping("/patient/count/disease")
    public ResponseEntity getPatientCountByDisease(){
        List<PatientsByDiseaseDto> count = patientStatisticsService.getPatientCountByDisease();
        logger.info("patient record controller {}" ,count);
        return successRetrieval(count);
    }

    @GetMapping("/patient/count/area")
    public ResponseEntity getPatientCountByArea(){
        List<PatientsByAreaDto> count = patientStatisticsService.getPatientCountByArea();
        logger.info("patient record controller {}" ,count);
        return successRetrieval(count);
    }

    @GetMapping("/patient/count/disease/area")
    public ResponseEntity getPatientCountByDiseaseArea(){
        List<PatientsByAreaDto> count = patientStatisticsService.getPatientCountByDiseaseArea();
        logger.info("patient record controller {}" ,count);
        return successRetrieval(count);
    }



    @GetMapping("/patient/disease/list")
    public ResponseEntity getDiseaseList(){
        List diseaseList = patientStatisticsService.getDiseaseList();
        return successRetrieval(diseaseList);
    }




}
