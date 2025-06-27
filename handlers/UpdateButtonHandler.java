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

public class UpdateButtonHandler implements ActionListener {
    private EventFormPanel formPanel;
    private EventManager eventManager;
    private EventTable eventTable;
    private JTable table;
    private FormValidator validator;
    private int selectedRow, eventId, capacity;
    private String name, date, venue, type;
    private double fee;
    private Event updatedEvent, oldEvent;
    private EventFactory eventFactory = new EventFactory();

    public UpdateButtonHandler(EventFormPanel formPanel, EventManager eventManager, EventTable eventTable, JTable table) {
        this.formPanel = formPanel;
        this.eventManager = eventManager;
        this.eventTable = eventTable;
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        validator = new FormValidator(formPanel, formPanel);
        selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(table, "Please select an event to update.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!validator.validateAll()) {
            return;
        }

        // 获取旧 Event 的 ID
        oldEvent = eventManager.getEvents().get(selectedRow);
        eventId = oldEvent.getId(); // 保留原 ID

        // 收集新数据
        name = formPanel.getEventName();
        date = formPanel.getDate();
        venue = formPanel.getVenue();
        type = formPanel.getTypeEvent();
        capacity = formPanel.getCapacity();
        fee = formPanel.getRegistrationFee();

        updatedEvent = eventFactory.createWithId(eventId, name, date, venue, type, capacity, fee);
        updatedEvent.setId(eventId);
        eventManager.updateEvent(updatedEvent);

        // 刷新表格
        eventTable.fireTableDataChanged();

        // 弹窗提示
        JOptionPane.showMessageDialog(formPanel,
                "Event updated successfully:\n" +
                "Name: " + name + "\n" +
                "Date: " + date + "\n" +
                "Venue: " + venue + "\n" +
                "Type: " + type + "\n" +
                "Capacity: " + capacity + "\n" +
                "Fee: RM" + fee,
                "Event Updated",
                JOptionPane.INFORMATION_MESSAGE
        );
        formPanel.clearForm();
    }
}