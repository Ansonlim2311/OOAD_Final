package handlers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import model.Event;
import model.EventManager;
import table.EventTable;
import ui.EventFormPanel;
import util.GetValue;

public class UpdateButtonHandler implements ActionListener {
    private EventFormPanel formPanel;
    private EventManager eventManager;
    private EventTable eventTable;
    private JTable table; // 用于获取 selectedRow
    private GetValue getValue;
    private int selectedRow, eventId, capacity;
    private String name, date, venue, type;
    private double fee;
    private Event updatedEvent;

    public UpdateButtonHandler(EventFormPanel formPanel, EventManager eventManager, EventTable eventTable, JTable table) {
        this.formPanel = formPanel;
        this.eventManager = eventManager;
        this.eventTable = eventTable;
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getValue = new GetValue(formPanel);
        selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(table, "Please select an event to update.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!getValue.validateAll()) {
            return;
        }

        // 获取旧 Event 的 ID
        Event oldEvent = eventManager.getEvents().get(selectedRow);
        eventId = oldEvent.getId(); // 保留原 ID

        // 收集新数据
        name = getValue.getEventName();
        date = getValue.getDate();
        venue = getValue.getVenue();
        type = getValue.getTypeEvent();
        capacity = getValue.getCapacity();
        fee = getValue.getRegistrationFee();

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

        getValue.clearForm();
    }
}