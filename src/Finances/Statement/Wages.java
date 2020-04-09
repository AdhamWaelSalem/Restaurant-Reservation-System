package Finances.Statement;

import Main.Restaurant;
import Users.Employee;
import Users.User;

class Wages extends StatementItem{

    public Wages() {

        Title = "Wages";
        CalculateWages();
    }
    private void CalculateWages(){
        float value = 0;
        for (User user: Restaurant.getRestaurant().getUsers()) {
            if (user instanceof Employee){
                value += ((Employee) user).getWages();
            }
        }
        Value = String.valueOf(value) ;
    }
}
