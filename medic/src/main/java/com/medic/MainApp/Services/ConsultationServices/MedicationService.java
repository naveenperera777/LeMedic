package com.medic.MainApp.Services.ConsultationServices;

import com.medic.MainApp.DAO.ConsultationDAO.MedicationDAO;
import com.medic.MainApp.Models.ConsultationModels.Medication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MedicationService {


    private final MedicationDAO medicationDAO;
    private static final Logger logger = LoggerFactory.getLogger(MedicationService.class);

    public MedicationService(MedicationDAO medicationDAO){
        this.medicationDAO = medicationDAO;
    }

    public void setMedication(Medication medication){
        medicationDAO.setMedication(medication);
    }
}
