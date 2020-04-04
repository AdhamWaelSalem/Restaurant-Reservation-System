package UsersPack;

public class Manager extends Employee {
    public Manager(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Override
    public String login() {
        return "Manager/ManagerDash.fxml";
    }
}
