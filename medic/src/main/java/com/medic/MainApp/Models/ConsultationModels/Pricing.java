package com.medic.MainApp.Models.ConsultationModels;

public class Pricing {
    private double consultationFees;
    private double medicationFees;
    private  double tax;
    private double miscellaneous;
    private double total;

//    public Pricing(double consultationFees, double medicationFees, double tax, double miscellaneous, double total) {
//        this.consultationFees = consultationFees;
//        this.medicationFees = medicationFees;
//        this.tax = tax;
//        this.miscellaneous = miscellaneous;
//        this.total = total;
//    }

    public double getConsultationFees() {
        return consultationFees;
    }

    public void setConsultationFees(double consultationFees) {
        this.consultationFees = consultationFees;
    }

    public double getMedicationFees() {
        return medicationFees;
    }

    public void setMedicationFees(double medicationFees) {
        this.medicationFees = medicationFees;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getMiscellaneous() {
        return miscellaneous;
    }

    public void setMiscellaneous(double miscellaneous) {
        this.miscellaneous = miscellaneous;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
