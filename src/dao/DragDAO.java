package dao;

import entity.Drag;
import entity.Patient;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DragDAO {

    public List<Drag> findByPatient(int pt_id) {

        List<Drag> drags = new ArrayList<Drag>();

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select * from drag where pt_id=" + pt_id;

            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String category = rs.getString("category");
                Float price = rs.getFloat("price");
                int count = rs.getInt("count");
                Drag drag = new Drag(id, name, category, price, count, pt_id);
                drags.add(drag);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return drags;
    }

    public void deleteByPatient(int pt_id){
        String sql = "delete from drag where pt_id=?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, pt_id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
