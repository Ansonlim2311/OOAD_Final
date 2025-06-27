package model;

import interfaces.AdditionalService;

public class TransportFee implements AdditionalService {
    private final int pax;

    public TransportFee(int pax){
        this.pax = pax;
    }

    @Override
    public double getFee() {
    return 50 * pax;
    } 

    @Override
    public String getDescription() {
        return "Transporation Fee" ; 
    }
}

