package com.medic.MainApp.DTO;

public class ConsultatantPricingSummaryDto {
    private double totalConsultationFees;
    private double totalMedicationFees;
    private double totalMiscellaneous;
    private double total;

    public double getTotalConsultationFees() {
        return totalConsultationFees;
    }

    public void setTotalConsultationFees(double totalConsultationFees) {
        this.totalConsultationFees = totalConsultationFees;
    }

    public double getTotalMedicationFees() {
        return totalMedicationFees;
    }

    public void setTotalMedicationFees(double totalMedicationFees) {
        this.totalMedicationFees = totalMedicationFees;
    }

    public double getTotalMiscellaneous() {
        return totalMiscellaneous;
    }

    public void setTotalMiscellaneous(double totalMiscellaneous) {
        this.totalMiscellaneous = totalMiscellaneous;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


}
