package classesJava;

public class SindicateFee extends Fees {
    private String idFee;
    private double value;

    public SindicateFee(String idFee, double value) {
        this.idFee = idFee;
        this.value = value;
    }

    public String getIdFee() {
        return idFee;
    }

    public void setIdFee(String idFee) {
        this.idFee = idFee;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public void setValue(double value) {
        this.value = value;
    }
}
