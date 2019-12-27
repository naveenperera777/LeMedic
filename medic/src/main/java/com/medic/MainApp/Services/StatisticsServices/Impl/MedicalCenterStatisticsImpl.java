package com.medic.MainApp.Services.StatisticsServices.Impl;
import com.medic.MainApp.DAO.StatisticsDAO.MedicalCenterStatisticsDAO;
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
}
