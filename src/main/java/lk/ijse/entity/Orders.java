package lk.ijse.entity;

public class Orders {
    private  String OR_ID;
    private  String Date;
    private  String Address;
    private  String Quantity;
    public Orders() {
    }

    public Orders(String or_id, String date, String address, String quantity) {
        this.OR_ID = or_id;
        this.Date = date;
        this.Address = address;
        this.Quantity = quantity;
    }

    public String getId() {

        return OR_ID;
    }

    public void setId(String id) {

        this.OR_ID = id;
    }

    public String getDate() {

        return Date;
    }

    public void setDate(String date) {

        this.Date = date;
    }

    public String getAddress() {

        return Address;
    }

    public void setAddress(String address) {

        this.Address = address;
    }

    public String getQuantity() {

        return Quantity;
    }

    public void setQuantity(String quantity) {

        this.Quantity = quantity;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "or_id='" + OR_ID + '\'' +
                ", date='" + Date + '\'' +
                ", address='" + Address + '\'' +
                ", quantity='" + Quantity + '\'' +
                '}';
    }
}









