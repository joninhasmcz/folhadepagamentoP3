package classesJava;

public class Payroll {

    private double value;
    private int employeeId;
    private String date;

    public Payroll(double value, int employeeId, String date) {
        this.value = value;
        this.employeeId = employeeId;
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
