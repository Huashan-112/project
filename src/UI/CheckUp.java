package UI;

import javafx.beans.property.SimpleStringProperty;

public class CheckUp {
    private SimpleStringProperty indexes;
    private SimpleStringProperty name;
    private SimpleStringProperty num;
    private SimpleStringProperty price;
    private SimpleStringProperty total_price;

    public CheckUp() {
        indexes = new SimpleStringProperty();
        name = new SimpleStringProperty();
        num = new SimpleStringProperty();
        price = new SimpleStringProperty();
        total_price = new SimpleStringProperty();
    }

    public CheckUp(String s1, String s2, String s3, String s4, String s5) {
        indexes = new SimpleStringProperty();
        name = new SimpleStringProperty();
        num = new SimpleStringProperty();
        price = new SimpleStringProperty();
        total_price = new SimpleStringProperty();
        indexes.set(s1);
        name.set(s2);
        num.set(s3);
        price.set(s4);
        total_price.set(s5);
    }

    public CheckUp madeBean(String[] s1) {
        CheckUp checkUp = new CheckUp(s1[0], s1[1], s1[2], s1[3], s1[4]);
        return checkUp;
    }

    public String getIndexes() {
        return indexes.get();
    }

    public SimpleStringProperty indexesProperty() {
        return indexes;
    }

    public void setIndexes(String indexes) {
        this.indexes.set(indexes);
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

    public String getNum() {
        return num.get();
    }

    public SimpleStringProperty numProperty() {
        return num;
    }

    public void setNum(String num) {
        this.num.set(num);
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getTotal_price() {
        return total_price.get();
    }

    public SimpleStringProperty total_priceProperty() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price.set(total_price);
    }
}
