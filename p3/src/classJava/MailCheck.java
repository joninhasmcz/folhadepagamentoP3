package classJava;

public class MailCheck extends PaymentMethod {

    String employeeAddress;
    String receiver;
    String sender;
    double feePost;

    public  MailCheck(String employeeAddress, String receiver, String sender, double feePost) {
        this.employeeAddress = employeeAddress;
        this.receiver = receiver;
        this.sender = sender;
        this.feePost = feePost;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public double getFeePost() {
        return feePost;
    }

    public void setFeePost(double feePost) {
        this.feePost = feePost;
    }
}
