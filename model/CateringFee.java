package model;

import interfaces.AdditionalService;

//create concrete components
public class CateringFee implements AdditionalService {
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
