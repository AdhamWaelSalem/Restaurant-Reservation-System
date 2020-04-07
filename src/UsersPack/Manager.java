package UsersPack;

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
        return "/Dashboards/Manager/Home.fxml";
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
}
