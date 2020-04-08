package service;

import dao.RoomDAO;
import entity.Room;

import java.sql.Date;


public class RoomService {
    RoomDAO roomDAO = new RoomDAO();
    public Room get(int id){
        return  roomDAO.get(id);
    }

    public int add(int ward_id, int bed_id, String dept_name, Date in_time){
        Room room = new Room();
        room.setWard_id(ward_id);
        room.setBed_id(bed_id);
        room.setDept_name(dept_name);
        room.setIn_time(in_time);
        return roomDAO.add(room);
    }

    public void update(Room room){
        roomDAO.update(room);
    }
}
