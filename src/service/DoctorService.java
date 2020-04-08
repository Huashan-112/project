package service;

import dao.DoctorDAO;
import entity.Doctor;

public class DoctorService {
    DoctorDAO doctorDAO = new DoctorDAO();
    public Doctor get(int id){
        Doctor doctor = doctorDAO.get(id);
        return doctor;
    }

    public int getId(String name){
        return  doctorDAO.get(name).getId();
    }

}
