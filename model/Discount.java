package model;
import interfaces.FeeComponent;

public class Discount implements FeeComponent {
    private final FeeComponent component;
    private final double discountRate;

    public Discount(FeeComponent component, double discountRate) {
        this.component = component;
        this.discountRate = discountRate;
    }

    @Override
    public double getFee() {
        return component.getFee() * (discountRate);
    }

    @Override
    public String getDescription() {
        return "Total After Discount (" + (discountRate * 100) + "%)";
    }

}