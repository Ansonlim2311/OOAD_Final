package interfaces;

import model.Event;
import model.FeeCalculator;

public interface RegistrationNavigator {
    void nagivateToFeePanel(Event event, FeeCalculator breakdownFee);
}