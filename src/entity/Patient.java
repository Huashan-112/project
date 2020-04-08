package entity;

import java.sql.Date;

public class Patient {
    int id;
    String name;
    String sex;
    int age;
    String phone_number;
    String identity_card;
    String diagnose;
    int doc_id;
    int room_id;

    public Patient(int id, String name, String sex, int age, String phone_number,String identity_card,String diagnose, int doc_id, int room_id) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone_number = phone_number;
        this.identity_card = identity_card;
        this.diagnose = diagnose;
        this.doc_id = doc_id;
        this.room_id = room_id;
    }

    //不存进数据库中数据
    int ward_id;
    int bed_id;
    String dept_name;
    Date in_time;
    Date out_time;
    String doc_name;

    public void setDoc_name(Doctor doctor){
        doc_name = doctor.getName();
    }

    public String getDoc_name() {
        return doc_name;
    }

    public void setRoomDetail(Room room){
        ward_id = room.getWard_id();
        bed_id = room.getBed_id();
        dept_name = room.getDept_name();
        in_time = room.getIn_time();
        out_time = room.getOut_time();
    }

    //get set
    public int getWard_id() {
        return ward_id;
    }

    public void setWard_id(int ward_id) {
        this.ward_id = ward_id;
    }

    public int getBed_id() {
        return bed_id;
    }

    public void setBed_id(int bed_id) {
        this.bed_id = bed_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public Date getIn_time() {
        return in_time;
    }

    public void setIn_time(Date in_time) {
        this.in_time = in_time;
    }

    public Date getOut_time() {
        return out_time;
    }

    public void setOut_time(Date out_time) {
        this.out_time = out_time;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getIdentity_card() {
        return identity_card;
    }

    public void setIdentity_card(String identity_card) {
        this.identity_card = identity_card;
    }

    public int getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(int doc_id) {
        this.doc_id = doc_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }
}
