package UsersPack;

public class Waiter extends Employee {

    //Constructor

    public Waiter() {
    }
    public Waiter(String name, String username, String password) {
        super(name, username, password);
    }

    //Methods
    @Override
    public String dashLocation(){
        return "/Dashboards/Waiter/Home.fxml";
    }

    @Override
    public float getWages() {
        Wages = (float)55.5;
        return Wages;
    }

    @Override
    public Access getAccess() {
        access = Access.Partial;
        return access;
    }
}
