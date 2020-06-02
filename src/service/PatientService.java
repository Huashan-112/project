package service;

import dao.PatientDAO;
import entity.Patient;

import java.util.List;

public class PatientService {
    PatientDAO patientDAO = new PatientDAO();
    CheckService checkService = new CheckService();
    DragService dragService = new DragService();
    RoomService roomService = new RoomService();

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
        Patient patient = get(id);
        checkService.deleteByPatient(id);
        dragService.deleteByPatient(id);
        patientDAO.delete(id);
        roomService.delete(patient.getRoom_id());

    }

    public void update(Patient patient){
        patientDAO.update(patient);
    }
}
