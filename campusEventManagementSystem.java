import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class campusEventManagementSystem {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Campus Event Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 300);
        frame.setLocationRelativeTo(null); // Center on screen

        // ----- Main container with BorderLayout -----
        JPanel container = new JPanel(new BorderLayout());

        // ----- Top Bar -----
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(new Color(30, 144, 255)); // Dodger Blue
        topBar.setPreferredSize(new Dimension(frame.getWidth(), 40));

        JLabel headerLabel = new JLabel("  Campus Event Management");
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        topBar.add(headerLabel, BorderLayout.WEST);

        JButton backButton = new JButton("Back");
        backButton.setFocusPainted(false);
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(70, 130, 180)); // Steel Blue
        backButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        topBar.add(backButton, BorderLayout.EAST);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Back button clicked");
            }
        });

        // ----- Main Content Panel (below top bar) -----
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Top section: title label aligned to left
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("Welcome to Campus Event Management");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        titlePanel.add(titleLabel);

        // Center section: buttons centered vertically and horizontally
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0); // vertical spacing

        JPanel buttonGroup = new JPanel();
        buttonGroup.setLayout(new BoxLayout(buttonGroup, BoxLayout.Y_AXIS));
        buttonGroup.setBackground(Color.WHITE);

        JButton organizerButton = new JButton("Event Organizer");
        organizerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonGroup.add(organizerButton);
        buttonGroup.add(Box.createRigidArea(new Dimension(0, 10)));

        JButton participantButton = new JButton("Student / Staff");
        participantButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonGroup.add(participantButton);

        organizerButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Event Organizer Portal (Coming Soon)");
        });

        participantButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Student / Staff Portal (Coming Soon)");
        });

        // Add button group to center using GridBagLayout
        centerPanel.add(buttonGroup, gbc);

        // Add title and buttons to main panel
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Assemble everything into the container
        container.add(topBar, BorderLayout.NORTH);
        container.add(mainPanel, BorderLayout.CENTER);

        // Display the frame
        frame.setContentPane(container);
        frame.setVisible(true);
    }
}
