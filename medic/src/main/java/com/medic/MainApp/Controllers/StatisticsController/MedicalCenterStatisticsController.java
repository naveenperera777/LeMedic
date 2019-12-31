package com.medic.MainApp.Controllers.StatisticsController;
import com.medic.MainApp.DTO.ConsultantLeaderBoardDto;
import com.medic.MainApp.DTO.ConsultatantPricingSummaryDto;
import com.medic.MainApp.DTO.SessionPatientCountDto;
import com.medic.MainApp.DTO.TimeCountDto;
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

    @GetMapping("/consultant/all/session/patient/count")
    public ResponseEntity getAllTimeTotalPatientsSessionsOfAllConsultantsByDate(@RequestHeader("from") String from, @RequestHeader("to")String to){
        SessionPatientCountDto summary = medicalCenterStatisticsService.getAllTimeTotalPatientsSessionsOfAllConsultantsByDate(from,to);
        return successRetrieval(summary);
    }

    @GetMapping("/consultant/all/pricing/summary")
    public ResponseEntity getPricingSummaryOfAllConsultantByDate(@RequestHeader("from") String from, @RequestHeader("to")String to){
        ConsultatantPricingSummaryDto summary = medicalCenterStatisticsService.getPricingSummaryOfAllConsultantByDate(from,to);
        return successRetrieval(summary);
    }

    @GetMapping("/consultant/all/session/comparision")
    public ResponseEntity getSessionComparisonByDate(@RequestHeader("from") String from, @RequestHeader("to")String to, @RequestHeader("type") String type){
        List<TimeCountDto> timeCount = medicalCenterStatisticsService.getSessionComparisonByDate(type,from,to);
        return successRetrieval(timeCount);
    }

    @GetMapping("/consultant/all/leaderboard")
    public ResponseEntity getConsultantLeaderboardByDate(@RequestHeader("from") String from, @RequestHeader("to")String to){
        List<ConsultantLeaderBoardDto> leaderboard = medicalCenterStatisticsService.getConsultantLeaderboardByDate(from,to);
        return successRetrieval(leaderboard);
    }



}
