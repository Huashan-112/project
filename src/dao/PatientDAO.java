package dao;

import entity.Patient;
import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class PatientDAO {
    public Patient get(int id){
        Patient patient = null;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select * from patient where id =" +id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                int age = rs.getInt("age");
                String phone_number = rs.getString("phone_number");
                String identity_card = rs.getString("identity_card");
                int doc_id = rs.getInt("doc_id");
                int room_id = rs.getInt("room_id");
                patient = new Patient(id,name,sex,age,phone_number,identity_card,doc_id,room_id);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return patient;
    }
}
