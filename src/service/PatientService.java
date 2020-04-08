package service;

import dao.PatientDAO;
import entity.Patient;

import java.util.List;

public class PatientService {
    PatientDAO patientDAO = new PatientDAO();

    public Patient get(int id){
        return patientDAO.get(id);
    }

    public void add(Patient patient){
        patientDAO.add(patient);
    }

    public List<Patient> list(){
        return patientDAO.list();
    }

    public void delete(int id){
        patientDAO.delete(id);
    }

    public void update(Patient patient){
        patientDAO.update(patient);
    }
}
