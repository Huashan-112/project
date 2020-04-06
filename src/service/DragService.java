package service;

import dao.DragDAO;
import entity.Drag;

import java.util.List;

public class DragService {
    DragDAO dragDAO = new DragDAO();

    public List<Drag> listByPatientId(int pt_id){
        return  dragDAO.findByPatient(pt_id);
    }
}
