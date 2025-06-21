import javax.swing.*;
import java.awt.*;

public class OrganizerPanel extends JPanel {
    private JLabel typeLabel, EventNameLabel, dateLabel, venueLabel, capacityLabel, registrationLabel;
    private JButton addButton, deleteButton, updateButton;
    private JComboBox<String> venue, typeevent;
    private JTextField eventNameField, dateField;
    private JSpinner capacityfield, registrationfield;

    public OrganizerPanel(CampusEventManagementSystem controller, EventManager eventManager) {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        JSplitPane mainContentSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        mainContentSplitPane.setDividerLocation(350);
        mainContentSplitPane.setDividerSize(5);
        mainContentSplitPane.setContinuousLayout(true);

        // -------- Left Panel: Form --------
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.LIGHT_GRAY);
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        int verticalGap = 10;
        int sectionGap = 20;
        int row = 0;

        // Event Name
        gbc.gridx = 0; gbc.gridy = row;
        gbc.insets = new Insets(verticalGap, 0, verticalGap, 0);
        EventNameLabel = new JLabel("Event Name:");
        EventNameLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
        formPanel.add(EventNameLabel, gbc);
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.insets = new Insets(verticalGap, 0, sectionGap, 0);
        eventNameField = new JTextField();
        eventNameField.setFont(new Font("Monospaced", Font.BOLD,  18));
        eventNameField.setPreferredSize(new Dimension(250, 35));
        formPanel.add(eventNameField, gbc);
        row++;

        // Date
        gbc.gridx = 0; gbc.gridy = row;
        gbc.insets = new Insets(verticalGap, 0, verticalGap, 0);
        dateLabel = new JLabel("Date:");
        dateLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
        formPanel.add(dateLabel, gbc);
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.insets = new Insets(verticalGap, 0, sectionGap, 0);
        dateField = new JTextField("YYYY-MM-DD");
        dateField.setFont(new Font("Monospaced", Font.BOLD, 18));
        dateField.setPreferredSize(new Dimension(250, 35));
        formPanel.add(dateField, gbc);
        row++;

        // Venue
        gbc.gridx = 0; gbc.gridy = row;
        gbc.insets = new Insets(verticalGap, 0, verticalGap, 0);
        venueLabel = new JLabel("Venue:");
        venueLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
        formPanel.add(venueLabel, gbc);
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.insets = new Insets(verticalGap, 0, sectionGap, 0);
        venue = new JComboBox<>(new String[]{"DTC","Stadium","CNMX 1001", "CQAR 0001","CQAR 0002","CQAR 0003","CQAR 0004", "CQAR 1001","CQAR 1002","CQAR 1003","CQAR 1004", "CQAR 1005","CQAR 2001","CQAR 2002","CQAR 2003","CQAR 2004", "CQAR 2005", "CQAR 3001","CQAR 3002","CQAR 3003","CQAR 3004", "CQAR 3005", "CQAR 4001","CQAR 4002","CQAR 4003","CQAR 4004", "CQAR 4005"
        ,"CQMX 1001", "CQMX 1002","CQMX 1003","CQMX 1004", "CQMX 1005",});
        venue.setFont(new Font("Monospaced", Font.BOLD, 18));
        venue.setPreferredSize(new Dimension(250, 35));
        formPanel.add(venue, gbc);
        row++;

        // Event Type
        gbc.gridx = 0; gbc.gridy = row;
        gbc.insets = new Insets(verticalGap, 0, verticalGap, 0);
        typeLabel = new JLabel("Event Type:");
        typeLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
        formPanel.add(typeLabel, gbc);
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.insets = new Insets(verticalGap, 0, sectionGap, 0);
        typeevent = new JComboBox<>(new String[]{"Seminars", "Workshops", "Cultural Events", "Sports Events"});
        typeevent.setFont(new Font("Monospaced", Font.BOLD, 18));
        typeevent.setPreferredSize(new Dimension(250, 35));
        formPanel.add(typeevent, gbc);
        row++;

        // Capacity
        gbc.gridx = 0; gbc.gridy = row;
        gbc.insets = new Insets(verticalGap, 0, verticalGap, 0);
        capacityLabel = new JLabel("Capacity:");
        capacityLabel.setFont(new Font("Monospaced", Font.BOLD,  18));
        formPanel.add(capacityLabel, gbc);
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.insets = new Insets(verticalGap, 0, verticalGap, 0);
        capacityfield = new JSpinner(new SpinnerNumberModel(1, 0, Integer.MAX_VALUE, 1));
        capacityfield.setFont(new Font("Monospaced", Font.BOLD, 18));
        capacityfield.setPreferredSize(new Dimension(100, 35));
        formPanel.add(capacityfield, gbc);
        row++;

        // Registration Fee
        gbc.gridx = 0; gbc.gridy = row;
        gbc.insets = new Insets(verticalGap, 0, verticalGap, 0);
        gbc.weighty = 0.0; // This is fine for the label
        registrationLabel = new JLabel("Registration Fee:");
        registrationLabel.setFont(new Font("Monospaced", Font.BOLD,  18));
        formPanel.add(registrationLabel, gbc);
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.insets = new Insets(verticalGap, 0, verticalGap, 0);
        registrationfield = new JSpinner(new SpinnerNumberModel(1, 0, Integer.MAX_VALUE, 1));
        registrationfield.setFont(new Font("SansSerif", Font.PLAIN, 18));
        registrationfield.setPreferredSize(new Dimension(100, 35));
        formPanel.add(registrationfield, gbc);

        // Horizontal glue
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        formPanel.add(Box.createGlue(), gbc);

        mainContentSplitPane.setLeftComponent(formPanel);

        // -------- Right Panel: Placeholder (no table yet) --------
        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.setBackground(Color.WHITE);
        listPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        EventTable tableModel = new EventTable(eventManager.getEvents());
        JTable eventTable = new JTable(tableModel);
        eventTable.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(eventTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Event List"));
        listPanel.add(scrollPane, BorderLayout.CENTER);

        mainContentSplitPane.setRightComponent(listPanel);
        add(mainContentSplitPane, BorderLayout.CENTER);

        // -------- Button Panel --------
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        updateButton = new JButton("Update");

        styleButton(addButton);
        styleButton(deleteButton);
        styleButton(updateButton);

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void styleButton(JButton button) {
        button.setPreferredSize(new Dimension(100, 35));
        button.setBackground(new Color(204, 0, 0));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
    }
}