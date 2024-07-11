package lk.ijse.entity;

public class Payment {
    private  String Payment_ID;
    private  String Payment_method;
    private  String Address;
    public Payment() {
    }

    public Payment(String payment_id, String payment_method, String address) {
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
        return "Payment{" +
                "payment_id='" + Payment_ID + '\'' +
                ", payment_method='" + Payment_method + '\'' +
                ", address='" + Address + '\'' +

                '}';
    }
}









