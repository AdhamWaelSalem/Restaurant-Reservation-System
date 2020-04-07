package FXML;

import com.jfoenix.controls.JFXSlider;

public class DishDetails {
    private String Name;
    private String Price;
    private JFXSlider Amount;

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

    public JFXSlider getAmount() {
        return Amount;
    }

    public void setAmount(JFXSlider amount) {
        Amount = amount;
    }
}
