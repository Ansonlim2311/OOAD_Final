import javax.swing.*;
import java.awt.*;

public class tOrganizerPanel extends JPanel {
    private JButton addButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JComboBox<String> venue;
    private JComboBox<String> typeevent;
    private JTextField eventNameField;
    private JTextField dateField;
    private JSpinner capacityfield;

    public tOrganizerPanel(CampusEventManagementSystem controller) {
        setLayout(new BorderLayout());

        // ----------- Top Button Panel ------------
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        addButton = new JButton("ADD");
        styleButton(addButton);
        deleteButton = new JButton("DELETE");
        styleButton(deleteButton);
        updateButton = new JButton("UPDATE");
        styleButton(updateButton);

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);

        add(buttonPanel, BorderLayout.NORTH);

        // ----------- Main Form Panel ------------
        JPanel content = new JPanel();
        content.setBackground(Color.LIGHT_GRAY);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.add(Box.createVerticalStrut(1)); // spacing

// ----------- Horizontal Form Row Panel ------------
        JPanel rowpanel = new JPanel();
        rowpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 1)); // 横向排列，中间间距20
        rowpanel.setBackground(Color.LIGHT_GRAY);

        // Event Name
        JPanel namePanel = new JPanel(new BorderLayout());
        namePanel.add(new JLabel("Event Name:"), BorderLayout.NORTH);
        eventNameField = new JTextField(); 
        eventNameField.setPreferredSize(new Dimension(240, 25)); // 设置合适的宽高
        namePanel.add(eventNameField, BorderLayout.CENTER);

        // Date
        JPanel datePanel = new JPanel(new BorderLayout());
        datePanel.add(new JLabel("Date: yyyy-MM-dd"), BorderLayout.NORTH);
        dateField = new JTextField(); 
        dateField.setPreferredSize(new Dimension(130, 25)); // 设置合适的宽高
        datePanel.add(dateField, BorderLayout.CENTER);


        // Venue
        JPanel venuePanel = new JPanel(new BorderLayout());
        venuePanel.add(new JLabel("Venue:"), BorderLayout.NORTH);
        String[] venues = {"Venue 1", "Venue 2", "Venue 3"};
        venue = new JComboBox<>(venues);
        venue.setPreferredSize(new Dimension(100, 25));
        venuePanel.add(venue, BorderLayout.CENTER);

        // Type
        JPanel typePanel = new JPanel(new BorderLayout());
        typePanel.add(new JLabel("Type:"), BorderLayout.NORTH);
        String[] types = {"Type 1", "Type 2", "Type 3"};
        typeevent = new JComboBox<>(types);
        typeevent.setPreferredSize(new Dimension(100, 25));
        typePanel.add(typeevent, BorderLayout.CENTER);

        // Capacity
        JPanel capacityPanel = new JPanel(new BorderLayout());
        capacityPanel.add(new JLabel("Capacity:"), BorderLayout.NORTH);
        capacityfield = new JSpinner(new SpinnerNumberModel(1, 0, null, 1));
        capacityfield.setPreferredSize(new Dimension(80, 25));
        capacityPanel.add(capacityfield, BorderLayout.CENTER);

        // 添加所有字段到横向 rowpanel
        rowpanel.add(namePanel);
        rowpanel.add(datePanel);
        rowpanel.add(venuePanel);
        rowpanel.add(typePanel);
        rowpanel.add(capacityPanel);

        // 加到主 content 中（BoxLayout 垂直排列）
        content.add(rowpanel);
        content.add(Box.createVerticalStrut(10)); // spacing
        add(content, BorderLayout.CENTER);
    }

    private void styleButton(JButton button) {
        button.setPreferredSize(new Dimension(120, 40));
        button.setBackground(Color.GRAY);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
