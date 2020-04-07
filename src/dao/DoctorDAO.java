package dao;

import entity.Doctor;
import entity.Patient;
import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DoctorDAO {
    public Doctor get(int id){
        Doctor doctor = null;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select * from doctor where id =" +id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                String name = rs.getString("name");
                String job = rs.getString("job");
                int age = rs.getInt("age");
                String dept_name = rs.getString("dept_name");
                doctor = new Doctor(id,name,job,age,dept_name);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return doctor;
    }
}
