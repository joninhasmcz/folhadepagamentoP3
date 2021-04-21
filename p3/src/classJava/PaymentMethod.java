package classJava;

public class PaymentMethod {

    private String employeeName;
    private int employeeId;
    private String method;

    public void initPaymentMethods(int employeeId, String method) {
        this.employeeId = employeeId;
        this.method = method;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    public String getEmployeeName() {
        return employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getMethod() {
        return method;
    }
}
