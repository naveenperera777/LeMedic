package com.medic.MainApp.Controllers.StatisticsController;
import com.medic.MainApp.DTO.ConsultatantPricingSummaryDto;
import com.medic.MainApp.DTO.SessionPatientCountDto;
import com.medic.MainApp.Models.ConsultationModels.Pricing;
import com.medic.MainApp.Services.StatisticsServices.MedicalCenterStatisticsService;
import com.medic.MainApp.Utils.ResponseUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("statistics/institute")
public class MedicalCenterStatisticsController extends ResponseUtils {

    private final MedicalCenterStatisticsService medicalCenterStatisticsService;

    public MedicalCenterStatisticsController(MedicalCenterStatisticsService medicalCenterStatisticsService) {
        this.medicalCenterStatisticsService = medicalCenterStatisticsService;
    }

    @GetMapping("/consultant/receipt/{consultantId}")
    public ResponseEntity getAllReceiptsOfAConsultant(@PathVariable("consultantId") String consultantId){
       List<Pricing> receiptList = medicalCenterStatisticsService.getAllReceiptsOfAConsultant(consultantId);
        return successRetrieval(receiptList);
    }

    @GetMapping("/consultant/receipt/summary/{consultantId}")
    public ResponseEntity getPricingSummaryOfAConsultantByDate(@PathVariable("consultantId") String consultantId, @RequestHeader("from") String from, @RequestHeader("to")String to){
        ConsultatantPricingSummaryDto summary = medicalCenterStatisticsService.getPricingSummaryOfAConsultantByDate(consultantId,from,to);
        return successRetrieval(summary);
    }

    @GetMapping("/consultant/count/session/patient/{consultantId}")
    public ResponseEntity getTotalPatientsSessionsOfAConsultantByDate(@PathVariable("consultantId") String consultantId, @RequestHeader("from") String from, @RequestHeader("to")String to){
        SessionPatientCountDto summary = medicalCenterStatisticsService.getTotalPatientsSessionsOfAConsultantByDate(consultantId,from,to);
        return successRetrieval(summary);
    }


}
