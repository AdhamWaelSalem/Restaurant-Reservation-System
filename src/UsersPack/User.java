package UsersPack;

import DashboardsPack.UserDash;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class User {

    //Attributes
    protected String firstName;
    protected String lastName;
    protected String username;
    protected String password;
    protected boolean loggedIn;
    //Constructors

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public void login(Stage S){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(this.dashLocation()));
            Parent parent = loader.load();
            Scene Dash = new Scene(parent);
            S.setScene(Dash);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String dashLocation(){return null;}

    public void logout() {
    }

    public String info(){
        return this.firstName + " " + this.lastName;
    }
}
