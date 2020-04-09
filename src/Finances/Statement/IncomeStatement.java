package Finances.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class IncomeStatement {

    public ObservableList<StatementItem> getDetails(){
        ObservableList<StatementItem> Details = FXCollections.observableArrayList();
        Details.add(new Sales());
        Details.add(new Taxes());
        Details.add(new Wages());
        Details.add(new Profit());
        return Details;
    }
























//    List<String> info = new ArrayList<>();
//    public List<String> getInfo(){
//
//        try {
//            Sales sales = new Sales(Restaurant.getRestaurant().getUsers());
//            Taxes taxes = new Taxes(Restaurant.getRestaurant().getUsers());
//            Wages wages = new Wages(Restaurant.getRestaurant().getUsers());
//            Profit profit = new Profit(sales,taxes,wages);
//            info.add("Sales\t"+sales.calculate());
//            info.add("Taxes\t("+taxes.calculate()+")");
//            info.add("Wages\t("+wages.calculate()+")");
//            info.add("_______________________");
//            if (profit.calculate()>=0)
//                info.add("Profit\t"+profit.calculate());
//            else info.add("Loss\t("+profit.calculate()+")");
//            return info;
//        }catch (NullPointerException e){
//            info.add("No Orders Made Yet");
//            e.printStackTrace();
//            return info;
//        }
//    }
}
