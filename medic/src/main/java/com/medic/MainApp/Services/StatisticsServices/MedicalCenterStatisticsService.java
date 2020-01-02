package com.medic.MainApp.Services.StatisticsServices;

import com.medic.MainApp.DTO.ConsultantLeaderBoardDto;
import com.medic.MainApp.DTO.ConsultatantPricingSummaryDto;
import com.medic.MainApp.DTO.SessionPatientCountDto;
import com.medic.MainApp.DTO.TimeCountDto;
import com.medic.MainApp.Models.ConsultationModels.Pricing;

import java.util.List;

public interface MedicalCenterStatisticsService {
    List<Pricing> getAllReceiptsOfAConsultant(String consultantId);
    ConsultatantPricingSummaryDto getPricingSummaryOfAConsultantByDate(String consultantId, String from, String to);
    SessionPatientCountDto getTotalPatientsSessionsOfAConsultantByDate(String consultantId, String from, String to);
    SessionPatientCountDto getAllTimeTotalPatientsSessionsOfAllConsultantsByDate(String from, String to);
    ConsultatantPricingSummaryDto getPricingSummaryOfAllConsultantByDate(String from, String to);
    List<TimeCountDto> getSessionComparisonByDate(String type, String from, String to);
    List<ConsultantLeaderBoardDto> getConsultantLeaderboardByDate(String from, String to);
    int getTotalConsultants();
}
