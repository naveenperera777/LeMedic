package com.medic.MainApp.Services.StatisticsServices.Impl;

import com.medic.MainApp.DAO.PatientRecordDAO;
import com.medic.MainApp.DAO.StatisticsDAO.PatientStatisticsDAO;
import com.medic.MainApp.Services.StatisticsServices.PatientStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientStatisticsServiceImpl implements PatientStatisticsService {


    private final PatientStatisticsDAO patientStatisticsDAO;

    PatientStatisticsServiceImpl(PatientStatisticsDAO patientStatisticsDAO){
        this.patientStatisticsDAO = patientStatisticsDAO;
    }

    public int getAllPatientCount(){
        return patientStatisticsDAO.getAllPatientCount();
    }

}
