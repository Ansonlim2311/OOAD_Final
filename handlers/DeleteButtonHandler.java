package handlers;
import javax.swing.*;

import model.Event;
import model.EventManager;
import table.EventTable;
import ui.EventFormPanel;
import util.GetValue;

import java.awt.event.*;

public class DeleteButtonHandler implements ActionListener {
    private JTable eventTable;
    private EventManager eventManager;
    private EventTable eventTableModel; // This is your custom TableModel
    private EventFormPanel formPanel;
    private GetValue getValue;
    private int selectedRow, confirm;

    public DeleteButtonHandler(EventFormPanel formPanel, JTable eventTable, EventManager eventManager, EventTable eventTableModel) {
        this.formPanel = formPanel;
        this.eventTable = eventTable;
        this.eventManager = eventManager;
        this.eventTableModel = eventTableModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getValue = new GetValue(formPanel);
        selectedRow = eventTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(eventTable,
                    "Please select an event to delete.",
                    "No Selection",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        confirm = JOptionPane.showConfirmDialog(eventTable,
                "Are you sure you want to delete the selected event?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // 获取要删除的事件对象
                Event toDelete = eventManager.getEvents().get(selectedRow);
                eventManager.deleteEvent(toDelete.getId());

                // 更新表格
                eventTableModel.fireTableDataChanged();

                // 提示删除成功
                JOptionPane.showMessageDialog(eventTable, "Event deleted successfully!", "Delete Success", JOptionPane.INFORMATION_MESSAGE);

                // 清空表单
                getValue.clearForm();

            } catch (IndexOutOfBoundsException ex) {
                JOptionPane.showMessageDialog(eventTable,
                        "Error: No event found at the selected row index. The list might have changed.",
                        "Deletion Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(eventTable,
                        "An unexpected error occurred during deletion: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }
}