package Dashboards.Client;

import MainPack.Restaurant;
import ReservationPack.Reservation;
import UsersPack.Client;
import UsersPack.User;
import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Invoice implements Initializable {
    @FXML
    private AnchorPane pane;
    @FXML
    JFXListView<String> Invoice;
   // private static int i = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        viewInvoice();
    }

    public void viewInvoice() {
        int i = 0;
        for (User u : Restaurant.getRestaurant().getUsers()) {
            if (u.isLoggedIn()) {
                for (Reservation r : ((Client) u).getReservations()) {
                    System.out.println("l");
                    try {
                        r.getOrder();
                        Invoice.getItems().add("Order " + (++i));
                        Invoice.getItems().addAll(r.getOrder().getPaymentCheck().getInvoice());
                        Invoice.getItems().add("");
                    } catch (Exception e) {
                        //
                    }
                }
            }
        }

    }

    public void returnToProfile(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        Parent parent = (Parent) fxmlLoader.load();
        Scene scene = new Scene(parent);
        scene.setFill(Color.TRANSPARENT);
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
