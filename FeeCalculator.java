public class FeeCalculator {
    private final double baseFeePerPax;
    private final int pax;
    private final boolean transportSelected;
    private final boolean cateringSelected;

    public FeeCalculator(double baseFeePerPax, int pax, boolean transportSelected, boolean cateringSelected){
        this.baseFeePerPax = baseFeePerPax;
        this.pax = pax;
        this.transportSelected = transportSelected;
        this.cateringSelected = cateringSelected;
    }

    public FeeBreakdown calculate() {
        FeeGroup group = new FeeGroup();
        group.add(new BaseFee(baseFeePerPax, pax));

        if (transportSelected) group.add(new TransportFee(pax));
        if (cateringSelected) group.add(new CateringFee(pax));

        double baseTotal = baseFeePerPax * pax;
        double transportFee = transportSelected ? 50 * pax : 0;
        double cateringFee = cateringSelected ? 50 * pax : 0;
        double totalBeforeDiscount = baseTotal + transportFee + cateringFee;
        double discount = totalBeforeDiscount * 0.05;
        double finalAmount = totalBeforeDiscount - discount;

        return new FeeBreakdown(baseFeePerPax, baseTotal, transportFee, cateringFee,
                                totalBeforeDiscount, discount, finalAmount);
    }
}

