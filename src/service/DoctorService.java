package service;

import dao.DoctorDAO;
import entity.Doctor;

public class DoctorService {
    DoctorDAO doctorDAO = new DoctorDAO();
    public String getName(int id){
        Doctor doctor = doctorDAO.get(id);
        return doctor.getName();
    }

}
