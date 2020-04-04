package OrdersPack;

public class Dish extends OrderItem {

    public enum Type {
        MainCourse,
        Appetizer,
        Dessert
    }

    private Type type;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String info() {
        String info;
        info = this.type.toString() + "\n" +
                this.name + "\n" +
                "Price " + this.price + " $";


        return info;
    }
}
