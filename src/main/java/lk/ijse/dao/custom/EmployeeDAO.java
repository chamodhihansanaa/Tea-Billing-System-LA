package lk.ijse.dao.custom;

import lk.ijse.entity.Employee;

import java.sql.SQLException;

public interface EmployeeDAO extends CrudDAO<Employee>{
    boolean save(Employee entity) throws SQLException, ClassNotFoundException;
}
