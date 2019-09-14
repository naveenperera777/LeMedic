package com.medic.MainApp.Models.ConsultationModels;

public class Pricing {
    private int session_id;
    private double fees;

    public int getSession_id() {
        return session_id;
    }

    public void setSession_id(int session_id) {
        this.session_id = session_id;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }
}
