package lk.ijse.model;

import java.io.Serializable;

public class TeaTypeDTO implements Serializable {
    private  String Tea_ID;
    private  String Price;
    private  String Tea_Category;
    public TeaTypeDTO() {

    }

    public TeaTypeDTO(String tea_id, String price, String tea_Category) {
        this.Tea_ID = tea_id;
        this.Price = price;
        this.Tea_Category = tea_Category;

    }

    public String getId() {

        return Tea_ID;
    }

    public void setId(String id) {

        this.Tea_ID = id;
    }

    public String getPrice() {

        return Price;
    }

    public void setPrice(String price) {

        this.Price = price;
    }

    public String getTea_Category() {

        return Tea_Category;
    }

    public void setTea_Category(String tea_Category) {

        this.Tea_Category = tea_Category;
    }



    @Override
    public String toString() {
        return "TeaTypeDTO{" +
                "tea_id='" + Tea_ID + '\'' +
                ", price='" + Price + '\'' +
                ", tea_category='" + Tea_Category + '\'' +

                '}';
    }
}










