package classJava;

public class Commissioned extends Employee {

    private double commissionSales;

    public Commissioned (double sales) {
        this.commissionSales = sales;
    }
    public void setSales(double sales) {
        this.commissionSales = sales;
    }
    public double getSales() {
        return commissionSales;
    }
}
