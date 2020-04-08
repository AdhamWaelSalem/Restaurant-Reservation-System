package OrdersPack;

public class Dish extends OrderItem {

    //Attributes
    public enum Type {
        MainCourse,
        Appetizer,
        Dessert
    }
    private Type type;

    //Constructor
    public Dish() {
    }
    public Dish(String name, int price) {
        super(name, price);
    }
    public Dish(String name, int price, Type type) {
        super(name, price);
        this.type = type;
    }

    //Methods
    @Override
    public float getTaxes() {
        if (type.equals(Type.MainCourse))
            this.taxes= (float) 0.15;
        else if (type.equals(Type.Appetizer))
            this.taxes= (float) 0.1;
        else if (type.equals(Type.Dessert))
            this.taxes= (float) 0.2;
        return this.taxes;
    }

    //Getters and Setters
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
