package Dashboards.Client;

import OrdersPack.Order;
import OrdersPack.OrderItem;
import UsersPack.Client;
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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Invoice implements Initializable {
    @FXML
    private AnchorPane pane;
    @FXML
    TableView<InvoiceDetails> InvoiceView;
    @FXML
    TableColumn<InvoiceDetails,String> order;
    @FXML
    TableColumn<InvoiceDetails,String> price;
    @FXML
    TableColumn<InvoiceDetails,String> amount;
    @FXML
    TableColumn<InvoiceDetails,String> sumPrice;
    @FXML
    TableColumn<InvoiceDetails,String> taxes;
    @FXML
    TableColumn<InvoiceDetails,String> afterTaxes;
    @FXML
    Label Total;

    private HomePage homePage;
    Order InvoiceOrder;
    protected void initHomePage(HomePage controller){
        homePage = controller;
        InvoiceOrder = ((Client) homePage.user).getReservations().get(((Client) homePage.user).getReservations().size()-1).getOrder();
        showInvoice();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initColumns();
    }

    private void initColumns() {
        order.setCellValueFactory(new PropertyValueFactory<>("order"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        sumPrice.setCellValueFactory(new PropertyValueFactory<>("sumPrice"));
        taxes.setCellValueFactory(new PropertyValueFactory<>("taxes"));
        afterTaxes.setCellValueFactory(new PropertyValueFactory<>("afterTaxes"));
    }

    public void showInvoice(){
        ObservableList<InvoiceDetails> Invoice = FXCollections.observableArrayList();
        float total = 0;
        for (OrderItem o: InvoiceOrder.getOrderedItems()) {
            InvoiceDetails i = new InvoiceDetails(o);
            total += (o.getTaxes()+1)*o.getPrice()*o.getAmount();
            Invoice.add(i);
        }
        InvoiceView.setItems(Invoice);
        Total.setText("$" + total);
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
