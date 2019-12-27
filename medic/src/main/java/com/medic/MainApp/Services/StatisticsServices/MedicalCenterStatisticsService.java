package com.medic.MainApp.Services.StatisticsServices;

import com.medic.MainApp.DTO.ConsultatantPricingSummaryDto;
import com.medic.MainApp.Models.ConsultationModels.Pricing;

import java.util.List;

public interface MedicalCenterStatisticsService {
    List<Pricing> getAllReceiptsOfAConsultant(String consultantId);
    ConsultatantPricingSummaryDto getPricingSummaryOfAConsultantByDate(String consultantId, String from, String to);
}
