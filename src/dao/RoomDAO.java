package dao;

import entity.Room;
import util.DBUtil;

import java.sql.*;


public class RoomDAO {
    public Room get(int id) {
        Room room = null;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select * from room where id =" + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                int ward_id = rs.getInt("ward_id");
                int bed_id = rs.getInt("bed_id");
                String dept_name = rs.getString("dept_name");
                Date in_time = rs.getDate("in_time");
                Date out_time = rs.getDate("out_time");
                room = new Room(id, ward_id, bed_id, dept_name, in_time, out_time);

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return room;
    }

    public int add(Room room) {
        int id = 0;
        String sql = "insert into room values(null,?,?,?,?,null)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            ps.setInt(1, room.getWard_id());
            ps.setInt(2, room.getBed_id());
            ps.setString(3, room.getDept_name());
            ps.setDate(4, room.getIn_time());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
                room.setId(id);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return id;
    }

    public void update(Room room) {
        String sql = "update room set ward_id=?,bed_id=?,dept_name=?,in_time=?,out_time=? where id =?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, room.getWard_id());
            ps.setInt(2, room.getBed_id());
            ps.setString(3, room.getDept_name());
            ps.setDate(4, room.getIn_time());
            ps.setDate(5, room.getOut_time());
            ps.setInt(6, room.getId());

            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "delete from room where id=?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
