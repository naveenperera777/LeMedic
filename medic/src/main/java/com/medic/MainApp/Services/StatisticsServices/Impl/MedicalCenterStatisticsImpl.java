package com.medic.MainApp.Services.StatisticsServices.Impl;
import com.medic.MainApp.DAO.StatisticsDAO.MedicalCenterStatisticsDAO;
import com.medic.MainApp.DTO.ConsultatantPricingSummaryDto;
import com.medic.MainApp.Models.ConsultationModels.Pricing;
import com.medic.MainApp.Services.StatisticsServices.MedicalCenterStatisticsService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MedicalCenterStatisticsImpl implements MedicalCenterStatisticsService {
    private final MedicalCenterStatisticsDAO medicalCenterStatisticsDAO;

    public MedicalCenterStatisticsImpl(MedicalCenterStatisticsDAO medicalCenterStatisticsDAO) {
        this.medicalCenterStatisticsDAO = medicalCenterStatisticsDAO;
    }

    @Override
    public List<Pricing> getAllReceiptsOfAConsultant(String consultantId) {
        return medicalCenterStatisticsDAO.getAllReceiptsOfAConsultant(consultantId);
    }

    @Override
    public ConsultatantPricingSummaryDto getPricingSummaryOfAConsultantByDate(String consultantId, String from, String to) {
        List<Pricing> pricingList =  medicalCenterStatisticsDAO.getPricingSummaryOfAConsultantByDate(consultantId,from,to);
        double consultationFees = 0.0;
        double medicationFees = 0.0;
        double miscellaneous= 0.0;
        double total= 0.0;
        for (Pricing item : pricingList){
            consultationFees += item.getConsultationFees();
            medicationFees += item.getMedicationFees();
            miscellaneous += item.getMiscellaneous();
            total += item.getTotal();
        }
        ConsultatantPricingSummaryDto dto = new ConsultatantPricingSummaryDto();
        dto.setTotalConsultationFees(consultationFees);
        dto.setTotalMedicationFees(medicationFees);
        dto.setTotalMiscellaneous(miscellaneous);
        dto.setTotal(total);

        return dto;
    }
}
