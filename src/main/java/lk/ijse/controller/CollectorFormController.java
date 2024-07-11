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
import lk.ijse.Tm.CollectorTm;
import lk.ijse.bo.CollectorBO;
import lk.ijse.dao.CollectEmpDetailsDAOImpl;
import lk.ijse.entity.Collector;

import java.sql.SQLException;
import java.util.List;

public class CollectorFormController {

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
        private TableColumn<?, ?> colCollect_ID;

        @FXML
        private TableColumn<?, ?> colContactNo;

        @FXML
        private TableColumn<?, ?> colName;

        @FXML
        private TableView<CollectorTm> tblCollector;

        @FXML
        private JFXTextField txtAddress;

        @FXML
        private JFXTextField txtContactNo;

        @FXML
        private JFXTextField txtID;

        @FXML
        private JFXTextField txtName;

        @FXML
        private JFXTextField txtSearch;

        private List<Collector> collectorList = new ArrayList<>();

        public void initialize() {
            this.collectorList = getAllCollectors();
            setCellValueFactory();
            loadCollectorTable();
        }

        private List<Collector> getAllCollectors() {
            List<Collector> collectorList = null;
            try {
                collectorList = CollectorBO.getAllCollector();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return collectorList;
        }

        private void setCellValueFactory() {
            colCollect_ID.setCellValueFactory(new PropertyValueFactory<>("Collect_ID"));
            colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
            colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
            colContactNo.setCellValueFactory(new PropertyValueFactory<>("ContactNo"));
        }

        private void loadCollectorTable() {
           ObservableList<CollectorTm> tmList = FXCollections.observableArrayList();

            for (Collector collector : collectorList) {
                CollectorTm collectorTm = new CollectorTm(
                        collector.getId(),
                        collector.getName(),
                        collector.getAddress(),
                        collector.getContact()
                );

                tmList.add(collectorTm);
            }
            tblCollector.setItems(tmList);
            CollectorTm selectedItem = tblCollector.getSelectionModel().getSelectedItem();
            System.out.println("selectedItem = " + selectedItem);
        }


        @FXML
        void btnClearOnAction(ActionEvent event)  {
            txtID.setText("");
            txtName.setText("");
            txtAddress.setText("");
            txtContactNo.setText("");
        }

        @FXML
        void btnDeleteOnAction(ActionEvent event) {
            String collect_id = txtID.getText();


            boolean isDeleted = CollectorBO.delete(collect_id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
            }
        }

        @FXML
        void btnSaveOnAction(ActionEvent event) {
            String collect_id = txtID.getText();
            String name = txtName.getText();
            String address = txtAddress.getText();
            String contactno = txtContactNo.getText();

            Collector collector = new Collector(collect_id, name, address, contactno);

            System.out.println(collector.toString());
            boolean isSaved = CollectorBO.save(collector);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
            }
        }

        @FXML
        void btnSearchOnAction(ActionEvent event) {
            String collect_id = txtID.getText();

            Collector collector = CollectorBO.searchByCollect_ID(collect_id);

            if (collector != null) {
                txtID.setText(collector.getId());
                txtName.setText(collector.getName());
                txtAddress.setText(collector.getAddress());
                txtContactNo.setText(collector.getContact());
            }
        }

        @FXML
        void btnUpdateOnAction(ActionEvent event) {
            String collect_id = txtID.getText();
            String name = txtName.getText();
            String address = txtAddress.getText();
            String contactno = txtContactNo.getText();

            Collector collector = new Collector(collect_id, name, address, contactno);

            boolean isUpdated = CollectorBO.update(collector);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
            }
        }

        public void selectCollectors(MouseEvent mouseEvent) throws SQLException {
            CollectorTm selectedTm = tblCollector.getSelectionModel().getSelectedItem();
            txtID.setText(selectedTm.getId());
            txtName.setText(selectedTm.getName());
            txtAddress.setText(selectedTm.getAddress());
            txtContactNo.setText(selectedTm.getContact());
        }
    }