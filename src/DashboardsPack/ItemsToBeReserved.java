package DashboardsPack;

import MainPack.Restaurant;
import UsersPack.Client;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemsToBeReserved implements Initializable {
    @FXML
    VBox vbox;
    @FXML
    VBox vboxNumber;
    @FXML
    VBox vboxSmoking;
    @FXML
    Button Signout;
    @FXML
    Label ClientName2;
    public void details(Client client) {
        ClientName2.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        ClientName2.setText("Welcome Mr." + client.getFirstName() + " " + client.getLastName());
        //  StarPoints.setText("Star Points" + client.getStarPoints());

    }

    public void returnToLoginScreen(javafx.event.ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LoginDash.fxml"));
        Scene scene = new Scene(root, 630, 522);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Restaurant restaurant = Restaurant.getRestaurant();
        for (int i = 0; i < restaurant.getTables().size(); i++) {
            Label table = new Label();
            Label numberOfSeats = new Label();
            Label smoking = new Label();

            table.getStylesheets().add(getClass().getResource("style2.css").toExternalForm());
            table.setText("Table " + restaurant.getTables().get(i).getNumber());
            vbox.getSpacing();
            vbox.getChildren().add(table);

           numberOfSeats.getStylesheets().add(getClass().getResource("style2.css").toExternalForm());
            numberOfSeats.setText(String.valueOf(restaurant.getTables().get(i).getNumberOfSeats()));
            vboxNumber.getChildren().add(numberOfSeats);
            vbox.getSpacing();

            smoking.getStylesheets().add(getClass().getResource("style2.css").toExternalForm());
            if (restaurant.getTables().get(i).isSmoking())
                smoking.setText("Smoking Area");
            else
                smoking.setText("Non-Smoking Area");
            vboxSmoking.getChildren().add(smoking);
            vboxSmoking.getSpacing();

        }
    }

}
