import javax.swing.*;
import java.awt.*;

public class ParticipatePanel extends JPanel {
    JComboBox<Integer> paxDropdown;
    JTable eventTable;

    public ParticipatePanel(CampusEventManagementSystem controller, EventManager eventManager) {
        setLayout(new BorderLayout());
        //1.Create a pax selection Bar//
        JPanel paxBar = new JPanel(new BorderLayout());
        paxBar.setBackground(Color.WHITE);
        paxBar.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        paxBar.setPreferredSize(new Dimension(0, 40));

         //2.Create pax dropdown + pax label//
        JPanel paxSelectionPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,0));
        paxSelectionPanel.setBackground(Color.WHITE);

        JLabel paxLabel = new JLabel("Number of pax:");
        paxLabel.setFont(new Font("Monospaced",Font.BOLD,21));


        Integer[] paxOptions = new Integer[50];
        for (int i=0 ; i < 50; i++) paxOptions[i] = i+1;

        paxDropdown = new JComboBox<>(paxOptions);
        paxDropdown.setPreferredSize(new Dimension(160,30));
        paxDropdown.setFont(new Font("Monospaced",Font.BOLD,19));

        paxSelectionPanel.add(paxLabel);
        paxSelectionPanel.add(paxDropdown);

        paxBar.add(paxSelectionPanel, BorderLayout.EAST);

        //3.Table panel in center//
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel tableWrapper = new JPanel(new BorderLayout());
        tableWrapper.setPreferredSize(new Dimension(1300,650));
        tableWrapper.setBorder(BorderFactory.createTitledBorder("Event List"));

        EventTable model = new EventTable(eventManager.getEvents());
        eventTable = new JTable(model);
        eventTable.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(eventTable);
        tableWrapper.add(scrollPane,BorderLayout.CENTER);

        //4.Register Bar with 2 radio button 
        //Border Layout for main container (register Bar) left right mostly for large section like header 
        JPanel registerBar = new JPanel(new BorderLayout());
        registerBar.setPreferredSize(new Dimension(1300,60));
        registerBar.setBackground(Color.WHITE);

        //left side checkbox + services label
        //FlowLayout inside each section (Radio Panel and buttonPanel) mostlyy for buttons, form fields
        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 20));
        leftPanel.setBackground(Color.WHITE);

        JLabel serviceLabel = new JLabel("Additional Services:");
        serviceLabel.setFont(new Font("Monospaced", Font.BOLD, 23));

        JCheckBox transportOption = new JCheckBox("Transportation (RM50/p)");
        transportOption.setFont(new Font("Monospaced",Font.BOLD,23));
        transportOption.setBackground(Color.WHITE);

        JCheckBox cateringOption = new JCheckBox("Catering Service (RM50/p)");
        cateringOption.setFont(new Font("Monospaced",Font.BOLD,23));
        cateringOption.setBackground(Color.WHITE);

        leftPanel.add(serviceLabel);
        leftPanel.add(transportOption);
        leftPanel.add(cateringOption);

        //right side register buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 5));
        buttonPanel.setBackground(Color.WHITE);

        JButton registerButton = new JButton("Register Now");
        styleButton(registerButton);
        registerButton.addActionListener(e -> {
        EventRegistrationHandler.processFromUI(eventTable, paxDropdown, transportOption, cateringOption);
        });
        buttonPanel.add(registerButton);
        registerBar.add(leftPanel,BorderLayout.WEST);
        registerBar.add(buttonPanel,BorderLayout.EAST);

        //5.Message Bar
        JPanel messageBar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        messageBar.setPreferredSize(new Dimension(1300,50));
        messageBar.setBackground(Color.WHITE);

        JLabel messageLabel = new JLabel("**Each user are allowed only to register an event at each time.**");
        messageLabel.setFont(new Font("Monospaced", Font.BOLD, 16));
        messageBar.add(messageLabel);

        centerPanel.add(tableWrapper);
        centerPanel.add(registerBar);
        centerPanel.add(messageBar);

        add(paxBar,BorderLayout.NORTH);
        add(centerPanel,BorderLayout.CENTER);

    }

    private void styleButton(JButton button) {
        button.setPreferredSize(new Dimension(250,50));
        button.setBackground(new Color(150, 0, 0));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFont(new Font("Monospaced", Font.BOLD, 21));
        button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
    }
}
