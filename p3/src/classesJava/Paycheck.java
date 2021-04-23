package classesJava;

public class Paycheck {
    private String employeeId;
    private double salary;
    private String fees;

    public Paycheck(String employeeId, double salary, String fees) {
        this.employeeId = employeeId;
        this.salary = salary;
        this.fees = fees;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }
}
