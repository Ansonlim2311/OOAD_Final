package handlers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import model.Event;
import model.EventManager;
import table.EventTable;
import ui.EventFormPanel;
import util.GetValue;

public class AddButtonHandler implements ActionListener {
    private EventFormPanel formPanel;
    private EventManager eventManager;
    private EventTable eventTable;

    public AddButtonHandler(EventFormPanel formPanel, EventManager eventManager, EventTable eventTable) {
        this.formPanel = formPanel;
        this.eventManager = eventManager;
        this.eventTable = eventTable;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        GetValue getValue = new GetValue(formPanel);

        if (!getValue.validateAll()) {
            return;
        }

        String name = getValue.getEventName();
        String date = getValue.getDate();
        String venue = getValue.getVenue();
        String type = getValue.getTypeEvent();
        int capacity = getValue.getCapacity();
        double fee = getValue.getRegistrationFee();

        // Print or show dialog
        System.out.println("Event Name: " + name);
        System.out.println("Date: " + date);
        System.out.println("Venue: " + venue);
        System.out.println("Type: " + type);
        System.out.println("Capacity: " + capacity);
        System.out.println("Fee: RM" + fee);

        Event newEvent = new Event(name, date, venue, type, capacity, fee);
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
        getValue.clearForm(formPanel);
    }

    
}
