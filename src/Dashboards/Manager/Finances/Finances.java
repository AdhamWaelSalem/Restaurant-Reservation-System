package Dashboards.Manager.Finances;

import MainPack.Restaurant;
import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Finances implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private TableView<IncomeStatement> Statement;
//    @FXML
//    private TableColumn<String,String>


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
