package lk.ijse.entity;
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
}
