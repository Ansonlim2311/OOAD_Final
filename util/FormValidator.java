package util;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import ui.EventFormPanel;

public class FormValidator {
    private final EventFormPanel formPanel;
    private final JComponent parentComponent;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
    private String name, dateText, venue, type;
    private double fee;

    public FormValidator(EventFormPanel formPanel, JComponent parentComponent) {
        this.formPanel = formPanel;
        this.parentComponent = parentComponent;
    }

    // method to validate all fields before submission
    public boolean validateAll() {
        // Event Name
        name = formPanel.getEventName();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(parentComponent, "Event name cannot be empty.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Date: format = d-M-yyyy (accepts 6-6-2025)
        dateText = formPanel.getDate();
        try {
            LocalDate.parse(dateText, formatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(parentComponent,
                    "Date must be valid and in format (dd-MM-yyyy), e.g. 6-6-2025.",
                    "Input Error",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Venue
        venue = formPanel.getVenue();
        if (venue == null || venue.trim().isEmpty() || venue.equalsIgnoreCase("None")) {
            JOptionPane.showMessageDialog(parentComponent,
                    "Venue cannot be empty.\nPlease select a valid venue.",
                    "Input Error",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Event Type
        type = formPanel.getTypeEvent();
        if (type == null || type.trim().isEmpty() || type.equalsIgnoreCase("None")) {
            JOptionPane.showMessageDialog(parentComponent,
                    "Event Type cannot be empty.\nPlease select a valid Event Type.",
                    "Input Error",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Registration Fee
        fee = formPanel.getRegistrationFee();
        if (fee < 0) {
            JOptionPane.showMessageDialog(parentComponent,
                    "Registration fee cannot be negative.",
                    "Input Error",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
}