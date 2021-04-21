package classJava;

public class Employee {

    private String name;
    private String cpf;
    private int employeeId;
    private String address;
    private String paymentMethod;

    public void initEmployee(String name, String address, int employeeId, String paymentMethod) {
        this.name = name;
        this.address = address;
        this.employeeId = employeeId;
        this.paymentMethod = paymentMethod;
    }

    public String printEmployee() {
        return "Name " + this.name +
                "\nAdress: " + this.address +
                "\nEmployee ID: " + this.employeeId +
                "\nMetodo de Pagamento: " + this.paymentMethod;
    }
    public void configurePaymentMethod(String method) {
        if (method.equals("hand check") || method.equals("deposit") || method.equals("mail check")) {
            this.paymentMethod = method;
        } else {
            System.out.println("Invalid payment method!\n");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
