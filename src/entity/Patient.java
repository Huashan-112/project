package entity;

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
