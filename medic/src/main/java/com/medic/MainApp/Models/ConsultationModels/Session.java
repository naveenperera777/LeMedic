package com.medic.MainApp.Models.ConsultationModels;

import java.util.Date;

public class Session {
    private String session_id;
    private String consultant_id;
    private String patient_id;
    private Date timestamp;


    private String complain;
    private String signs;
    private String general_exam;
    private String system_exam;
    private String investigation;

    private String medical_management;
    private String surgical_management;
    private Date next_date;
    private String remarks;

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getComplain() {
        return complain;
    }

    public void setComplain(String complain) {
        this.complain = complain;
    }

    public String getSigns() {
        return signs;
    }

    public void setSigns(String signs) {
        this.signs = signs;
    }

    public String getGeneral_exam() {
        return general_exam;
    }

    public void setGeneral_exam(String general_exam) {
        this.general_exam = general_exam;
    }

    public String getSystem_exam() {
        return system_exam;
    }

    public void setSystem_exam(String system_exam) {
        this.system_exam = system_exam;
    }

    public String getInvestigation() {
        return investigation;
    }

    public void setInvestigation(String investigation) {
        this.investigation = investigation;
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

    public Date getNext_date() {
        return next_date;
    }

    public void setNext_date(Date next_date) {
        this.next_date = next_date;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }




    public String getConsultant_id() {
        return consultant_id;
    }

    public void setConsultant_id(String consultant_id) {
        this.consultant_id = consultant_id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
