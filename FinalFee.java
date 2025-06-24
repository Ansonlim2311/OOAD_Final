public class FinalFee implements FeeComponent {
    private final FeeComponent originalComponent;
    private final FeeComponent discountedComponent;

    public FinalFee(FeeComponent originalComponent, FeeComponent discountedComponent) {
        this.originalComponent = originalComponent;
        this.discountedComponent = discountedComponent;
    }

    @Override
    public double getFee() {
        return originalComponent.getFee() - discountedComponent.getFee();
    }

    @Override
    public String getDescription() {
        return "Total Amout (After Discount)";
    }
}