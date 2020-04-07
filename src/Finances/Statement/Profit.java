package Finances.Statement;

class Profit extends StatementValue{

    private Sales sales;
    private Taxes taxes;
    private Wages wages;

    protected Profit(Sales sales, Taxes taxes, Wages wages) {
        this.sales = sales;
        this.taxes = taxes;
        this.wages = wages;
    }

    @Override
    protected float calculate() {
        value+=sales.value-taxes.value-wages.value;
        return value;
    }
}
