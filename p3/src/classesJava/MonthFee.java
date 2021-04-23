package classesJava;

public class MonthFee extends Fees {
    private double value;

    public MonthFee(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
