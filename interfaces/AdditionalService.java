package interfaces;

public interface AdditionalService extends FeeComponent {
    default double getCost() {
        return getFee();
    }
}
