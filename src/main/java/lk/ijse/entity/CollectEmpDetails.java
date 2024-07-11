package lk.ijse.entity;

public class CollectEmpDetails {
    private String Collect_ID;
    private String Emp_ID;
    private int Date;


    public CollectEmpDetails() {
    }

    public CollectEmpDetails(String collect_ID, String emp_id, int date) {
        this.Collect_ID = collect_ID;
        this.Emp_ID = emp_id;
        this.Date = date;

    }


    public String getCollect_ID() {
        return Collect_ID;
    }

    public void setCollect_ID(String collect_ID) {this.Collect_ID = collect_ID;
    }

    public String getEmp_ID() {
        return Emp_ID;
    }

    public void setEmp_ID(String emp_id) {
        this.Emp_ID = emp_id;
    }

    public int getDate() {
        return Date;
    }

    public void setDate(int date) {
        this.Date= date;
    }



    @Override
    public String toString() {
        return "CollectEmpDetails{" +
                "collect_ID='" + Collect_ID + '\'' +
                ", emp_id='" + Emp_ID + '\'' +
                ", date=" + Date +
                '}';
    }
}




