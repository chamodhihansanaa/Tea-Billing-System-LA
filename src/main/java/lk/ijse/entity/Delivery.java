package lk.ijse.entity;

public class Delivery {
    private  String Code;
    private  String Price;
    private  String Date;
    private  String Address;
    public Delivery() {
    }

    public Delivery(String code, String price, String date, String address) {
        this.Code = code;
        this.Price = price;
        this.Date = date;
        this.Address = address;
    }

    public String getCode() {return Code;}

    public void setCode(String code) {this.Code = code;}

    public String getPrice() {return Price;}

    public void setPrice(String price) {this.Price = price;}

    public String getDate() {return Date;}

    public void setDate(String date) {this.Address = date;}

    public String getAddress() {return Address;}

    public void setAddress(String address) {this.Address = address;}

    @Override
    public String toString() {
        return "Delivery{" +
                "code='" + Code + '\'' +
                ", price='" + Price + '\'' +
                ", date='" + Date + '\'' +
                ", address='" + Address + '\'' +
                '}';
    }
}











