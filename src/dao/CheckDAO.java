package dao;

import entity.Check;
import entity.Drag;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CheckDAO {
    public List<Check> findByPatient(int pt_id){
        List<Check> checks = new ArrayList<Check>();
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select * from check1 where pt_id=" + pt_id;

            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String category = rs.getString("category");
                Float price = rs.getFloat("price");
                int count = rs.getInt("count");
                Check check = new Check(id,name,category,price,count,pt_id);
                checks.add(check);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return checks;
    }
    public void deleteByPatient(int pt_id){
        String sql = "delete from check1 where pt_id=?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, pt_id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
