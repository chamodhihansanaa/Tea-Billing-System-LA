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
import lk.ijse.Tm.ItemsTm;
import lk.ijse.bo.ItemBO;
import lk.ijse.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemFormController {

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colItem_ID;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableView<ItemsTm> tblItems;

    @FXML
    private JFXTextField txtDescription;

    @FXML
    private JFXTextField txtItemID;

    @FXML
    private JFXTextField txtPrice;

    @FXML
    private JFXTextField txtSearch;
    private List<ItemBO> itemsList = new ArrayList<>();

    public void initialize() {
        this.itemsList = getAllItems();
        setCellValueFactory();
        loadItemsTable();
    }

    private List<Item> getAllItems() {
        List<Item> employeeList = null;
        try {
            itemsList = ItemBO.getAllItem();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemsList;
    }



    private void setCellValueFactory() {
        colItem_ID.setCellValueFactory(new PropertyValueFactory<>("Item_ID"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));

    }

    private void loadItemsTable() {
        ObservableList<ItemTm> tmList = FXCollections.observableArrayList();

        for (Item item : itemsList) {
            ItemTm itemTm = new ItemTm(
                    item.getId(),
                    item.getDescription(),
                    item.getPrice()

            );

            tmList.add(itemTm);
        }
        tblItems.setItems(tmList);
        ItemTm selectedItem = tblItems.getSelectionModel().getSelectedItem();
        System.out.println("selectedItem = " + selectedItem);
    }


    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtItemID.setText("");
        txtDescription.setText("");
        txtPrice.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String itemid = txtItemID.getText();

        try {
            boolean isDeleted = ItemBO.delete(itemid);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String itemid = txtItemID.getText();
        String description = txtDescription.getText();
        String price = txtPrice.getText();


        Item item = new Item(itemid, description, price);

        try {
            boolean isSaved = ItemBO.save(item);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String itemid = txtItemID.getText();
        String description = txtDescription.getText();
        String price = txtPrice.getText();


        Item item = new Item(itemid, description, price);

        try {
            boolean isUpdated = ItemBO.update(item);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
            }


            @FXML
            void selectedItem (MouseEvent event)throw SQLException{
                ItemsTm selectedTm = tblItems.getSelectionModel().getSelectedItem();
                txtItemID.setText(selectedTm.getI_ID());
                txtDescription.setText(selectedTm.getDescription());
                txtPrice.setText(selectedTm.getDescription());
            }



    }