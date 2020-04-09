package Users;

public class Manager extends Employee {

    //Constructor

    public Manager() {
    }
    public Manager(String name, String username, String password) {
        super(name, username, password);
    }

    //Methods
    @Override
    public String dashLocation(){
        return "/Dashboards/Employee/Manager/HomePage.fxml";
    }

    @Override
    public float getWages() {
        Wages = (float)120;
        return Wages;
    }

    @Override
    public Access getAccess() {
        access = Access.Full;
        return access;
    }

    @Override
    public String Role() {
        return "Manager";
    }
}
