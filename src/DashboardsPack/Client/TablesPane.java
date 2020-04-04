package DashboardsPack.Client;

import MainPack.Restaurant;
import ReservationPack.Reservation;
import ReservationPack.Table;
import UsersPack.Client;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.*;
import java.util.List;

public class TablesPane implements Initializable {

    @FXML
    GridPane Gridpane = new GridPane();
    List<JFXButton> tab = new ArrayList<>();


    public void ConfirmReservation() {
        Restaurant restaurant = Restaurant.getRestaurant();
        int i;
        for (i = 0; i < Gridpane.getChildren().size(); i++) {
            if (Gridpane.getChildren().get(i).getStyle().equals("-fx-background-color: GREEN")) {
                break;
            }
        }

        restaurant.getTables().get(i).Reserve();
        System.out.println(restaurant.getTables().get(i).getNumber());
        Reservation reservation = new Reservation(restaurant.getTables().get(i), Calendar.getInstance().getTime());
        restaurant.addReservation(reservation);

    }

    public Client getClient(Client client) {
        return client;
    }

    public void clickOnButton() {
        Gridpane.getChildren().forEach(node -> {
            node.setOnMouseClicked(event -> {
                int i;
                if (event.getPickResult().getIntersectedNode().getStyle().equals("-fx-background-color: GREEN"))
                    event.getPickResult().getIntersectedNode().setStyle("-fx-text-fill: WHITE;-fx-font-size: 12PX;-fx-alignment: CENTER");
                else {
                    for (i = 0; i < Gridpane.getChildren().size(); i++) {
                        if (Gridpane.getChildren().get(i).getStyle().equals("-fx-background-color: GREEN")) {
                            Gridpane.getChildren().get(i).setStyle("-fx-text-fill: WHITE;-fx-font-size: 12PX;-fx-alignment: CENTER");
                            break;
                        }
                    }
                    event.getPickResult().getIntersectedNode().setStyle("-fx-background-color: GREEN");

                }

            //    ConfirmReservation();
            });

        });

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int i = 0, j = 0;
        for (Table table : Restaurant.getRestaurant().getTables()) {
            JFXButton b = new JFXButton(table.info());
            b.setStyle("-fx-text-fill: WHITE;-fx-font-size: 12PX;-fx-alignment: CENTER");
            b.setTextAlignment(TextAlignment.CENTER);
            tab.add(b);
            GridPane.setHgrow(b, Priority.ALWAYS);
            GridPane.setVgrow(b, Priority.ALWAYS);
            GridPane.setConstraints(b, i, j / 2);
            Gridpane.getChildren().add(b);
            if (i == 0)
                i = 1;
            else
                i = 0;
            j++;
        }

        clickOnButton();
    }

}
