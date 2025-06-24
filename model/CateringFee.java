package model;
import interfaces.FeeComponent;

//create concrete components
public class CateringFee implements FeeComponent {
    private final int pax;

    public CateringFee(int pax) {
        this.pax = pax;
    }

    @Override
    public double getFee() {
        return 50 * pax;
    }

    @Override
    public String getDescription() {
        return "Catering Fee";
    }
}
