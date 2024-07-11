package lk.ijse.Tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CollectEmpDetailsTm {
    private String Collect_ID;
    private String Emp_ID;
    private String Date;
    public CollectEmpDetailsTm() {
    }

    public CollectEmpDetailsTm(String collect_ID, String emp_id, String date) {
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

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date= date;
    }



    @Override
    public String toString() {
        return "CollectEmpDetailsTm{" +
                "collect_ID='" + Collect_ID + '\'' +
                ", emp_id='" + Emp_ID + '\'' +
                ", date=" + Date +
                '}';
    }
}









