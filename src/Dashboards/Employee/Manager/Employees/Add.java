package Dashboards.Employee.Manager.Employees;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Add implements Initializable {

    @FXML
    private JFXTextField FirstName;
    @FXML
    private JFXTextField LastName;
    @FXML
    private JFXTextField UserName;
    @FXML
    private JFXTextField Password;
    private String Roles[] = {"Manager","Chef","Waiter"};
    @FXML
    private JFXComboBox Role;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Role.setItems(FXCollections.observableArrayList(Roles));
    }
}
