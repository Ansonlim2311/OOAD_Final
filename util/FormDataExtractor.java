package util;

import ui.EventFormPanel;

public class FormDataExtractor {
    private final EventFormPanel formPanel;

    public FormDataExtractor(EventFormPanel formPanel) {
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

    public void clearForm() {
        formPanel.eventNameField.setText("");
        formPanel.dateField.setText("DD-MM-YYYY");
        formPanel.venue.setSelectedIndex(0);
        formPanel.typeevent.setSelectedIndex(0);
        formPanel.capacityField.setValue(1);
        formPanel.registrationField.setValue(   1);
    }
}