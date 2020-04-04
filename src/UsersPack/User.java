package UsersPack;

public abstract class User {

    //Attributes
    protected String firstName;
    protected String lastName;
    protected String username;
    protected String password;
    ///TO CHECK IF LOGGED IN
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

    public String login() {
        return null;
    }

    public void logout() {
    }

    public String info(){
        return this.firstName + " " + this.lastName;
    }
}
