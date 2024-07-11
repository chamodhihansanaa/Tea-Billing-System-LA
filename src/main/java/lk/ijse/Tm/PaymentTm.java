package lk.ijse.Tm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentTm {
    private  String Payment_ID;
    private  String Payment_method;
    private  String Address;

    public PaymentTm() {
    }

    public PaymentTm(String payment_id, String payment_method, String address) {
        this.Payment_ID = payment_id;
        this.Payment_method = payment_method;
        this.Address = address;

    }

    public String getId() {

        return Payment_ID;
    }

    public void setId(String id) {

        this.Payment_ID = id;
    }

    public String getPayment_method() {

        return Payment_method;
    }

    public void setPayment_method(String payment_method) {

        this.Payment_method = payment_method;
    }

    public String getAddress() {

        return Address;
    }

    public void setAddress(String address) {

        this.Address = address;
    }



    @Override
    public String toString() {
        return "PaymentTm{" +
                "payment_id='" + Payment_ID + '\'' +
                ", payment_method='" + Payment_method + '\'' +
                ", address='" + Address + '\'' +

                '}';
    }
}












