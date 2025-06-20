public class Discount implements FeeComponent {
    private final String description;
    private final double amount;

    public Discount(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getAmount() {
        return -amount;
    }
}