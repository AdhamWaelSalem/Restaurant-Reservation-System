package DashboardsPack.Client;

import MainPack.Restaurant;
import ReservationPack.Table;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TablesPane implements Initializable{

    @FXML
    GridPane Gridpane = new GridPane();
    List<JFXButton> tab = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int i=0,j=0;
        for (Table table : Restaurant.getRestaurant().getTables()) {
            JFXButton b = new JFXButton(table.info());
            b.setStyle("-fx-text-fill: WHITE;-fx-font-size: 12PX;-fx-alignment: CENTER");
            b.setTextAlignment(TextAlignment.CENTER);
            tab.add(b);
            GridPane.setFillHeight(b,true);
            GridPane.setConstraints(b,i,j/2);
            Gridpane.getChildren().add(b);
            if(i==0)
                i=1;
            else
                i=0;
            j++;
        }
    }

}
