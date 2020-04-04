package UsersPack;

public class Chef extends Employee {
    public Chef(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Override
    public String login() {
        return "Chef/ChefDash.fxml";
    }
}
