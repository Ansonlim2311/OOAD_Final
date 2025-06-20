import javax.swing.table.AbstractTableModel;
import java.util.List;

public class EventTable extends AbstractTableModel{
    private final String[] columnNames = {"Event Name", "Date", "Venue", "Event Type", "Capacity", "Base Fee"};
    private final List<Event> events;

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
        Event event = events.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> event.getEventName();
            case 1 -> event.getCapacity();
            case 2 -> event.getDate();
            case 3 -> event.getEventType();
            case 4 -> event.getBaseFee();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
