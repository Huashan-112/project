package entity;

public class Department {
    String name;
    String address;
    String phone_number;
    int doc_id;

    public Department( String name, String address, String phone_number, int doc_id) {
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
        this.doc_id = doc_id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(int doc_id) {
        this.doc_id = doc_id;
    }
}
