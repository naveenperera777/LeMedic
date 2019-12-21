package com.medic.MainApp.Services.StatisticsServices.Impl;

import com.medic.MainApp.DAO.PatientRecordDAO;
import com.medic.MainApp.DAO.StatisticsDAO.PatientStatisticsDAO;
import com.medic.MainApp.DTO.AreaDiseaseDistributionDto;
import com.medic.MainApp.DTO.PatientsByAreaDto;
import com.medic.MainApp.DTO.PatientsByDiseaseDto;
import com.medic.MainApp.DTO.PatientsByGenderDto;
import com.medic.MainApp.DataMapper.StatisticsDataMapper.GenderDataMapper;
import com.medic.MainApp.Services.StatisticsServices.PatientStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientStatisticsServiceImpl implements PatientStatisticsService {

    private final PatientStatisticsDAO patientStatisticsDAO;

    PatientStatisticsServiceImpl(PatientStatisticsDAO patientStatisticsDAO){
        this.patientStatisticsDAO = patientStatisticsDAO;
    }

    public int getAllPatientCount(){
        return patientStatisticsDAO.getAllPatientCount();
    }

    @Override
    public List getDiseaseList() {
        return patientStatisticsDAO.getDiseaseList();
    }

    @Override
    public List<PatientsByGenderDto> getPatientCountByGender() {
        return patientStatisticsDAO.getPatientCountByGender();
    }

    @Override
    public List<PatientsByDiseaseDto> getPatientCountByDisease() {
        return patientStatisticsDAO.getPatientCountByDisease();
    }

    @Override
    public List getPatientCountByArea() {
        return patientStatisticsDAO.getPatientCountByArea();
    }

    @Override
    public List<AreaDiseaseDistributionDto> getDiseaseDistributionOfAnArea(String district) {
        return  patientStatisticsDAO.getDiseaseDistributionOfAnArea(district);
    }

    @Override
    public List<AreaDiseaseDistributionDto> getAreaDistributionOfADisease(String disease) {
        return patientStatisticsDAO.getAreaDistributionOfADisease(disease);
    }

}
