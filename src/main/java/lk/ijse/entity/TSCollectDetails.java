package lk.ijse.entity;

public class TSCollectDetails {
    private String Collect_ID;
    private String TS_ID;
    private int Amount_of_the_tea;


    public TSCollectDetails() {
    }

    public TSCollectDetails(String collect_ID, String ts_id, int amount_of_the_tea) {
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

    public int getAmount_of_the_tea() {
        return Amount_of_the_tea;
    }

    public void setAmount_of_the_tea(int amount_of_the_tea) {
        this.Amount_of_the_tea= amount_of_the_tea;
    }



    @Override
    public String toString() {
        return "TSCollectDetails{" +
                "collect_ID='" + Collect_ID + '\'' +
                ", ts_id='" + TS_ID + '\'' +
                ", amount_of_the_tea=" + Amount_of_the_tea +
                '}';
    }
}


