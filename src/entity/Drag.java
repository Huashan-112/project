package entity;

public class Drag {
    int id;
    String name;
    String category;
    Float price;
    int count;
    int pt_id;

    //不存进数据库中
    Float total_price;

    public Drag(int id, String name, String category, Float price, int count, int pt_id) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.count = count;
        this.pt_id = pt_id;
        total_price = count*price;
    }

    public Float getTotal_price() {
        return total_price;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPt_id() {
        return pt_id;
    }

    public void setPt_id(int pt_id) {
        this.pt_id = pt_id;
    }
}
