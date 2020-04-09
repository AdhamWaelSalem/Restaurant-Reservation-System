package Dashboards.Employee.Manager.Employees;

import MainPack.Restaurant;
import UsersPack.*;
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

public class View implements Initializable {
    @FXML
    protected AnchorPane pane;
    @FXML
    private TableView<Details> EmployeesView;
    @FXML
    private TableColumn<Details, String> Name;
    @FXML
    private TableColumn<Details, String> Role;
    @FXML
    private TableColumn<Details, String> Wages;
//    @FXML
//    private TableColumn<Details, JFXButton> Fire;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initColumns();
        loadEmployees();
    }

    private void initColumns() {
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Role.setCellValueFactory(new PropertyValueFactory<>("Role"));
        Wages.setCellValueFactory(new PropertyValueFactory<>("Wages"));

    }

    private void loadEmployees() {
        ObservableList<Details> details = FXCollections.observableArrayList();

        for (User u : Restaurant.getRestaurant().getUsers()) {
            if (u instanceof Employee) {
                Details e = new Details();
                //JFXButton jfxButton = new JFXButton();
                e.setName(u.getName());
                e.setRole(((Employee) u).Role());
                e.setWages(String.valueOf(((Employee) u).getWages()));
                //e.setFire(jfxButton);
                details.add(e);
            }
        }
        EmployeesView.setItems(details);
    }
}