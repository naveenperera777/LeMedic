package com.medic.MainApp.Models.ConsultationModels;

import java.sql.Timestamp;

public class Medication {
    private int session_id;
    private String medical_management;
    private String surgical_management;
    private Timestamp next_date;
    private String remarks;

    public int getSession_id() {
        return session_id;
    }

    public void setSession_id(int session_id) {
        this.session_id = session_id;
    }

    public String getMedical_management() {
        return medical_management;
    }

    public void setMedical_management(String medical_management) {
        this.medical_management = medical_management;
    }

    public String getSurgical_management() {
        return surgical_management;
    }

    public void setSurgical_management(String surgical_management) {
        this.surgical_management = surgical_management;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    public Timestamp getNext_date() {
        return next_date;
    }

    public void setNext_date(Timestamp next_date) {
        this.next_date = next_date;
    }



}
