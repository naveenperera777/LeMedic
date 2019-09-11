package com.medic.MainApp.Models;

public class PatientRecord {

    private String patient_id;
    private String consultant_id;
    private String symptoms;
    private String medications;


    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getConsultant_id() {
        return consultant_id;
    }

    public void setConsultant_id(String consultant_id) {
        this.consultant_id = consultant_id;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getMedications() {
        return medications;
    }

    public void setMedications(String medications) {
        this.medications = medications;
    }



}
