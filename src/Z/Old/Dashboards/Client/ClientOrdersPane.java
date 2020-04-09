package Z.Old.Dashboards.Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public class ClientOrdersPane {
    @FXML
    private StackPane stackPane;
    public void New(ActionEvent event) throws Exception {
        System.out.println("hi");
        Parent parent = FXMLLoader.load(getClass().getResource("ClientTablesPane.fxml"));
        stackPane.getChildren().clear();
        stackPane.getChildren().add(parent);
    }
    public void View(ActionEvent event) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource(""));
        stackPane.getChildren().clear();
        stackPane.getChildren().add(parent);
    }
    public void Edit(ActionEvent event) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource(""));
        stackPane.getChildren().clear();
        stackPane.getChildren().add(parent);
    }
    public void Cancel(ActionEvent event) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource(""));
        stackPane.getChildren().clear();
        stackPane.getChildren().add(parent);
    }
    public void Exit(ActionEvent event) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource(""));
        stackPane.getChildren().clear();
        stackPane.getChildren().add(parent);
    }
}
