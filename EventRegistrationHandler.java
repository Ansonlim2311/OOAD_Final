//create this class is to accept all needed data, perform fee calculation, show breakdown panel
import javax.swing.*;

public class EventRegistrationHandler {
    public static void processFromUI(JTable eventTable, JComboBox<Integer> paxDropdown,
                                     JCheckBox transportOption, JCheckBox cateringOption) {
        int row = eventTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Please select an event.");
            return;
        }

        int pax = (int) paxDropdown.getSelectedItem();
        boolean transport = transportOption.isSelected();
        boolean catering = cateringOption.isSelected();

        Event event = ((EventTable) eventTable.getModel()).getEventAt(row); //get event at eventTable

        // Do the rest using your original instance-based handler
        EventRegistrationHandler handler = new EventRegistrationHandler(event, pax, transport, catering);
        handler.processRegistration();
    }

    // Fields + Constructor (same as before)
    private final Event event;
    private final int pax;
    private final boolean transportSelected;
    private final boolean cateringSelected;

    public EventRegistrationHandler(Event event, int pax, boolean transportSelected, boolean cateringSelected){
        this.event = event;
        this.pax = pax;
        this.transportSelected = transportSelected;
        this.cateringSelected = cateringSelected;
    }

    public void processRegistration() {
        double baseFee = event.getBaseFee();

        FeeCalculator calculator = new FeeCalculator(baseFee, pax, transportSelected, cateringSelected);
        FeeBreakdown result = calculator.calculate();

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


