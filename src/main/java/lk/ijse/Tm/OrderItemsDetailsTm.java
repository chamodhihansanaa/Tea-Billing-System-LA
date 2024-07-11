package lk.ijse.Tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderItemsDetailsTm {
    private String OR_ID;
    private String I_ID;
    private int Date;
    public OrderItemsDetailsTm() {
    }

    public OrderItemsDetailsTm(String or_id, String i_ID, int date) {
        this.OR_ID = or_id;
        this.I_ID = i_ID;
        this.Date = date;

    }


    public String getOR_ID() {
        return OR_ID;
    }

    public void setOR_ID(String or_id) {this.OR_ID = or_id;
    }

    public String getI_ID() {
        return I_ID;
    }

    public void setI_ID(String i_ID) {
        this.I_ID = i_ID;
    }

    public int getDate() {
        return Date;
    }

    public void setDate(int date) {
        this.Date= date;
    }



    @Override
    public String toString() {
        return "OrderItemDetailsTm{" +
                "or_id='" + OR_ID + '\'' +
                ", i_ID='" + I_ID + '\'' +
                ", date=" + Date +
                '}';
    }
}







