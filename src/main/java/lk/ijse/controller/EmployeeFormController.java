package lk.ijse.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.Tm.EmployeeTm;
import lk.ijse.bo.EmployeeBO;
import lk.ijse.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeFormController {

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colEMP_ID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableView<EmployeeTm> tblEmployee;

    @FXML
    private JFXTextField txtDate;

    @FXML
    private JFXTextField txtEMP_ID;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtSalary;

    @FXML
    private JFXTextField txtSearch;
    private List<Employee> employeeList;

    public void initialize() throws SQLException {
        employeeList = getAllEmployee();
        setCellValueFactory();
        loadEmployeeTable();
    }

    private void loadEmployeeTable() {
        ObservableList<EmployeeTm> tmList = FXCollections.observableArrayList();

        for (Employee employee : employeeList) {
            EmployeeTm employeeTm = new EmployeeTm(
                    employee.getId(),
                    employee.getName(),
                    employee.getSalary(),
                    employee.getDate()
            );

            tmList.add(employeeTm);
        }
        tblEmployee.setItems(tmList);
        EmployeeTm selectedItem = tblEmployee.getSelectionModel().getSelectedItem();
        System.out.println("selectedItem = " + selectedItem);
    }

    private void setCellValueFactory() {
        colEMP_ID.setCellValueFactory(new PropertyValueFactory<>("Emp_ID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
    }

    private List<Employee> getAllEmployee() throws SQLException {
        List<Employee> employeeList = null;
        try {
            employeeList = EmployeeBO.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeList;
    }
    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtEMP_ID.setText("");
        txtName.setText("");
        txtSalary.setText("");
        txtDate.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String emp_id = txtEMP_ID.getText();

        boolean isDeleted = EmployeeBO.delete(emp_id);
        if (isDeleted) {
            new Alert(Alert.AlertType.CONFIRMATION, "Customer deleted!").show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String emp_id = txtEMP_ID.getText();
        String name = txtName.getText();
        String salary = txtSalary.getText();
        String date = txtDate.getText();

        Employee employee = new Employee(emp_id, name, salary, date);

        boolean isSaved = EmployeeBO.save(employee);
        if (isSaved) {
            new Alert(Alert.AlertType.CONFIRMATION, "Customer saved!").show();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String id = txtEMP_ID.getText();

        Employee employee = EmployeeBO.searchByEMP_ID(id);

        if (employee != null) {
            txtEMP_ID.setText(employee.getId());
            txtName.setText(employee.getName());
            txtSalary.setText(employee.getSalary());
            txtDate.setText(employee.getDate());
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String emp_id = txtEMP_ID.getText();
        String name = txtName.getText();
        String salary = txtSalary.getText();
        String date = txtDate.getText();

        Employee employee = new Employee(emp_id, name, salary, date);

        boolean isUpdated = EmployeeBO.update(employee);
        if (isUpdated) {
            new Alert(Alert.AlertType.CONFIRMATION, "Customer updated!").show();
        }
    }

    @FXML
    void selectedEmployee(MouseEvent event) throws SQLException{
        EmployeeTm selectedTm =tblEmployee.getSelectionModel().getSelectedItem();
        txtEMP_ID.setText(selectedTm.getId());
        txtName.setText(selectedTm.getName());
        txtSalary.setText(selectedTm.getSalary());
        txtDate.setText(selectedTm.getDate());
    }

}
