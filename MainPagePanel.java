import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainPagePanel extends JPanel {
    private JPanel content, buttonPanel, centerContent;
    private JLabel titleLabel, subtitleLabel;
    private JButton organizerButton, participantButton;

    public MainPagePanel(CampusEventManagementSystem controller) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setOpaque(false);

        titleLabel = new JLabel("Welcome to Campus Event Management!");
        titleLabel.setFont(new Font("Monospaced", Font.BOLD, 40));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        subtitleLabel = new JLabel("A one-stop platform where you can easily organize, plan and register for exciting campus events.");
        subtitleLabel.setFont(new Font("Monospaced", Font.BOLD, 23));
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 30));
        buttonPanel.setOpaque(false);

        organizerButton = createButton("Organizer", e -> controller.showOrganizerPanel());
        participantButton = createButton("Students / Staff", e -> controller.showParticipatePanel());

        buttonPanel.add(organizerButton);
        buttonPanel.add(participantButton);

        content.add(titleLabel);
        content.add(Box.createVerticalStrut(10));
        content.add(subtitleLabel);
        content.add(buttonPanel);

        centerContent = new JPanel(new GridBagLayout());
        centerContent.setOpaque(false);
        centerContent.add(content);

        add(centerContent, BorderLayout.CENTER);
    }

    private JButton createButton(String text, ActionListener action) {
        JButton button = new JButton(text);
        button.setFont(new Font("Monospaced", Font.BOLD, 25));
        button.setPreferredSize(new Dimension(280, 60));
        button.setBackground(new Color(150, 0, 0));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(action);

        return button;
    }
}