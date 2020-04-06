package service;

import dao.PatientDAO;
import entity.Patient;

public class PatientService {
    PatientDAO patientDAO = new PatientDAO();

    public Patient get(int id){
        return patientDAO.get(id);
    }

    public void add(Patient patient){
        patientDAO.add(patient);
    }
}
