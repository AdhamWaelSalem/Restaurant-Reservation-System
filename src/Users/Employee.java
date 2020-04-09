package Users;

public abstract class Employee extends User {

    protected float Wages;

    public enum Access {
        Full,
        Partial,
        Minimum
    }

    protected Access access;

    //Constructor
    public Employee() {
    }

    public Employee(String name, String username, String password) {
        super(name, username, password);
    }

    //Getters and Setters
    public float getWages() {
        return Wages;
    }

    public void setWages(float wages) {
        Wages = wages;
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }
    //Method
    public abstract String Role();

}
