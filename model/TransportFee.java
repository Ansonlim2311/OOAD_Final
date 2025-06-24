package model;
import interfaces.FeeComponent;

public class TransportFee implements FeeComponent {
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

