package dao;

import entity.Department;
import entity.Doctor;
import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DepartmentDAO {
    public Department get(String name){
        Department department = null;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select * from department where name =" +name;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {

                String address = rs.getString("address");
                String phone_number = rs.getString("phone_number");
                int doc_id = rs.getInt("doc_id");
                department = new Department(name,address,phone_number,doc_id);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return department;
    }
}
