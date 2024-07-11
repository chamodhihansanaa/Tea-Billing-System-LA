package lk.ijse.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
    private  String EMP_ID;
    private  String  Name;
    private  String Salary;
    private  String Date;
    public EmployeeDTO() {
    }

    public EmployeeDTO(String emp_id, String name, String salary, String date) {
        this.EMP_ID = emp_id;
        this.Name = name;
        this.Salary = salary;
        this.Date = date;
    }

    public String getId() {return EMP_ID; }

    public void setId(String id) {this.EMP_ID = id; }

    public String getName() {return Name; }

    public void setName(String name) {this.Name = name; }

    public String getSalary() {return Salary; }

    public void setSalary(String salary) {this.Salary = salary; }

    public String getDate() {return Date; }

    public void setDate(String date) {this.Date = date; }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "emp_id='" + EMP_ID + '\'' +
                ", name='" + Name + '\'' +
                ", salary='" + Salary + '\'' +
                ", date='" + Date + '\'' +
                '}';
    }
}






