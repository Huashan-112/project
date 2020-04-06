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
    private SimpleStringProperty medicine;
    private SimpleStringProperty check;
    private SimpleStringProperty doctor;

    public Patient() {
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
        medicine = new SimpleStringProperty();
        check = new SimpleStringProperty();
        doctor = new SimpleStringProperty();
    }

    public Patient(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11, String s12, String s13, String s14, String s15) {
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
        medicine = new SimpleStringProperty();
        check = new SimpleStringProperty();
        doctor = new SimpleStringProperty();
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
        medicine.set(s13);
        check.set(s14);
        doctor.set(s15);
    }

    public Patient madeBean(String[] s1) {
        Patient patient = new Patient(s1[0], s1[1], s1[2], s1[3], s1[4], s1[5], s1[6], s1[7], s1[8], s1[9], s1[10], s1[11], s1[12], s1[13], s1[14]);
        return patient;
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

    public String getMedicine() {
        return medicine.get();
    }

    public SimpleStringProperty medicineProperty() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine.set(medicine);
    }

    public String getCheck() {
        return check.get();
    }

    public SimpleStringProperty checkProperty() {
        return check;
    }

    public void setCheck(String check) {
        this.check.set(check);
    }

}
