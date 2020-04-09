package Dashboards.Client;

import Main.Restaurant;
import Reservation.ReserveItem;
import Reservation.Table;
import Users.Client;
import com.jfoenix.controls.JFXToggleButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

public class Tables implements Initializable {

    @FXML
    protected StackPane pane;
    @FXML
    private TableView<TableDetails> TablesView;
    @FXML
    private TableColumn<TableDetails, String> Table;
    @FXML
    private TableColumn<TableDetails, String> Seats;
    @FXML
    private TableColumn<TableDetails, String> Smoking;
    @FXML
    private TableColumn<TableDetails, String> Location;
    @FXML
    private TableColumn<TableDetails, JFXToggleButton> Reserve;


    private HomePage homePage;
    protected void initHomePage(HomePage controller){
        homePage = controller;
    }

    List<JFXToggleButton> jfxToggleButtons = new ArrayList<>();
    ToggleGroup toggleGroup = new ToggleGroup();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initColumns();
        LoadTables();
    }


    private void initColumns() {
        Table.setCellValueFactory(new PropertyValueFactory<>("Table"));
        Seats.setCellValueFactory(new PropertyValueFactory<>("Seats"));
        Smoking.setCellValueFactory(new PropertyValueFactory<>("Smoking"));
        Location.setCellValueFactory(new PropertyValueFactory<>("Location"));
        Reserve.setCellValueFactory(new PropertyValueFactory<>("Reserve"));
    }

    private void LoadTables() {
        ObservableList<TableDetails> Tables = FXCollections.observableArrayList();
        for (ReserveItem t : Restaurant.getRestaurant().getReserveItems()) {
            if (t instanceof Table) {
                TableDetails D = new TableDetails();
                D.setTable("Table " + ((Table) t).getNumber());
                D.setSeats(((Table) t).getNumberOfSeats() + " Seats");
                D.setSmoking(((Table) t).isSmoking() ? "Smoking" : "Non Smoking");
                D.setLocation(((Table) t).getLocation().toString());
                // Toggle buttons
                JFXToggleButton jfxToggleButton = new JFXToggleButton();
                jfxToggleButtons.add(jfxToggleButton);
                if (Restaurant.getRestaurant().getReserveItems().get(jfxToggleButtons.indexOf(jfxToggleButton)).isReserved()) {
                    jfxToggleButton.setSelected(true);
                    jfxToggleButton.setDisable(true);
                    jfxToggleButton.setToggleLineColor(Color.RED);
                    jfxToggleButton.setToggleColor(Color.RED);
                } else jfxToggleButton.setToggleGroup(toggleGroup);
                D.setReserve(jfxToggleButton);
                Tables.add(D);
            }
        }
        TablesView.setItems(Tables);
    }

    public void AddOrder() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Dishes.fxml"));
        fxmlLoader.load();
        Dishes dishesController = fxmlLoader.getController();
        dishesController.initHomePage(homePage);
        Parent fxml = fxmlLoader.getRoot();
        pane.getChildren().removeAll();
        pane.getChildren().setAll(fxml);
    }

    public void RESERVATION(){
        try {
            Table table = (Table) Restaurant.getRestaurant().getReserveItems().get(jfxToggleButtons.indexOf(toggleGroup.getSelectedToggle()));
            ((Client) homePage.user).MakeReservation(table,Calendar.getInstance().getTime());
            AddOrder();
        } catch (Exception e) {
            System.out.println("ENTERED EXCEPTION!!!");
            //No Table Selected ALERT BOX

        }
    }

    public void cancel(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        scene.setFill(Color.TRANSPARENT);
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
