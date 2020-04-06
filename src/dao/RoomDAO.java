package dao;

import entity.Doctor;
import entity.Room;
import service.DepartmentService;
import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class RoomDAO {
    public Room get(int id){
        Room room = null;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select * from room where id =" +id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                int ward_id = rs.getInt("ward_id");
                int bed_id = rs.getInt("bed_id");
                int dept_id = rs.getInt("dept_id");
                Date in_time = rs.getDate("in_time");
                Date out_time = rs.getDate("out_time");
                room = new Room(id,ward_id,bed_id,dept_id,in_time,out_time);

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return room;
    }
}
