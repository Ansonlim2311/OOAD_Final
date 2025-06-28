package handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import model.Event;
import model.EventManager;
import table.EventTable;
import ui.EventFormPanel;
import util.FormValidator;
import model.EventFactory;

public class AddButtonHandler implements ActionListener {
    private EventFormPanel formPanel;
    private EventManager eventManager;
    private EventTable eventTable;
    private String name, date, venue, type;
    private int capacity;
    private double fee;
    private FormValidator validator;
    private Event newEvent;
    private EventFactory eventFactory = new EventFactory();

    public AddButtonHandler(EventFormPanel formPanel, EventManager eventManager, EventTable eventTable) {
        this.formPanel = formPanel;
        this.eventManager = eventManager;
        this.eventTable = eventTable;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        validator = new FormValidator(formPanel, formPanel);

        if (!validator.validateAll()) {
            return;
        }

        name = formPanel.getEventName();
        date = formPanel.getDate();
        venue = formPanel.getVenue();
        type = formPanel.getTypeEvent();
        capacity = formPanel.getCapacity();
        fee = formPanel.getRegistrationFee();

        newEvent = eventFactory.create(name, date, venue, type, capacity, fee);
        eventFactory.create(name, date, venue, type, capacity, fee);
        eventManager.addEvent(newEvent); 
        eventTable.fireTableDataChanged();

        JOptionPane.showMessageDialog(formPanel,
                "Added Event:\n" +
                "Name: " + name + "\n" +
                "Date: " + date + "\n" +
                "Venue: " + venue + "\n" +
                "Type: " + type + "\n" +
                "Capacity: " + capacity + "\n" +
                "Fee: RM" + fee,
                "Event Added",
                JOptionPane.INFORMATION_MESSAGE
        );
        formPanel.clearForm();
    }
}