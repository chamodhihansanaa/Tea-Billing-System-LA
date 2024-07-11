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
import lk.ijse.Tm.PriceTm;
import lk.ijse.bo.PriceBO;
import lk.ijse.entity.Price;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PriceFormController {

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
    private TableColumn<?, ?> colCategory;

    @FXML
    private TableColumn<?, ?> colDuration;

    @FXML
    private TableColumn<?, ?> colKGPrice;

    @FXML
    private TableView<PriceTm> tblPrice;

    @FXML
    private JFXTextField txtCategory;

    @FXML
    private JFXTextField txtDuration;

    @FXML
    private JFXTextField txtKGPrice;

    @FXML
    private JFXTextField txtSearch;
    private List<Price> priceList = new ArrayList<>();


    public void initialize() {
        this.priceList = getAllPrice();
        setCellValueFactory();
        loadPriceTable();
    }

    private void setCellValueFactory() {
        colCategory.setCellValueFactory(new PropertyValueFactory<>("Category"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("Duration"));
        colKGPrice.setCellValueFactory(new PropertyValueFactory<>("KGPrice"));

    }

    private void loadPriceTable() {
        ObservableList<PriceTm> tmList = FXCollections.observableArrayList();

        for (Price price : priceList) {
            PriceTm priceTm= new PriceTm(
                    price.getCategory(),
                    price.getDuration(),
                    price.getPrice()

            );

            tmList.add(priceTm);
        }
        tblPrice.setItems(tmList);
        PriceTm selectedItem = tblPrice.getSelectionModel().getSelectedItem();
        System.out.println("selectedItem = " + selectedItem);
    }


    private List<Price> getAllPrice() {
        List<Price> pricesList = null;
        try {
            pricesList = PriceBO.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pricesList;

    }
    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtDuration.setText("");
        txtCategory.setText("");
        txtKGPrice.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException {
        String duration = txtDuration.getText();

        boolean isDeleted = PriceBO.delete(duration);
        if (isDeleted) {
            new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException {
        String duration = txtDuration.getText();
        String category = txtCategory.getText();
        String kgprice = txtKGPrice.getText();


        Price price = new Price(duration, category, kgprice);

        boolean isSaved = PriceBO.save(price);
        if (isSaved) {
            new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException {
        String duration = txtDuration.getText();
        String category = txtCategory.getText();
        String kgprice = txtKGPrice.getText();


        Price price = new Price(duration, category, kgprice);

        boolean isUpdated = PriceBO.update(price);
        if (isUpdated) {
            new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
        }
    }

    public void selectedPrice(MouseEvent mouseEvent) throws SQLException{
        PriceTm selectedTm = tblPrice.getSelectionModel().getSelectedItem();
        txtDuration.setText(selectedTm.getDuration());
        txtCategory.setText(selectedTm.getCategory());
        txtKGPrice.setText(selectedTm.getKG_Price());
    }
}
