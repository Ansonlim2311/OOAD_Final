package ui;

import javax.swing.*;
import java.awt.*;

import handlers.EventRegistrationHandler;
import main.CampusEventManagementSystem;
import model.Event;
import model.EventManager;
import table.EventTable;
import util.CreateButton;

public class ParticipatePanel extends JPanel {
    private JPanel paxBar, paxSelectionPanel, centerPanel, tableWrapper, registerBar, leftPanel, buttonPanel, messageBar;
    private JLabel paxLabel, serviceLabel, messageLabel;
    private JComboBox<Integer> paxDropdown;
    private JTable eventTable;
    private CreateButton buttonCreator = new CreateButton();
    private Integer[] paxOptions = new Integer[50];
    private EventTable model;
    private JScrollPane scrollPane;
    private JCheckBox transportOption, cateringOption;
    private JButton registerButton;
    private EventRegistrationHandler handler;
    private Event event;
    private int row, pax;
    private boolean transport, catering;

    public ParticipatePanel(CampusEventManagementSystem controller, EventManager eventManager) {
        setLayout(new BorderLayout());
        //1.Create a pax selection Bar//
        paxBar = new JPanel(new BorderLayout());
        paxBar.setBackground(Color.WHITE);
        paxBar.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        paxBar.setPreferredSize(new Dimension(0, 40));

         //2.Create pax dropdown + pax label//
        paxSelectionPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,0));
        paxSelectionPanel.setBackground(Color.WHITE);

        paxLabel = new JLabel("Number of pax:");
        paxLabel.setFont(new Font("Monospaced",Font.BOLD,21));

        for (int i = 0 ; i < 50; i++) { 
            paxOptions[i] = i+1;
        }
        
        paxDropdown = new JComboBox<>(paxOptions);
        paxDropdown.setPreferredSize(new Dimension(160,30));
        paxDropdown.setFont(new Font("Monospaced",Font.BOLD,19));

        paxSelectionPanel.add(paxLabel);
        paxSelectionPanel.add(paxDropdown);

        paxBar.add(paxSelectionPanel, BorderLayout.EAST);

        //3.Table panel in center//
        centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        tableWrapper = new JPanel(new BorderLayout());
        tableWrapper.setPreferredSize(new Dimension(1300,650));
        tableWrapper.setBorder(BorderFactory.createTitledBorder("Event List"));
        tableWrapper.setFont(new Font("Monospaced", Font.BOLD, 22));

        model = new EventTable(eventManager.getEvents());
        eventTable = new JTable(model);
        eventTable.setFont(new Font("Monospaced", Font.BOLD, 22));
        eventTable.setRowHeight(28);
        eventTable.getTableHeader().setReorderingAllowed(false);
        eventTable.getTableHeader().setFont(new Font("Monospaced", Font.BOLD, 24));
        scrollPane = new JScrollPane(eventTable);
        tableWrapper.add(scrollPane,BorderLayout.CENTER);

        //4.Register Bar with 2 radio button 
        //Border Layout for main container (register Bar) left right mostly for large section like header 
        registerBar = new JPanel(new BorderLayout());
        registerBar.setPreferredSize(new Dimension(1300,60));
        registerBar.setBackground(Color.WHITE);

        //left side checkbox + services label
        //FlowLayout inside each section (Radio Panel and buttonPanel) mostlyy for buttons, form fields
        leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 20));
        leftPanel.setBackground(Color.WHITE);

        serviceLabel = new JLabel("Additional Services:");
        serviceLabel.setFont(new Font("Monospaced", Font.BOLD, 23));

        transportOption = new JCheckBox("Transportation (RM50/p)");
        transportOption.setFont(new Font("Monospaced",Font.BOLD,23));
        transportOption.setBackground(Color.WHITE);

        cateringOption = new JCheckBox("Catering Service (RM50/p)");
        cateringOption.setFont(new Font("Monospaced",Font.BOLD,23));
        cateringOption.setBackground(Color.WHITE);

        leftPanel.add(serviceLabel);
        leftPanel.add(transportOption);
        leftPanel.add(cateringOption);

        //right side register buttons
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 5));
        buttonPanel.setBackground(Color.WHITE);

        registerButton = buttonCreator.createStyledButton("Register Now", 250, 50);
        registerButton.addActionListener(e -> {
            row = eventTable.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Please select an event.");
                return;
            }

            event = ((EventTable) eventTable.getModel()).getEventAt(row); //get event at eventTable
            pax = (int) paxDropdown.getSelectedItem();
            transport = transportOption.isSelected();
            catering = cateringOption.isSelected();

            // Do the rest using your original instance-based handler
            handler = new EventRegistrationHandler(event, pax, transport, catering, controller);
            handler.processRegistration();
        });

        buttonPanel.add(registerButton);
        registerBar.add(leftPanel,BorderLayout.WEST);
        registerBar.add(buttonPanel,BorderLayout.EAST);

        //5.Message Bar
        messageBar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        messageBar.setPreferredSize(new Dimension(1300,50));
        messageBar.setBackground(Color.WHITE);

        messageLabel = new JLabel("**Each user are allowed only to register an event at each time.**");
        messageLabel.setFont(new Font("Monospaced", Font.BOLD, 16));
        messageBar.add(messageLabel);

        centerPanel.add(tableWrapper);
        centerPanel.add(registerBar);
        centerPanel.add(messageBar);

        add(paxBar,BorderLayout.NORTH);
        add(centerPanel,BorderLayout.CENTER);
    }
}