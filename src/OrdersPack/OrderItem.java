package OrdersPack;

public abstract class OrderItem {

    //Attributes
    protected String name;
    protected int price;
    protected float taxes;

    //Constructor
    public OrderItem() {
    }
    public OrderItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getTaxes() {
        return taxes;
    }

    public void setTaxes(float taxes) {
        this.taxes = taxes;
    }
}
