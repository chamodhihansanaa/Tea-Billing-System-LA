package lk.ijse.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.bo.DeliveryBO;
import lk.ijse.dto.DeliveryDTO;
import lk.ijse.entity.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryFormController {

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCode;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableView<DeliveryTm> tblDelivery;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtCode;

    @FXML
    private JFXTextField txtDate;

    @FXML
    private JFXTextField txtPrice;
    private List<DeliveryDTO> deliveryList = new ArrayList<>();

    private List<DeliveryDTO>getAllCollectors =new ArrayList<>();

    public void initialize() {
        this.getAllCollectors=getAllCollectors();
        this.deliveryList = getAllDelivery();
        setCellValueFactory();
        loadDeliveryTable();
        getAllDelivery();
    }

    private List<DeliveryDTO> getAllDelivery() {
        List<DeliveryDTO> deliveryList = null;
        try {
            deliveryList = DeliveryBO.getAllDelivery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deliveryList;

    }

    private List<DeliveryBO> getAllCollectors() {
        List<DeliveryBO> deliveryList = null;
        try {
            deliveryList = DeliveryBO.getAllDelivery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deliveryList;
    }

    private void setCellValueFactory() {
        colCode.setCellValueFactory(new PropertyValueFactory<>("Code"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
    }

    private void loadDeliveryTable() {
        ObservableList<DeliveryTm> tmList = FXCollections.observableArrayList();

        for (Delivery delivery : deliveryList) {
            DeliveryTm deliveryTm = new DeliveryTm(
                    delivery.getCode(),
                    delivery.getPrice(),
                    delivery.getDate(),
                    delivery.getAddress()
            );

            tmList.add(deliveryTm);
        }
        tblDelivery.setItems(tmList);
    }
    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtCode.setText("");
        txtPrice.setText("");
        txtDate.setText("");
        txtAddress.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String code = txtCode.getText();

        boolean isDeleted = DeliveryBO.delete(code);
        if (isDeleted) {
            new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String code = txtCode.getText();
        String price = txtPrice.getText();
        String date = txtDate.getText();
        String address = txtAddress.getText();

        Delivery delivery = new Delivery(code, price,date,address);

        boolean isSaved = DeliveryBO.save(delivery);
        if (isSaved) {
            new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String code = txtCode.getText();

        try {
            Delivery delivery = DeliveryBO.searchByCode(code);

            if (delivery != null) {
                txtCode.setText(delivery.getCode());
                txtPrice.setText(delivery.getPrice());
                txtDate.setText(delivery.getDate());
                txtAddress.setText(delivery.getAddress());
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String code = txtCode.getText();
        String price= txtPrice.getText();
        String date = txtDate.getText();
        String address = txtAddress.getText();

        Delivery delivery = new Delivery(code, price,date,address);

        try {
            boolean isUpdated = DeliveryBO.update(delivery);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void selectDelivery(MouseEvent event)throws SQLException {
        DeliveryTm selectedTm =tblDelivery.getSelectionModel().getSelectedItem();
        txtCode.setText(selectedTm.getCode());
        txtPrice.setText(selectedTm.getPrice());
        txtDate.setText(selectedTm.getDate());
        txtAddress.setText(selectedTm.getAddress());
    }

}

