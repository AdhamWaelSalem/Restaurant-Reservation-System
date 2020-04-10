package Main;

import Users.Client;
import Users.Clients;
import Users.User;
import XML.LoadXML;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.List;


public class Main extends Application {

    Restaurant restaurant = Restaurant.getRestaurant();

    @Override
    public void init() throws Exception {
       try {
           LoadXML xml = new LoadXML() {};
           restaurant.setUsers(xml.LoadUsers());
           restaurant.getReserveItems().addAll(xml.LoadTables());
           restaurant.getOrderItems().addAll(xml.LoadDishes());
       }catch(Exception e) {
           e.printStackTrace();
       }
       File source = new File("save.xml");
        JAXBContext jaxbContext;
        {
            try {
                jaxbContext = JAXBContext.newInstance(Clients.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                Clients.getClients().setClients((Clients) jaxbUnmarshaller.unmarshal(source));
            } catch (JAXBException a) {

            }
        }
        Clients.getClients().Merge();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../Dashboards/Login/LoginDash.fxml"));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {

        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Clients.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(Clients.getClients(), new File("save.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        Clients.getClients().Save();
    }

    public static void main(String[] args) {
        launch(args);

    }
}
