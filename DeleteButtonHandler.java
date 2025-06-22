import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

import javax.swing.table.DefaultTableModel;

public class DeleteButtonHandler implements ActionListener {
    private JTable eventTable;
    private EventManager eventManager;
    private DefaultTableModel tableModel;

    public DeleteButtonHandler(JTable eventTable, EventManager eventManager, DefaultTableModel tableModel) {
        this.eventTable = eventTable;
        this.eventManager = eventManager;
        this.tableModel = tableModel;
    }

    @Override
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
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            // Get the event ID from the table model
            int eventId = (int) tableModel.getValueAt(selectedRow, 0);
            eventManager.deleteEvent(eventId);
            tableModel.removeRow(selectedRow);
        }
    }
}
