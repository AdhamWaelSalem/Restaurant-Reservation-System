package UsersPack;

public class Chef extends Employee {

    //Constructor
    public Chef() {
    }
    public Chef(String name, String username, String password) {
        super(name, username, password);
    }

    //Methods
    @Override
    public String dashLocation(){
        return "/Dashboards/Chef/Home.fxml";
    }

    @Override
    public float getWages() {
        Wages = (float)75.25;
        return Wages;
    }

    @Override
    public Access getAccess() {
        access = Access.Minimum;
        return access;
    }

    @Override
    public String Role() {
        return "Chef";
    }

}
