public class BaseFee implements FeeComponent {
    private final String description;
    private final double amout;

    public BaseFee(String description, double amount) {
        this.description = description;
        this.amout = amount;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getAmount() {
        return amout;
    }
}