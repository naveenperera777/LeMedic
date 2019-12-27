package com.medic.MainApp.Controllers.StatisticsController;
import com.medic.MainApp.Models.ConsultationModels.Pricing;
import com.medic.MainApp.Services.StatisticsServices.MedicalCenterStatisticsService;
import com.medic.MainApp.Utils.ResponseUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("statistics/institute")
public class MedicalCenterStatisticsController extends ResponseUtils {

    private final MedicalCenterStatisticsService medicalCenterStatisticsService;

    public MedicalCenterStatisticsController(MedicalCenterStatisticsService medicalCenterStatisticsService) {
        this.medicalCenterStatisticsService = medicalCenterStatisticsService;
    }

    @GetMapping("/consultant/receipt/{consultantId}")
    public ResponseEntity getAllPatientCount(@PathVariable("consultantId") String consultantId){
       List<Pricing> receiptList = medicalCenterStatisticsService.getAllReceiptsOfAConsultant(consultantId);
        return successRetrieval(receiptList);
    }
}
