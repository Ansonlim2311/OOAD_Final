package table;
import javax.swing.table.AbstractTableModel;

import model.Event;

import java.util.List;

public class EventTable extends AbstractTableModel{
    private final String[] columnNames = {"Event Name", "Date", "Venue", "Event Type", "Capacity", "Base Fee"};
    private final List<Event> events;
    private Event event;

    public EventTable(List<Event> events) {
        this.events = events;
    }

    @Override
    public int getRowCount() {
        return events.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        event = events.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> event.getEventName();
            case 1 -> event.getDate();
            case 2 -> event.getVenue();
            case 3 -> event.getEventType();
            case 4 -> event.getCapacity();
            case 5 -> event.getBaseFee();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public Event getEventAt(int rowIndex) {
        return events.get(rowIndex);
    }
}