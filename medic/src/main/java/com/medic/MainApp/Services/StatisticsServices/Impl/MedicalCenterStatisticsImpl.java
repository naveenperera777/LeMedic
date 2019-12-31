package com.medic.MainApp.Services.StatisticsServices.Impl;
import com.medic.MainApp.DAO.StatisticsDAO.MedicalCenterStatisticsDAO;
import com.medic.MainApp.DTO.ConsultatantPricingSummaryDto;
import com.medic.MainApp.DTO.SessionPatientCountDto;
import com.medic.MainApp.DTO.TimeCountDto;
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
        List<Pricing> pricingList;
        if (from.equals("0")&& to.equals("0"))
            pricingList = medicalCenterStatisticsDAO.getAllTimePricingSummaryOfAConsultant(consultantId);
        else {
           pricingList = medicalCenterStatisticsDAO.getPricingSummaryOfAConsultantByDate(consultantId, from, to);
        }

      return calculateSummary(pricingList);
    }

    @Override
    public SessionPatientCountDto getTotalPatientsSessionsOfAConsultantByDate(String consultantId, String from, String to) {
        SessionPatientCountDto count;
        if (from.equals("0")&& to.equals("0")){
            count = medicalCenterStatisticsDAO.getAllTimeTotalPatientsSessionsOfAConsultant(consultantId);
        } else {
            count = medicalCenterStatisticsDAO.getTotalPatientsSessionsOfAConsultantByDate(consultantId, from, to);
        }
       return count;
    }

    @Override
    public SessionPatientCountDto getAllTimeTotalPatientsSessionsOfAllConsultantsByDate(String from, String to) {
        SessionPatientCountDto count;
        if (from.equals("0")&& to.equals("0")){
            count = medicalCenterStatisticsDAO.getAllTimeTotalPatientsSessionsOfAllConsultants();
        } else {
            count = medicalCenterStatisticsDAO.getTotalPatientsSessionsOfAllConsultantByDate(from,to);
        }
        return count;
    }

    @Override
    public ConsultatantPricingSummaryDto getPricingSummaryOfAllConsultantByDate(String from, String to) {
        List<Pricing> pricingList;
        if (from.equals("0")&& to.equals("0"))
            pricingList = medicalCenterStatisticsDAO.getAllTimePricingSummaryOfAllConsultant();
        else {
            pricingList = medicalCenterStatisticsDAO.getPricingSummaryOfAllConsultantByDate(from, to);
        }
        return calculateSummary(pricingList);

    }

    @Override
    public List<TimeCountDto> getSessionComparisonByDate(String type, String from, String to) {
       return medicalCenterStatisticsDAO.getSessionComparisonByDate(type,from,to);
    }

    public ConsultatantPricingSummaryDto calculateSummary(List<Pricing> pricingList){
        double consultationFees = 0.0;
        double medicationFees = 0.0;
        double miscellaneous= 0.0;
        double total= 0.0;
        for (Pricing item : pricingList){
            consultationFees += item.getConsultationFees();
            medicationFees += item.getMedicationFees();
            miscellaneous += item.getMiscellaneous();
        }
        total = consultationFees + medicationFees + miscellaneous;
        ConsultatantPricingSummaryDto dto = new ConsultatantPricingSummaryDto();
        dto.setTotalConsultationFees(consultationFees);
        dto.setTotalMedicationFees(medicationFees);
        dto.setTotalMiscellaneous(miscellaneous);
        dto.setTotal(total);
        return dto;
    }
}
