package model;

import java.util.ArrayList;
import java.util.List;

import interfaces.FeeComponent;

public class FeeCalculator {
    private final double baseFeePerPax;
    private final int pax;
    private final boolean transportSelected;
    private final boolean cateringSelected;
    private final FeeGroup feeGroup;
    private FeeComponent subTotal, discount, finalFee;
    private List<FeeComponent> allFeeComponents;

    public FeeCalculator(double baseFeePerPax, int pax, boolean transportSelected, boolean cateringSelected){
        this.baseFeePerPax = baseFeePerPax;
        this.pax = pax;
        this.transportSelected = transportSelected;
        this.cateringSelected = cateringSelected;
        this.feeGroup = new FeeGroup();
        setFeeGroup();
    }

    private void setFeeGroup() {
        feeGroup.add(new BaseFee(baseFeePerPax, pax));
        if (transportSelected) {
            feeGroup.add(new TransportFee(pax));
        } else {
            feeGroup.add(new TransportFee(0));
        }
        if (cateringSelected) {
            feeGroup.add(new CateringFee(pax));
        } else {
            feeGroup.add(new CateringFee(0));
        }
    }

    public FeeGroup getFeeGroup() {
        return feeGroup;
    }

    public List<FeeComponent> getDetailedFeeComponent() {
        allFeeComponents = new ArrayList<>(feeGroup.getComponents());

        subTotal = new SubTotalFee(feeGroup);

        if (subTotal.getFee() >= 2000 && pax >= 5) {
            discount = new Discount(feeGroup, 0.10);
        } else if (subTotal.getFee() >= 2000 || pax >= 5) {
            discount = new Discount(feeGroup, 0.05);
        } else {
            discount = new Discount(feeGroup, 0.00);
        }
        finalFee = new FinalFee(subTotal, discount);

        allFeeComponents.add(subTotal);
        allFeeComponents.add(discount);
        allFeeComponents.add(finalFee);

        return allFeeComponents;
    }
}