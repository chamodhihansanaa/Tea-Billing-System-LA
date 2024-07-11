package lk.ijse.bo;

import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.EmployeeDAO;
import lk.ijse.dto.EmployeeDTO;
import lk.ijse.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO{
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public boolean update(Employee employee) {
        return false;
    }

    @Override
    public boolean save(Employee employee) {
        return false;
    }

    @Override
    public boolean delete(String empId) {
        return false;
    }

    @Override
    public Employee searchByEMP_ID(String id) {
        return null;
    }

    @Override
    public ArrayList<EmployeeDTO> getAllEmployee() throws SQLException, ClassNotFoundException {
        ArrayList<EmployeeDTO> allEmployee= new ArrayList<>();
        ArrayList<Employee> all = employeeDAO.getAll();
        for (Employee c : all) {
            allEmployee.add(new EmployeeDTO(c.getId(),c.getName(),c.getSalary(),c.getDate()));
        }
        return allEmployee;
    }

    @Override
    public boolean saveEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.save(new Employee(dto.getId(), dto.getName(), dto.getSalary(),dto.getDate()));
    }

    @Override
    public boolean updateEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(new Employee(dto.getId(),dto.getName(),dto.getSalary(),dto.getDate()));
    }

    @Override
    public boolean clearEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.clear(id);
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete(id);
    }

    @Override
    public String generateNewEmployeeID() throws SQLException, ClassNotFoundException {
        return employeeDAO.generateNewID();
    }
}


