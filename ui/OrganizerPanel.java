package ui;

import java.awt.*;
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

public class OrganizerPanel extends JPanel {
    private JButton addButton, deleteButton, updateButton;
    private JSplitPane mainContentSplitPane;
    private JPanel listPanel;
    private EventTable tableModel;
    private JTable eventTable;
    private JScrollPane scrollPane;
    private EventFormPanel formPanel;
    private CreateButton buttonCreator = new CreateButton();

    public OrganizerPanel(CampusEventManagementSystem controller, EventManager eventManager) {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        // -------- Split Pane --------
        mainContentSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        mainContentSplitPane.setDividerLocation(320);
        mainContentSplitPane.setDividerSize(5);
        mainContentSplitPane.setContinuousLayout(true);

        // -------- Left Panel: Form --------
        formPanel = new EventFormPanel();
        formPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 25));
        mainContentSplitPane.setLeftComponent(formPanel);

        // -------- Right Panel: Table --------
        listPanel = new JPanel(new BorderLayout());
        listPanel.setBackground(Color.WHITE);
        listPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        tableModel = new EventTable(eventManager.getEvents());
        eventTable = new JTable(tableModel);
        eventTable.setFont(new Font("Monospaced", Font.BOLD, 22));
        eventTable.setRowHeight(28);
        eventTable.getTableHeader().setReorderingAllowed(false);
        eventTable.getTableHeader().setFont(new Font("Monospaced", Font.BOLD, 20));
        scrollPane = new JScrollPane(eventTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Event List"));
        listPanel.add(scrollPane, BorderLayout.CENTER);

        mainContentSplitPane.setRightComponent(listPanel);
        add(mainContentSplitPane, BorderLayout.CENTER);

        // -------- Button Panel --------
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        addButton = buttonCreator.createStyledButton("Add", 100, 35);
        deleteButton = buttonCreator.createStyledButton("Delete", 100, 35);
        updateButton = buttonCreator.createStyledButton("Update", 100, 35);

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Register the handler here using the same tableModel
        addButton.addActionListener(new AddButtonHandler(formPanel, eventManager, tableModel));
        deleteButton.addActionListener(new DeleteButtonHandler(formPanel,eventTable, eventManager, tableModel));
        updateButton.addActionListener(new UpdateButtonHandler(formPanel, eventManager, tableModel, eventTable));


        eventTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = eventTable.getSelectedRow();
                    if (selectedRow >= 0) {
                        formPanel.setEventName(eventTable.getValueAt(selectedRow, 0).toString());
                        formPanel.setDate(eventTable.getValueAt(selectedRow, 1).toString());
                        formPanel.setVenue(eventTable.getValueAt(selectedRow, 2).toString());
                        formPanel.setTypeEvent(eventTable.getValueAt(selectedRow, 3).toString());
                        formPanel.setCapacity(Integer.parseInt(eventTable.getValueAt(selectedRow, 4).toString()));
                        formPanel.setRegistrationFee(Double.parseDouble(eventTable.getValueAt(selectedRow, 5).toString()));

                        addButton.setEnabled(false);
                    }
                    else {
                        // Clear the form if no row is selected
                        formPanel.clearForm();
                        addButton.setEnabled(true);
                    }
                }
            }
        });
    }
}