package UsersPack;

public class Waiter extends Employee {

    public Waiter(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Override
    public String login() {
        return "Waiter/WaiterDash.fxml";
    }
}
