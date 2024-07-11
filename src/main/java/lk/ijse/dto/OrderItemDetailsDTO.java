package lk.ijse.dto;

import java.io.Serializable;

public class OrderItemDetailsDTO implements Serializable {
    private String OR_ID;
    private String I_ID;
    private String Date;


    public OrderItemDetailsDTO() {
    }

    public OrderItemDetailsDTO(String or_id, String i_ID, String date) {
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

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date= date;
    }



    @Override
    public String toString() {
        return "OrderItemDetailsDTO{" +
                "or_id='" + OR_ID + '\'' +
                ", i_ID='" + I_ID + '\'' +
                ", date=" + Date +
                '}';
    }
}



