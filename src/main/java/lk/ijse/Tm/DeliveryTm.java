package lk.ijse.Tm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeliveryTm {
    private  String Code;
    private  String Price;
    private  String Date;
    private  String Address;
    public DeliveryTm() {
    }

    public DeliveryTm(String code, String price, String date, String address) {
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
        return "DeliveryTm{" +
                "code='" + Code + '\'' +
                ", price='" + Price + '\'' +
                ", date='" + Date + '\'' +
                ", address='" + Address + '\'' +
                '}';
    }
}













