// import javax.swing.*;
// // import com.toedter.calendar.JDateChooser;
// import java.awt.*;
// import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;
// import java.time.format.DateTimeParseException;

// public class OrganizerPanel extends JPanel {
//     private JButton addButton;
//     private JButton deleteButton;
//     private JButton updateButton;
//     private JComboBox<String> venue;
//     private JComboBox<String> typeevent;
//     private JTextField eventNameField;
//     private JTextField dateField;
//     // private JDateChooser dateField;
//     private JSpinner capacityfield;

//     // private JDateChooser dateChooser;


//     public OrganizerPanel(CampusEventManagementSystem controller) {
//         setLayout(new BorderLayout());

//         // Main Content Panel (placeholder)
//         JPanel content = new JPanel();
//         content.setBackground(Color.LIGHT_GRAY);
//         content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
//         content.add(Box.createVerticalStrut(80));

//         // 按钮面板，水平排列按钮
//         JPanel buttonPanel = new JPanel();
//         buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
//         buttonPanel.setBackground(Color.LIGHT_GRAY);

//         addButton = new JButton("ADD");
//         styleButton(addButton);
//         // addButton.addActionListener(e -> controller.showOrganizerPanel());

//         deleteButton = new JButton("DELETE");
//         styleButton(deleteButton);
//         // deleteButton.addActionListener(e -> controller.deleteAction());

//         updateButton = new JButton("UPDATE");
//         styleButton(updateButton);
//         // updateButton.addActionListener(e -> controller.updateAction());

//         buttonPanel.add(addButton);
//         buttonPanel.add(deleteButton);
//         buttonPanel.add(updateButton);

//         add(buttonPanel, BorderLayout.NORTH);
//         add(content, BorderLayout.CENTER);

//         //---------------------------------Event Name--------------------------------
//         JLabel eventNameLabel = new JLabel("Event Name:");
//         eventNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//         content.add(eventNameLabel);
//         eventNameField = new JTextField();
//         eventNameField.setMaximumSize(new Dimension(200, 30));
//         eventNameField.setAlignmentX(Component.CENTER_ALIGNMENT);
//         content.add(eventNameField);
        
//         //---------------------------------Event Date--------------------------------
//         JLabel dateselectionLabel = new JLabel("Date:");
//         dateselectionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//         content.add(dateselectionLabel);
//         dateField = new JTextField("yyyy-MM-dd");
//         dateField.setMaximumSize(new Dimension(100, 30));
//         dateField.setAlignmentX(Component.CENTER_ALIGNMENT);
//         content.add(dateField);


//         //--------------------------------Event Venue-----------------------------------
//         JLabel venueLabel = new JLabel("Venue:");
//         venueLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//         content.add(venueLabel);
//         String[] venues = {"Venue 1", "Venue 2", "Venue 3"};
//         venue = new JComboBox<>(venues);
//         venue.setMaximumSize(new Dimension(100, 30));
//         venue.setAlignmentX(Component.CENTER_ALIGNMENT);
//         content.add(venue);

//         //-------------------------------Event Type-----------------------------------
//         JLabel typeEventLabel = new JLabel("Event Type:");
//         typeEventLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//         content.add(typeEventLabel);
//         content.add(Box.createVerticalStrut(10));
//         String eventTypes[] = {"Type 1", "Type 2", "Type 3"};
//         typeevent = new JComboBox<>(eventTypes);
//         typeevent.setMaximumSize(new Dimension(100, 30));
//         typeevent.setAlignmentX(Component.CENTER_ALIGNMENT);
//         content.add(typeevent);
        
//         //--------------------------------Event Capacity--------------------------------
//         JLabel capacityLabel = new JLabel("Capacity:");
//         capacityLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//         content.add(capacityLabel);
//         capacityfield = new JSpinner(new SpinnerNumberModel(1, 0, null, 1));
//         capacityfield.setMaximumSize(new Dimension(50, 30));
//         capacityfield.setAlignmentX(Component.CENTER_ALIGNMENT);
//         content.add(capacityfield);


//     }

//     private void styleButton(JButton button) {
//         button.setPreferredSize(new Dimension(120, 40));
//         button.setBackground(Color.GRAY);
//         button.setForeground(Color.WHITE);
//         button.setFocusPainted(false);
//         button.setCursor(new Cursor(Cursor.HAND_CURSOR));
//     }
    



// }


  

// 帮我把eventname date venue type 排成一排