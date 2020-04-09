package Dashboards.Client;

import Main.Restaurant;
import Orders.Dish;
import Orders.OrderItem;
import Users.Client;
import com.jfoenix.controls.JFXSlider;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Dishes implements Initializable {

    @FXML
    AnchorPane pane;
    @FXML
    private TableView<DishDetails> DishesView;
    @FXML
    private TableColumn<DishDetails, String> Name;
    @FXML
    private TableColumn<DishDetails, String> Price;
    @FXML
    private TableColumn<DishDetails, HBox> Amount;


    List<JFXSlider> jfxSliders = new ArrayList<>();
    List<Label> labelList = new ArrayList<>();

    Restaurant restaurant = Restaurant.getRestaurant();
    List<OrderItem> orderItems = restaurant.getOrderItems();

    private HomePage homePage;
    protected void initHomePage(HomePage controller){
        homePage = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initColumns();
        LoadDishes();
    }

    private void initColumns() {
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Price.setCellValueFactory(new PropertyValueFactory<>("Price"));
        Amount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
    }

    private void LoadDishes() {
        ObservableList<DishDetails> Dishes = FXCollections.observableArrayList();
        for (OrderItem o : Restaurant.getRestaurant().getOrderItems()) {
            if (o instanceof Dish) {
                DishDetails d = new DishDetails();
                d.setName(o.getName());
                d.setPrice(String.valueOf(o.getPrice()));
                JFXSlider jfxSlider = new JFXSlider(0, 20, 0);
                Label label = new Label();
                label.setStyle("-fx-text-fill: WHITE");
                jfxSliders.add(jfxSlider);
                jfxSlider.setShowTickLabels(true);
                jfxSlider.setMajorTickUnit(5f);
                labelList.add(label);
                label.textProperty().bind(Bindings.format("%.0f", jfxSlider.valueProperty()));
                d.setAmount(new HBox(jfxSlider, label));
                Dishes.add(d);
            }
        }
        DishesView.setItems(Dishes);
    }

    public void viewInvoice() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Invoice.fxml"));
        fxmlLoader.load();
        Invoice invoiceController = fxmlLoader.getController();
        invoiceController.initHomePage(homePage);
        Parent fxml = fxmlLoader.getRoot();
        pane.getChildren().removeAll();
        pane.getChildren().setAll(fxml);
    }
    public void ORDER(MouseEvent mouseEvent) throws IOException {
        List<OrderItem> orderedItems = new ArrayList<>();
        for (JFXSlider s: jfxSliders) {
            if (s.getValue()!=0){
                orderItems.get(jfxSliders.indexOf(s)).setAmount((int) s.getValue());
                orderedItems.add(orderItems.get(jfxSliders.indexOf(s)));
            }
        }
        ((Client) homePage.user).AddOrder(((Client) homePage.user).getReservations().get(((Client) homePage.user).getReservations().size()-1),orderedItems);
        try {
            viewInvoice();
        } catch (IOException e) {
            e.printStackTrace();
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
