package com.medic.MainApp.Services.ConsultationServices;

import com.medic.MainApp.DAO.ConsultationDAO.DiagnosisDAO;
import com.medic.MainApp.Models.ConsultationModels.Diagnosis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DiagnosisService {
    private final DiagnosisDAO diagnosisDAO;
    private static final Logger logger = LoggerFactory.getLogger(SessionService.class);

    public DiagnosisService(DiagnosisDAO diagnosisDAO){
        this.diagnosisDAO = diagnosisDAO;
    }

    public void setDiagnosis(Diagnosis diagnosis){
        diagnosisDAO.setDiagnosis(diagnosis);
    }
}
