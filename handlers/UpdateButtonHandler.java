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

public class UpdateButtonHandler implements ActionListener {
    private EventFormPanel formPanel;
    private EventManager eventManager;
    private EventTable eventTable;
    private JTable table;
    private FormDataExtractor data;
    private FormValidator validator;
    private int selectedRow, eventId, capacity;
    private String name, date, venue, type;
    private double fee;
    private Event updatedEvent, oldEvent;

    public UpdateButtonHandler(EventFormPanel formPanel, EventManager eventManager, EventTable eventTable, JTable table) {
        this.formPanel = formPanel;
        this.eventManager = eventManager;
        this.eventTable = eventTable;
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        data = new FormDataExtractor(formPanel);
        validator = new FormValidator(data, formPanel);
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
        name = data.getEventName();
        date = data.getDate();
        venue = data.getVenue();
        type = data.getTypeEvent();
        capacity = data.getCapacity();
        fee = data.getRegistrationFee();

        // 用新数据构造新 Event（保留原 ID）
        updatedEvent = new Event(eventId, name, date, venue, type, capacity, fee);
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

        data.clearForm();
    }
}