import java.util.ArrayList;
import java.util.List;

public class FeeCalculator {
    private final double baseFeePerPax;
    private final int pax;
    private final boolean transportSelected;
    private final boolean cateringSelected;
    private final FeeGroup feeGroup;

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
        List<FeeComponent> allFeeComponents = new ArrayList<>(feeGroup.getComponents());

        FeeComponent subTotal = new SubTotalFee(feeGroup);
        FeeComponent discount = new Discount(feeGroup, 0.05);
        FeeComponent finalFee = new FinalFee(subTotal, discount);

        allFeeComponents.add(subTotal);
        allFeeComponents.add(discount);
        allFeeComponents.add(finalFee);

        return allFeeComponents;
    }
}