package UsersPack;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class User {

    //Attributes
    protected String name;
    protected String username;
    protected String password;
    protected boolean loggedIn;

    //Constructor
    public User() {
    }
    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.loggedIn=false;
    }

    //Methods
    public void login(Stage S){
        this.setLoggedIn(true);
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(this.dashLocation()));
            Parent parent = loader.load();
            Scene Dash = new Scene(parent);
            Dash.setFill(Color.TRANSPARENT);
            S.setScene(Dash);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String dashLocation(){
        return null;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
