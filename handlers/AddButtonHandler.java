package handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import model.Event;
import model.EventManager;
import table.EventTable;
import ui.EventFormPanel;
import util.FormDataExtractor;
import util.FormValidator;
import model.EventFactory;

public class AddButtonHandler implements ActionListener {
    private EventFormPanel formPanel;
    private EventManager eventManager;
    private EventTable eventTable;
    private String name, date, venue, type;
    private int capacity;
    private double fee;
    private FormDataExtractor data;
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
        data = new FormDataExtractor(formPanel);
        validator = new FormValidator(data, formPanel);

        if (!validator.validateAll()) {
            return;
        }

        name = data.getEventName();
        date = data.getDate();
        venue = data.getVenue();
        type = data.getTypeEvent();
        capacity = data.getCapacity();
        fee = data.getRegistrationFee();

        newEvent = eventFactory.create(name, date, venue, type, capacity, fee);
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
        data.clearForm();
    }
}