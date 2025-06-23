//helper ckass ( similar concept like calling a function from another file )
public class FeeBreakdown {
    public final double baseFeePerPax;
    public final double baseTotal;
    public final double transportFee;
    public final double cateringFee;
    public final double totalBeforeDiscount;
    public final double discount;
    public final double finalAmount;

    public FeeBreakdown(double baseFeePerPax, double baseTotal, double transportFee, double cateringFee,
                        double totalBeforeDiscount, double discount, double finalAmount) {
        this.baseFeePerPax = baseFeePerPax;
        this.baseTotal = baseTotal;
        this.transportFee = transportFee;
        this.cateringFee = cateringFee;
        this.totalBeforeDiscount = totalBeforeDiscount;
        this.discount = discount;
        this.finalAmount = finalAmount;
    }
}
