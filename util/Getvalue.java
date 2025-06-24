package util;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import ui.EventFormPanel;

public class GetValue {
    private final EventFormPanel formPanel;

    public GetValue(EventFormPanel formPanel) {
        this.formPanel = formPanel;
    }

    public String getEventName() {
        return formPanel.eventNameField.getText().trim();
    }

    public String getDate() {
        return formPanel.dateField.getText().trim();
    }

    public String getVenue() {
        return (String) formPanel.venue.getSelectedItem();
    }

    public String getTypeEvent() {
        return (String) formPanel.typeevent.getSelectedItem();
    }

    public int getCapacity() {
        return (Integer) formPanel.capacityField.getValue();
    }

    public double getRegistrationFee() {
        return ((Number) formPanel.registrationField.getValue()).doubleValue();
    }

    // ✅ New method to validate all fields before submission
    public boolean validateAll() {
        // Event Name
        String name = formPanel.eventNameField.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(formPanel, "Event name cannot be empty.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Date: format = d-M-yyyy (accepts 6-6-2025)
        String dateText = formPanel.dateField.getText().trim();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
        try {
            LocalDate date = LocalDate.parse(dateText, formatter);

            // Check valid day and month range (redundant here since LocalDate handles it)
            int month = date.getMonthValue();
            int day = date.getDayOfMonth();
            if (month > 12 || day > 31) {
                throw new DateTimeParseException("Invalid month/day", dateText, 0);
            }

        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(formPanel,
                    "Date must be valid and in format (dd-MM-yyyy), e.g. 6-6-2025.",
                    "Input Error",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Venue
        String venue = (String) formPanel.venue.getSelectedItem();
        if (venue == null || venue.trim().isEmpty() || venue.equalsIgnoreCase("None")) {
            JOptionPane.showMessageDialog(formPanel,
                    "Venue cannot be empty.\nPlease select a valid venue.",
                    "Input Error",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Event Type
        String type = (String) formPanel.typeevent.getSelectedItem();
        if (type == null || type.trim().isEmpty() || type.equalsIgnoreCase("None")) {
            JOptionPane.showMessageDialog(formPanel,
                    "Event Type cannot be empty.\nPlease select a valid Event Type.",
                    "Input Error",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }


        // Registration Fee
        double fee = ((Number) formPanel.registrationField.getValue()).doubleValue();
        if (fee < 0) {
            JOptionPane.showMessageDialog(formPanel,
                    "Registration fee cannot be negative.",
                    "Input Error",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true; // ✅ All validations passed
    }

    public void clearForm() {
        formPanel.eventNameField.setText("");
        formPanel.dateField.setText("DD-MM-YYYY");
        formPanel.venue.setSelectedIndex(0);
        formPanel.typeevent.setSelectedIndex(0);
        formPanel.capacityField.setValue(1);
        formPanel.registrationField.setValue(   1);
    }
}