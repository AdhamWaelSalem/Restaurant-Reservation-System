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

    public String info() {
        String info;
        info = this.type.toString() + "\n" +
                this.name + "\n" +
                "Price " + this.price + " $";


        return info;
    }
}
