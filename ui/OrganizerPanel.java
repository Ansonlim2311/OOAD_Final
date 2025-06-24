package ui;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import handlers.AddButtonHandler;
import handlers.DeleteButtonHandler;
import handlers.UpdateButtonHandler;
import main.CampusEventManagementSystem;
import model.EventManager;
import table.EventTable;
import util.CreateButton;
import util.Getvalue;

import java.awt.*;

public class OrganizerPanel extends JPanel {
    private JButton addButton, deleteButton, updateButton;
    private EventFormPanel formPanel;

    public OrganizerPanel(CampusEventManagementSystem controller, EventManager eventManager) {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        // -------- Split Pane --------
        JSplitPane mainContentSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        mainContentSplitPane.setDividerLocation(320);
        mainContentSplitPane.setDividerSize(5);
        mainContentSplitPane.setContinuousLayout(true);

        // -------- Left Panel: Form --------
        formPanel = new EventFormPanel();
        mainContentSplitPane.setLeftComponent(formPanel);

        // -------- Right Panel: Table --------
        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.setBackground(Color.WHITE);
        listPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        EventTable tableModel = new EventTable(eventManager.getEvents()); // ✅ only here
        JTable eventTable = new JTable(tableModel);
        eventTable.setFont(new Font("Monospaced", Font.BOLD, 22));
        eventTable.setRowHeight(28);
        eventTable.getTableHeader().setReorderingAllowed(false);
        eventTable.getTableHeader().setFont(new Font("Monospaced", Font.BOLD, 20));
        JScrollPane scrollPane = new JScrollPane(eventTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Event List"));
        listPanel.add(scrollPane, BorderLayout.CENTER);

        mainContentSplitPane.setRightComponent(listPanel);
        add(mainContentSplitPane, BorderLayout.CENTER);

        // -------- Button Panel --------
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        addButton = CreateButton.createStyledButton("Add", 100, 35);
        deleteButton = CreateButton.createStyledButton("Delete", 100, 35);
        updateButton = CreateButton.createStyledButton("Update", 100, 35);

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // ✅ Register the handler here using the same tableModel
        addButton.addActionListener(new AddButtonHandler(formPanel, eventManager, tableModel));
        deleteButton.addActionListener(new DeleteButtonHandler(formPanel,eventTable, eventManager, tableModel));
        updateButton.addActionListener(new UpdateButtonHandler(formPanel, eventManager, tableModel, eventTable));


        eventTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = eventTable.getSelectedRow();
                    if (selectedRow >= 0) {
                        formPanel.eventNameField.setText(eventTable.getValueAt(selectedRow, 0).toString());
                        formPanel.dateField.setText(eventTable.getValueAt(selectedRow, 1).toString());
                        formPanel.venue.setSelectedItem(eventTable.getValueAt(selectedRow, 2).toString());
                        formPanel.typeevent.setSelectedItem(eventTable.getValueAt(selectedRow, 3).toString());
                        formPanel.capacityField.setValue(Integer.parseInt(eventTable.getValueAt(selectedRow, 4).toString()));
                        formPanel.registrationField.setValue(Double.parseDouble(eventTable.getValueAt(selectedRow, 5).toString()));

                        addButton.setEnabled(false);
                    }
                    else {
                        // Clear the form if no row is selected
                        Getvalue.clearForm(formPanel);
                        addButton.setEnabled(true);
                    }
                }
            }
        });
    }
}
