package model;
import interfaces.FeeComponent;

public class SubTotalFee implements FeeComponent {
    private final FeeGroup feeGroup;

    public SubTotalFee(FeeGroup feeGroup) {
        this.feeGroup = feeGroup;
    }

    @Override
    public double getFee() {
        return feeGroup.getFee();
    }

    @Override
    public String getDescription() {
        return "Total Amount Before Discount";
    }
}