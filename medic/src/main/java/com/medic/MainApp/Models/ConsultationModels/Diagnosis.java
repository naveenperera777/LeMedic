package com.medic.MainApp.Models.ConsultationModels;

public class Diagnosis {

    private int session_id;
    private String complain;
    private String signs;
    private String general_exam;
    private String system_exam;
    private String investigation;

    public int getSession_id() {
        return session_id;
    }

    public void setSession_id(int session_id) {
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


}
