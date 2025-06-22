import javax.swing.*;
import java.awt.*;

public class EventFormPanel extends JPanel {
    public JTextField eventNameField, dateField;
    public JComboBox<String> venue, typeevent;
    public JSpinner capacityField, registrationField;

    public EventFormPanel() {
        setLayout(new GridBagLayout());
        setBackground(Color.LIGHT_GRAY);
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        int row = 0;

        // Initialize components
        eventNameField = createTextField(250);
        dateField = createTextField(250);
        dateField.setText("DD-MM-YYYY"); // Placeholder text
        System.out.println("Date entered: " + dateField.getText());


        venue = new JComboBox<>(getVenueOptions());
        styleComboBox(venue);

        typeevent = new JComboBox<>(new String[]{"None","Seminars", "Workshops", "Cultural Events", "Sports Events"});
        styleComboBox(typeevent);

        capacityField = new JSpinner(new SpinnerNumberModel(1, 0, Integer.MAX_VALUE, 1));
        styleSpinner(capacityField);

        registrationField = new JSpinner(new SpinnerNumberModel(1, 0, Double.MAX_VALUE, 1));
        styleSpinner(registrationField);

        // Add components using helper
        addLabeledComponent(this, gbc, "Event Name:", eventNameField, row); row += 2;
        addLabeledComponent(this, gbc, "Date:", dateField, row); row += 2;
        addLabeledComponent(this, gbc, "Venue:", venue, row); row += 2;
        addLabeledComponent(this, gbc, "Event Type:", typeevent, row); row += 2;
        addLabeledComponent(this, gbc, "Capacity:", capacityField, row); row += 2;
        addLabeledComponent(this, gbc, "Registration Fee:", registrationField, row); row += 2;

        // Optional glue for spacing
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        add(Box.createGlue(), gbc);
    }

    private void addLabeledComponent(JPanel panel, GridBagConstraints gbc, String labelText, Component input, int row) {
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.insets = new Insets(10, 0, 10, 0);

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Monospaced", Font.BOLD, 18));
        panel.add(label, gbc);

        gbc.gridy = row + 1;
        gbc.insets = new Insets(10, 0, 20, 0);
        panel.add(input, gbc);
    }

    private JTextField createTextField(int width) {
        JTextField tf = new JTextField();
        tf.setFont(new Font("Monospaced", Font.BOLD, 18));
        tf.setPreferredSize(new Dimension(width, 35));
        return tf;
    }

    private void styleComboBox(JComboBox<String> cb) {
        cb.setFont(new Font("Monospaced", Font.BOLD, 18));
        cb.setPreferredSize(new Dimension(250, 35));
    }

    private void styleSpinner(JSpinner spinner) {
        spinner.setFont(new Font("Monospaced", Font.BOLD, 18));
        spinner.setPreferredSize(new Dimension(250, 35));
    }

    private String[] getVenueOptions() {
        return new String[]{
            "None","DTC", "Stadium", "CNMX 1001", "CQAR 0001", "CQAR 0002", "CQAR 0003", "CQAR 0004",
            "CQAR 1001", "CQAR 1002", "CQAR 1003", "CQAR 1004", "CQAR 1005",
            "CQAR 2001", "CQAR 2002", "CQAR 2003", "CQAR 2004", "CQAR 2005",
            "CQAR 3001", "CQAR 3002", "CQAR 3003", "CQAR 3004", "CQAR 3005",
            "CQAR 4001", "CQAR 4002", "CQAR 4003", "CQAR 4004", "CQAR 4005",
            "CQMX 1001", "CQMX 1002", "CQMX 1003", "CQMX 1004", "CQMX 1005"
        };
    }
}