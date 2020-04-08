package FXML;

import com.jfoenix.controls.JFXSlider;
import javafx.scene.layout.HBox;

public class DishDetails {
    private String Name;
    private String Price;
    private JFXSlider Amount;
   // private HBox amount;

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
