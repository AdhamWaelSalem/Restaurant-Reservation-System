package Dashboards.Client;

import javafx.scene.layout.HBox;

public class DishDetails {

    private String Name;
    private String Price;
    private HBox Amount;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public HBox getAmount() {
        return Amount;
    }

    public void setAmount(HBox amount) {
        Amount = amount;
    }
}
