package lk.ijse.dao;

import lk.ijse.dao.custom.EmployeeDAO;
import lk.ijse.entity.Collector;
import lk.ijse.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public ArrayList<Employee> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Employee> allEmployee = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM Employee");
        while (rst.next()) {
            Employee employee = new Employee(rst.getString("emp_id"), rst.getString("name"), rst.getString("salary"),rst.getString("date"));
            allEmployee.add(employee);
        }
        return allEmployee;
    }
    @Override
    public boolean delete(String emp_id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Employee WHERE emp_id=?", emp_id);
    }

    @Override
    public boolean save(Employee entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Employee (emp_id, name,salary, date) VALUES (?,?,?,?)",entity.getId(),entity.getName(),entity.getSalary(),entity.getDate());
    }

    @Override
    public boolean update(Employee entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Employee SET name=?,salary=?, date=? WHERE emp_id=?",entity.getName(),entity.getSalary(),entity.getDate(),entity.getId());
    }

    @Override
    public boolean clear(String emp_id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT emp_id FROM Employee WHERE emp_id=?", emp_id);
        return rst.next();
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT emp_id FROM Delivery ORDER BY emp_id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("emp_id");
            int newEmployeeId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newEmployeeId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public Employee search(String emp_id) throws SQLException, ClassNotFoundException {
        ResultSet rst  = SQLUtil.execute("SELECT * FROM Employee WHERE emp_id=?",emp_id+"");
        rst.next();
        return new Employee(emp_id + "", rst.getString("name"), rst.getString("salary"),rst.getString("date"));
    }



}










