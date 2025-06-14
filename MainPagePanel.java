import javax.swing.*;
import java.awt.*;

public class MainPagePanel extends JPanel {
    private JLabel titleLabel;
    private JButton organizerButton, participantButton;

    public MainPagePanel(CampusEventManagementSystem controller) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.LIGHT_GRAY);
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        titleLabel = new JLabel("Welcome to Campus Event Management");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(titleLabel);
        add(Box.createRigidArea(new Dimension(0, 20)));

        organizerButton = new JButton("Event Organizer");
        organizerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        organizerButton.setPreferredSize(new Dimension(180, 40));
        organizerButton.setMaximumSize(new Dimension(180, 40));
        organizerButton.setBackground(Color.GRAY);
        organizerButton.setForeground(Color.WHITE);
        organizerButton.setFocusPainted(false);
        organizerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        organizerButton.addActionListener(event -> controller.showOrganizerPanel());
        add(organizerButton);

        add(Box.createRigidArea(new Dimension(0, 10)));

        participantButton = new JButton("Student / Staff");
        participantButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        participantButton.setPreferredSize(new Dimension(180, 40));
        participantButton.setMaximumSize(new Dimension(180, 40));
        participantButton.setBackground(Color.GRAY);
        participantButton.setForeground(Color.WHITE);
        participantButton.setFocusPainted(false);
        participantButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        participantButton.addActionListener(event -> controller.showParticipatePanel());
        add(participantButton);
    }
}