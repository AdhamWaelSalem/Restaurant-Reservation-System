package Dashboards.Employee.Manager.Finances;

import Finances.Statement.StatementItem;
import MainPack.Restaurant;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Finances implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private TableView<StatementItem> Statement;
    @FXML
    private TableColumn<String,String> Title;
    @FXML
    private TableColumn<String,String> Value;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initColumns();
        initIncomeStatement();
    }


    private void initColumns(){
        Title.setCellValueFactory(new PropertyValueFactory<>("Title"));
        Value.setCellValueFactory(new PropertyValueFactory<>("Value"));
    }
    public void initIncomeStatement() {
        Statement.setItems(Restaurant.getRestaurant().getIncomeStatement().getDetails());
    }



}
