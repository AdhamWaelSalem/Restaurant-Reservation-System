package UsersPack;

import DashboardsPack.UserDash;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Manager extends Employee {
    public Manager(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Override
    public float getDailyWages() {
        this.dailyWages= (float) 30;
        return this.dailyWages;
    }

    @Override
    public String dashLocation(){
        return "/DashboardsPack/Manager/ManagerDash.fxml";
    }
}
