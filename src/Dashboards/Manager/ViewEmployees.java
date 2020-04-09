package Dashboards.Manager;

import MainPack.Restaurant;
import UsersPack.*;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewEmployees implements Initializable {
    @FXML
    protected AnchorPane pane;
    @FXML
    private TableView<EmployeesDetails> EmployeesView;
    @FXML
    private TableColumn<EmployeesDetails, String> EmployeeName;
    @FXML
    private TableColumn<EmployeesDetails, String> Role;
    @FXML
    private TableColumn<EmployeesDetails, JFXButton> Fire;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initColumns();
        loadEmployees();
    }

    private void initColumns() {
        EmployeeName.setCellValueFactory(new PropertyValueFactory<>("EmployeeName"));
        Role.setCellValueFactory(new PropertyValueFactory<>("Role"));
        Fire.setCellValueFactory(new PropertyValueFactory<>("Fire"));

    }

    private void loadEmployees() {
        ObservableList<EmployeesDetails> employeesDetails = FXCollections.observableArrayList();

        for (User u : Restaurant.getRestaurant().getUsers()) {
            System.out.println(u.getName());
            if (u instanceof Waiter || u instanceof Chef) {
                EmployeesDetails e = new EmployeesDetails();
                JFXButton jfxButton = new JFXButton();
                e.setEmployeeName(u.getName());
              //  System.out.println(u.getName());
                e.setRole(((Employee) u).Role());
                e.setFire(jfxButton);
                employeesDetails.add(e);
            }
        }
        EmployeesView.setItems(employeesDetails);


    }
}