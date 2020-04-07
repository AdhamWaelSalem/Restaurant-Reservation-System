package FXML;

import MainPack.Restaurant;
import ReservationPack.ReserveItem;
import ReservationPack.Table;
import com.jfoenix.controls.JFXToggleButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Tables implements Initializable {
    @FXML
    private TableView<TableDetails> TablesView;
    @FXML
    private TableColumn<TableDetails,String> Table;
    @FXML
    private TableColumn<TableDetails,String> Seats;
    @FXML
    private TableColumn<TableDetails,String> Smoking;
    @FXML
    private TableColumn<TableDetails,String> Location;
    @FXML
    private TableColumn<TableDetails, JFXToggleButton> Reserve;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initColumns();
        LoadTables();
    }

    private void initColumns(){
        Table.setCellValueFactory(new PropertyValueFactory<>("Table"));
        Seats.setCellValueFactory(new PropertyValueFactory<>("Seats"));
        Smoking.setCellValueFactory(new PropertyValueFactory<>("Smoking"));
        Location.setCellValueFactory(new PropertyValueFactory<>("Location"));
        Reserve.setCellValueFactory(new PropertyValueFactory<>("Reserve"));
    }

    private void LoadTables(){
        ObservableList<TableDetails> Tables = FXCollections.observableArrayList();
        for (ReserveItem t: Restaurant.getRestaurant().getReserveItems()) {
            if (t instanceof Table){
                TableDetails D = new TableDetails();
                D.setTable("Table "+((Table) t).getNumber());
                D.setSeats(((Table) t).getNumberOfSeats()+ " Seats");
                D.setSmoking(((Table) t).isSmoking() ? "Smoking" : "Non Smoking");
                D.setLocation(((Table) t).getLocation().toString());
                D.setReserve(new JFXToggleButton());
                Tables.add(D);
            }
        }
        TablesView.setItems(Tables);
    }
}
