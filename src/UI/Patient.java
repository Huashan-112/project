package UI;

import javafx.beans.property.SimpleStringProperty;

public class Patient {

    private SimpleStringProperty card;
    private SimpleStringProperty name;
    private SimpleStringProperty sex;
    private SimpleStringProperty age;
    private SimpleStringProperty diagnosis;
    private SimpleStringProperty department;
    private SimpleStringProperty ward;
    private SimpleStringProperty bed;
    private SimpleStringProperty inTime;
    private SimpleStringProperty outTime;
    private SimpleStringProperty phone;
    private SimpleStringProperty ID;

    public Patient(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11, String s12) {
        card = new SimpleStringProperty();
        name = new SimpleStringProperty();
        sex = new SimpleStringProperty();
        age = new SimpleStringProperty();
        diagnosis = new SimpleStringProperty();
        department = new SimpleStringProperty();
        ward = new SimpleStringProperty();
        bed = new SimpleStringProperty();
        inTime = new SimpleStringProperty();
        outTime = new SimpleStringProperty();
        phone = new SimpleStringProperty();
        ID = new SimpleStringProperty();
        card.set(s1);
        name.set(s2);
        sex.set(s3);
        age.set(s4);
        diagnosis.set(s5);
        department.set(s6);
        ward.set(s7);
        ward.set(s8);
        bed.set(s9);
        inTime.set(s10);
        outTime.set(s11);
        phone.set(s11);
        ID.set(s12);
    }

    public String getCard() {
        return card.get();
    }

    public SimpleStringProperty cardProperty() {
        return card;
    }

    public void setCard(String card) {
        this.card.set(card);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSex() {
        return sex.get();
    }

    public SimpleStringProperty sexProperty() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex.set(sex);
    }

    public String getAge() {
        return age.get();
    }

    public SimpleStringProperty ageProperty() {
        return age;
    }

    public void setAge(String age) {
        this.age.set(age);
    }

    public String getDiagnosis() {
        return diagnosis.get();
    }

    public SimpleStringProperty diagnosisProperty() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis.set(diagnosis);
    }

    public String getDepartment() {
        return department.get();
    }

    public SimpleStringProperty departmentProperty() {
        return department;
    }

    public void setDepartment(String department) {
        this.department.set(department);
    }

    public String getWard() {
        return ward.get();
    }

    public SimpleStringProperty wardProperty() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward.set(ward);
    }

    public String getBed() {
        return bed.get();
    }

    public SimpleStringProperty bedProperty() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed.set(bed);
    }

    public String getInTime() {
        return inTime.get();
    }

    public SimpleStringProperty inTimeProperty() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime.set(inTime);
    }

    public String getOutTime() {
        return outTime.get();
    }

    public SimpleStringProperty outTimeProperty() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime.set(outTime);
    }

    public String getPhone() {
        return phone.get();
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getID() {
        return ID.get();
    }

    public SimpleStringProperty IDProperty() {
        return ID;
    }

    public void setID(String ID) {
        this.ID.set(ID);
    }
}
