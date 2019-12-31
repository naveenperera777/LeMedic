package com.medic.MainApp.DTO;

import com.medic.MainApp.Models.ConsultationModels.Diagnosis;
import com.medic.MainApp.Models.ConsultationModels.Medication;
import com.medic.MainApp.Models.ConsultationModels.Pricing;

public class EmailDto {
    private String receiver;
    private String title;
    private Diagnosis diagnosis;
    private Medication medication;
    private Pricing pricing;

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public Pricing getPricing() {
        return pricing;
    }

    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
