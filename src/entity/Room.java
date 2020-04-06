package entity;

import service.DepartmentService;

import java.util.Date;

public class Room {
    int id;
    int ward_id;
    int bed_id;
    int dept_id;
    Date in_time;
    Date out_time;

    //不存进数据库中
    String dept_name;

    public Room(int id, int ward_id, int bed_id, int dept_id, Date in_time, Date out_time) {
        this.id = id;
        this.ward_id = ward_id;
        this.bed_id = bed_id;
        this.dept_id = dept_id;
        this.in_time = in_time;
        this.out_time = out_time;
        dept_name = new DepartmentService().getName(dept_id);
    }

    public String getDept_name() {
        return dept_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
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
}
