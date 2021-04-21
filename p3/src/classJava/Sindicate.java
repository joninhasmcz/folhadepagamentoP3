package classJava;

public class Sindicate {

    private String name;
    private String participants; // ARRAY
    private double cashRegister;

    public Sindicate(String name, double cashRegister) {
        this.name = name;
        this.cashRegister = cashRegister;
    }
    public double getCashRegister() {
        return cashRegister;
    }

    public void setCashRegister(double cashRegister) {
        this.cashRegister = cashRegister;
    }
}
