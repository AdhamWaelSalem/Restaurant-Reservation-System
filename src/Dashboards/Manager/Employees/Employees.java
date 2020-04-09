package Dashboards.Manager.Employees;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Employees {
    @FXML
    private
    AnchorPane employeesPane;


    public void viewEmployees(MouseEvent mouseEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("View.fxml"));
        employeesPane.getChildren().removeAll();
        employeesPane.getChildren().setAll(fxml);

    }

    public void addNewEmployee(MouseEvent mouseEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("Add.fxml"));
        employeesPane.getChildren().removeAll();
        employeesPane.getChildren().setAll(fxml);
    }
}
