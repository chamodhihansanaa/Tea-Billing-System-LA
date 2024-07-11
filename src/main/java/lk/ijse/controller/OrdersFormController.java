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
import lk.ijse.Tm.OrdersTm;
import lk.ijse.bo.OrdersBO;
import lk.ijse.entity.Orders;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersFormController {

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
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colOrderID;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private TableView<OrdersTm> tblOrders;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtDate;

    @FXML
    private JFXTextField txtOrderID;

    @FXML
    private JFXTextField txtQuantity;

    @FXML
    private JFXTextField txtSearch;
    private List<OrdersBO> ordersList= new ArrayList<>();
    public void initialize() {
        this.ordersList = getAllOrders();
        setCellValueFactory();
        loadOrdersTable();
    }

    private List<Orders> getAllOrders() {
        List<Orders> ordersList = null;
        try {
            ordersList = OrdersBO.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ordersList;
    }


    private void setCellValueFactory() {
        colOrderID.setCellValueFactory(new PropertyValueFactory<>("OrderID"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
    }

    private void loadOrdersTable() {
        ObservableList<OrdersTm> tmList = FXCollections.observableArrayList();

        for (Orders orders : ordersList) {
            OrdersTm ordersTm = new OrdersTm(
                    orders.getId(),
                    orders.getDate(),
                    orders.getAddress(),
                    orders.getQuantity()
            );

            tmList.add(ordersTm);
        }
        tblOrders.setItems(tmList);
        OrdersTm selectedItem = tblOrders.getSelectionModel().getSelectedItem();
        System.out.println("selectedItem = " + selectedItem);
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtOrderID.setText("");
        txtAddress.setText("");
        txtQuantity.setText("");
        txtDate.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String orderid = txtOrderID.getText();

        try {
            boolean isDeleted = OrdersBO.delete(orderid);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String orderid = txtOrderID.getText();
        String address = txtAddress.getText();
        String quantity = txtQuantity.getText();
        String date = txtDate.getText();

        Orders orders = new Orders(orderid, address, quantity, date);

        try {
            boolean isSaved = OrdersBO.save(orders);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String orderid = txtOrderID.getText();

        try {
            Orders orders = OrdersBO.searchByOrderID(orderid);

            if (orders != null) {
                txtOrderID.setText(orders.getId());
                txtAddress.setText(orders.getAddress());
                txtQuantity.setText(orders.getQuantity());
                txtDate.setText(orders.getDate());
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String orderid = txtOrderID.getText();
        String address= txtAddress.getText();
        String quantity = txtQuantity.getText();
        String date = txtDate.getText();

        Orders orders = new Orders(orderid, address, quantity, date);

        try {
            boolean isUpdated = OrdersBO.update(orders);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void selectedOrders(MouseEvent mouseEvent) throws SQLException{
        OrdersTm selectedTm =tblOrders.getSelectionModel().getSelectedItem();
        txtOrderID.setText(selectedTm.getOR_ID());
        txtAddress.setText(selectedTm.getAddress());
        txtQuantity.setText(selectedTm.getQuantity());
        txtDate.setText(selectedTm.getDate());
    }
}
