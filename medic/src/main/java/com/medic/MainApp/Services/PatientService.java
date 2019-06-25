package com.medic.MainApp.Services;

import com.medic.MainApp.DAO.PatientDAO;
import com.medic.MainApp.Models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientDAO patientDAO;

      public List<Patient> getAllPatients(){
        return patientDAO.getAllPatients();
    }

    public void addPatient(Patient patient){
          patientDAO.addPatient(patient);
    }

    public void updatePatient(Patient patient){
          patientDAO.updatePatient(patient);
    }

    public void deletePatient(String id){
           patientDAO.deletePatient(id);
    }

    public List<Patient> getPatientById(String id){
        return  patientDAO.getPatientById(id);
    }
}
