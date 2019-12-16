package com.medic.MainApp.Controllers.StatisticsController;
import com.medic.MainApp.DTO.PatientsByGenderDto;
import com.medic.MainApp.Services.StatisticsServices.PatientStatisticsService;
import com.medic.MainApp.Utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/patient/disease/list")
    public ResponseEntity getDiseaseList(){
        List diseaseList = patientStatisticsService.getDiseaseList();
        return successRetrieval(diseaseList);
    }

//    @GetMapping("/patient/count/month")
//    public ResponseEntity getPatientCountThisMonth(){
//    }
//
//    @GetMapping("/patient/count/month/last")
//    public ResponseEntity getPatientCountLastThirty(){
//    }
//
//    @GetMapping("/patient/count/month/all")
//    public ResponseEntity getPatientCountLastThirty(){
//    }
//
//    @GetMapping("/patient/count/year")
//    public ResponseEntity getPatientCountCurrentYear(){
//    }
//
//    @GetMapping("/patient/count/year/all")
//    public ResponseEntity getPatientCountLastThirty(){
//    }
//
//    @GetMapping("/patient/disease/count")
//    public ResponseEntity getPatientCountByDisease(){
//    }
//
//    @GetMapping("/patient/district/count")
//    public ResponseEntity getPatientCountByDistrict(){
//    }
//
//    @GetMapping("/patient/age/count")
//    public ResponseEntity getPatientCountByAgeRange(){
//    }
//
//    @GetMapping("/patient/gender/count")
//    public ResponseEntity getPatientByGender(){
//    }



}
