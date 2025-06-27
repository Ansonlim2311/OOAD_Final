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
import model.SeminarEvent;
import model.SportsEvents;
import model.WorkshopsEvent;
import model.CulturalEvents;

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

        // newEvent = new Event(name, date, venue, type, capacity, fee);
        switch(type) {
            case "Seminars":
                newEvent = new SeminarEvent(name, date, venue, type, capacity, fee);
                break;
            case "Sports Events":
                newEvent = new SportsEvents(name, date, venue, type, capacity, fee);
                break;
            case "Workshops":
                newEvent = new WorkshopsEvent(name, date, venue, type, capacity, fee);
                break;
            case "Cultural Events":
                newEvent = new CulturalEvents(name, date, venue, type, capacity, fee);
                break;
            default:
                JOptionPane.showMessageDialog(formPanel,
                        "Invalid event type selected.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
        }
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