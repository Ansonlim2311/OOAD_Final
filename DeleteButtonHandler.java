public class DeleteButtonHandler {
    private JTable eventTable;
    private EventManager eventManager;
    private EventTable tableModel;

    public DeleteButtonHandler(JTable eventTable, EventManager eventManager, EventTable tableModel) {
        this.eventTable = eventTable;
        this.eventManager = eventManager;
        this.tableModel = tableModel;
    }

    public void actionPerformed(ActionEvent e) {
        int selectedRow = eventTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(eventTable,
                    "Please select an event to delete.",
                    "No Selection",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(eventTable,
                "Are you sure you want to delete the selected event?",
                "Confirm Deletion",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            // Remove the selected event from the manager
            Event eventToDelete = tableModel.getEventAt(selectedRow);
            eventManager.getEvents().remove(eventToDelete);
            
            // Notify the table model that the data has changed
            tableModel.fireTableDataChanged();
            
            JOptionPane.showMessageDialog(eventTable,
                    "Event deleted successfully.",
                    "Deletion Successful",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
