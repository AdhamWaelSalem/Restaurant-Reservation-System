//package Z.Client;
//
//import MainPack.Restaurant;
//import ReservationPack.Reservation;
//import ReservationPack.Table;
//import UsersPack.Client;
//import UsersPack.User;
//import com.jfoenix.controls.JFXButton;
//import javafx.event.ActionEvent;
//import javafx.fxml.ClientFXML;
//import javafx.fxml.Initializable;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.Priority;
//import javafx.scene.text.TextAlignment;
//
//import java.net.URL;
//import java.util.*;
//import java.util.List;
//
//public class ClientTablesPane extends ClientDash implements Initializable {
//
//    @ClientFXML
//    GridPane Gridpane = new GridPane();
//    List<JFXButton> tab = new ArrayList<>();
//    Client client = new Client();
//
//
//    public void ConfirmReservation(ActionEvent event) throws Exception {
//        Restaurant restaurant = Restaurant.getRestaurant();
//        int i;
//        for (i = 0; i < Gridpane.getChildren().size(); i++) {
//            if (Gridpane.getChildren().get(i).getStyle().equals("-fx-background-color: GREEN")) {
//                break;
//            }
//        }
//        if (!restaurant.getTables().get(i).isReserved()) {
//            restaurant.getTables().get(i).Reserve();
//            for (User user : Restaurant.getRestaurant().getUsers()) {
//                if (user.isLoggedIn()) {
//                    client = (Client) user;
//                    Reservation reservation = new Reservation(client, restaurant.getTables().get(i), Calendar.getInstance().getTime());
//                    restaurant.addReservation(reservation);
//                    break;
//                }
//            }
//
//        }
//        //OrdersPane(event);
//
//    }
//
//    public Client getClient(Client client) {
//        return client;
//    }
//
//    public void clickOnButton() {
//        Gridpane.getChildren().forEach(node -> {
//            node.setOnMouseClicked(event -> {
//                int i;
//                if (event.getPickResult().getIntersectedNode().getStyle().equals("-fx-background-color: GREEN"))
//                    event.getPickResult().getIntersectedNode().setStyle("-fx-text-fill: WHITE;-fx-font-size: 12PX;-fx-alignment: CENTER");
//                else if (event.getPickResult().getIntersectedNode().getStyle().equals("-fx-text-fill: WHITE;-fx-font-size: 12PX;-fx-alignment: CENTER")) {
//                    for (i = 0; i < Gridpane.getChildren().size(); i++) {
//                        if (Gridpane.getChildren().get(i).getStyle().equals("-fx-background-color: GREEN")) {
//                            Gridpane.getChildren().get(i).setStyle("-fx-text-fill: WHITE;-fx-font-size: 12PX;-fx-alignment: CENTER");
//                            break;
//                        }
//                    }
//                    event.getPickResult().getIntersectedNode().setStyle("-fx-background-color: GREEN");
//
//                }
//
//                //    ConfirmReservation();
//            });
//
//        });
//
//    }
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        int i = 0, j = 0;
//        for (Table table : Restaurant.getRestaurant().getTables()) {
//            JFXButton b = new JFXButton(table.info());
//            if (!table.isReserved())
//                b.setStyle("-fx-text-fill: WHITE;-fx-font-size: 12PX;-fx-alignment: CENTER");
//            else b.setStyle("-fx-background-color: RED");
//            b.setTextAlignment(TextAlignment.CENTER);
//            tab.add(b);
//            GridPane.setHgrow(b, Priority.ALWAYS);
//            GridPane.setVgrow(b, Priority.ALWAYS);
//            GridPane.setConstraints(b, i, j / 2);
//            Gridpane.getChildren().add(b);
//            if (i == 0)
//                i = 1;
//            else
//                i = 0;
//            j++;
//        }
//
//        clickOnButton();
//    }
//
//}
