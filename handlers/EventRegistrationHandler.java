package handlers;

import interfaces.RegistrationNavigator;
import model.Event;
import model.FeeCalculator;

//create this class is to accept all needed data, perform fee calculation, show breakdown panel
public class EventRegistrationHandler {
    // Fields + Constructor (same as before)
    private final Event event;
    private final int pax;
    private final boolean transportSelected;
    private final boolean cateringSelected;
    private final RegistrationNavigator navigator;
    private double baseFee;
    private FeeCalculator feeBreakDown;

    public EventRegistrationHandler(Event event, int pax, boolean transportSelected, boolean cateringSelected, RegistrationNavigator navigator){
        this.event = event;
        this.pax = pax;
        this.transportSelected = transportSelected;
        this.cateringSelected = cateringSelected;
        this.navigator = navigator;
    }

    public void processRegistration() {
        baseFee = event.getBaseFee();

        feeBreakDown = new FeeCalculator(baseFee, pax, transportSelected, cateringSelected);

        navigator.nagivateToFeePanel(event, feeBreakDown);
    }
}