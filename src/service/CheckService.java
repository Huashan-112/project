package service;

import dao.CheckDAO;
import entity.Check;

import java.util.List;

public class CheckService {
    CheckDAO checkDAO = new CheckDAO();

    public List<Check> listByPatientId(int pt_id){
        return checkDAO.findByPatient(pt_id);
    }

    public void deleteByPatient(int pt_id){
        checkDAO.deleteByPatient(pt_id);
    }
    public void add(Check check){checkDAO.add(check);}
}
