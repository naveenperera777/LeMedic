package com.medic.MainApp.Models.ConsultationModels;

import java.util.Date;

public class Session {
    private int consultant_id;
    private int patient_id;
    private Date timestamp;

    public int getConsultant_id() {
        return consultant_id;
    }

    public void setConsultant_id(int consultant_id) {
        this.consultant_id = consultant_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
