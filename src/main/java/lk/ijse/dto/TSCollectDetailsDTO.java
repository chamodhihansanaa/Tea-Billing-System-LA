package lk.ijse.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class TSCollectDetailsDTO implements Serializable {
    private String Collect_ID;
    private String TS_ID;
    private String Amount_of_the_tea;


    public TSCollectDetailsDTO() {
    }

    public TSCollectDetailsDTO(String collect_ID, String ts_id, String amount_of_the_tea) {
        this.Collect_ID = collect_ID;
        this.TS_ID = ts_id;
        this.Amount_of_the_tea = amount_of_the_tea;

    }


    public String getCollect_ID() {
        return Collect_ID;
    }

    public void setCollect_ID(String collect_ID) {this.Collect_ID = collect_ID;
    }

    public String getTS_ID() {
        return TS_ID;
    }

    public void setTS_ID(String ts_id) {
        this.TS_ID = ts_id;
    }

    public String getAmount_of_the_tea() {
        return Amount_of_the_tea;
    }

    public void setAmount_of_the_tea(String amount_of_the_tea) {
        this.Amount_of_the_tea= amount_of_the_tea;
    }



    @Override
    public String toString() {
        return "TSCollectDetailsDTO{" +
                "collect_ID='" + Collect_ID + '\'' +
                ", ts_id='" + TS_ID + '\'' +
                ", amount_of_the_tea=" + Amount_of_the_tea +
                '}';
    }
}

