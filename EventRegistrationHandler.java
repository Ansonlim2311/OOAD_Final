//create this class is to accept all needed data, perform fee calculation, show breakdown panel
public class EventRegistrationHandler {
    // Fields + Constructor (same as before)
    private final Event event;
    private final int pax;
    private final boolean transportSelected;
    private final boolean cateringSelected;
    private final RegistrationNavigator navigator;

    public EventRegistrationHandler(Event event, int pax, boolean transportSelected, boolean cateringSelected, RegistrationNavigator navigator){
        this.event = event;
        this.pax = pax;
        this.transportSelected = transportSelected;
        this.cateringSelected = cateringSelected;
        this.navigator = navigator;
    }

    public void processRegistration() {
        double baseFee = event.getBaseFee();

        FeeCalculator calculator = new FeeCalculator(baseFee, pax, transportSelected, cateringSelected);
        FeeBreakdown result = calculator.calculate();

        navigator.nagivateToFeePanel(event, result);

        // Print results
        System.out.println("===== Event Registration Summary =====");
        System.out.println("Event Name: " + event.getEventName()); //getter and setter
        System.out.println("Base Fee (RM): " + result.baseTotal);
        System.out.println("Transportation Fee (RM): " + result.transportFee);
        System.out.println("Catering Fee (RM): " + result.cateringFee);
        System.out.println("Subtotal (RM): " + result.totalBeforeDiscount);
        System.out.println("Discount (5%): -RM" + result.discount);
        System.out.println("Total Amount (RM): " + result.finalAmount);
        System.out.println("======================================");
    }
}