package lk.ijse.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import lk.ijse.db.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainFormController {

    @FXML
    private Button btnLogIn;

    @FXML
    private Button btnReset;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private JFXTextField texPassword;

    @FXML
    private JFXTextField txtName;

    @FXML
    void btnLogInOnAction(ActionEvent event) throws SQLException{
        String nameText= txtName.getText();
        String pw = texPassword.getText();

        try {
            checkCredential(nameText, pw);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,(e.getMessage())).show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void checkCredential(String nameText, String pw) throws SQLException, IOException {
        String sql = "SELECT User_Name, Password FROM Users WHERE User_Name = ?";


        Connection connection = DBConnection.getInstence.getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, nameText);


        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()) {
            String dbPw = resultSet.getString(2);

            if(dbPw.equals(pw)) {
                navigateToTheDashboard();
            } else {
                new Alert(Alert.AlertType.ERROR, "Password is incorrect!").show();
            }
        } else {
            new Alert(Alert.AlertType.INFORMATION, "user id not found!").show();
        }
    }

    private void navigateToTheDashboard() throws IOException {
        AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/DashBoard.fxml"));

        Scene scene = new Scene(rootNode);

        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Dashboard Form");
    }

    @FXML
    void btnResetOnAction(ActionEvent event)throws SQLException {

    }

}

