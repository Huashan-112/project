package dao;

import entity.Patient;
import util.DBUtil;

import java.sql.*;
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
                String diagnose = rs.getString("diagnose");
                int doc_id = rs.getInt("doc_id");
                int room_id = rs.getInt("room_id");
                patient = new Patient(id,name,sex,age,phone_number,identity_card,diagnose,doc_id,room_id);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return patient;
    }

    public void add(Patient patient){
        String sql = "insert into patient values(?,?,?,?,?,?,?,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, patient.getId());
            ps.setString(2, patient.getName());
            ps.setString(3, patient.getSex());
            ps.setInt(4,patient.getAge());
            ps.setString(5,patient.getPhone_number());
            ps.setString(6,patient.getIdentity_card());
            ps.setInt(7,patient.getDoc_id());
            ps.setInt(8,patient.getRoom_id());

            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
