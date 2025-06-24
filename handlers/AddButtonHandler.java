package handlers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import model.Event;
import model.EventManager;
import table.EventTable;
import ui.EventFormPanel;
import util.Getvalue;

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
        if (!Getvalue.validateAll(formPanel)) {
            return;
        }

        String name = Getvalue.getEventName(formPanel);
        String date = Getvalue.getDate(formPanel);
        String venue = Getvalue.getVenue(formPanel);
        String type = Getvalue.getTypeEvent(formPanel);
        int capacity = Getvalue.getCapacity(formPanel);
        double fee = Getvalue.getRegistrationFee(formPanel);

        // Print or show dialog
        System.out.println("Event Name: " + name);
        System.out.println("Date: " + date);
        System.out.println("Venue: " + venue);
        System.out.println("Type: " + type);
        System.out.println("Capacity: " + capacity);
        System.out.println("Fee: RM" + fee);

        Event newEvent = new Event(name, date, venue, type, capacity, fee);
        eventManager.addEvent(newEvent); // <-- 确保 EventManager 有 addEvent 方法

    // 通知表格数据已更新
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
        Getvalue.clearForm(formPanel);
    }

    
}
