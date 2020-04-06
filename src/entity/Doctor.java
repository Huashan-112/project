package entity;

public class Doctor {
    int id;
    String name;
    String job;
    int age;
    String dept_name;

    public Doctor(int id,String name, String job, int age, String dept_name) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.age = age;
        this.dept_name = dept_name;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_id(String dept_name) {
        this.dept_name = dept_name;
    }
}
