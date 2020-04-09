package Finances.Statement;

class Profit extends StatementItem{

    public Profit() {
        Title = "Profit";
        CalculateProfit();

    }

    private void CalculateProfit(){
        float value = 0;
        Sales sales = new Sales();
        Taxes taxes = new Taxes();
        Wages wages = new Wages();
        value = Float.valueOf(sales.Value) - Float.valueOf(taxes.Value) - Float.valueOf(wages.Value);
        Value= String.valueOf(value);
    }
}
