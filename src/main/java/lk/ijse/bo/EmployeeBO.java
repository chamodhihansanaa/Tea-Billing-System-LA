package lk.ijse.bo;

import lk.ijse.dto.EmployeeDTO;
import lk.ijse.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBO extends SuperBO{

     boolean update(Employee employee) ;

     boolean save(Employee employee) ;

     boolean delete(String empId) ;

    static Employee searchByEMP_ID(String id) ;

    Employee searchByEMP_ID(String id);

    ArrayList<EmployeeDTO> getAllEmployee() throws SQLException, ClassNotFoundException;

    boolean saveEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException;

    boolean clearEmployee(String id) throws SQLException, ClassNotFoundException;

    boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException;

    String generateNewEmployeeID() throws SQLException, ClassNotFoundException;
}
