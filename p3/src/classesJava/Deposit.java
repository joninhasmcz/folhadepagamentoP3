package classesJava;

public class Deposit extends PaymentMethod {

    private String account;
    private String agency;

    public Deposit(String account, String agency) {
        this.account = account;
        this.agency = agency;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }
}
