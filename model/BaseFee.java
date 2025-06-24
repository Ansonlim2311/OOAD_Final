package model;
import interfaces.FeeComponent;

public class BaseFee implements FeeComponent {
    private final double baseFee; 
    private final int pax; // use final to make sure variable cant changed ice assigned

    public BaseFee(double baseFee, int pax) {
        this.baseFee = baseFee;
        this.pax = pax;
    }

    @Override
    public double getFee() {
        return baseFee * pax;
    }

    @Override
    public String getDescription() {
        return "Base Fee";
    }
}