package service;

import dao.RoomDAO;
import entity.Room;

public class RoomService {
    RoomDAO roomDAO = new RoomDAO();
    public Room get(int id){
        return  roomDAO.get(id);
    }
}
