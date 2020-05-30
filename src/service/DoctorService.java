package service;

import dao.DoctorDAO;
import entity.Doctor;

public class DoctorService {
    DoctorDAO doctorDAO = new DoctorDAO();

    public Doctor get(int id) {
        Doctor doctor = doctorDAO.get(id);
        return doctor;
    }

    public int getId(String name) {
        int rs;
        if (doctorDAO.get(name) == null) {
            rs = 0;
        } else {
            rs = doctorDAO.get(name).getId();
        }
        return rs;
    }

}
