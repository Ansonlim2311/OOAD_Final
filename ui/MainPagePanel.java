package ui;

import javax.swing.*;
import java.awt.*;

import main.CampusEventManagementSystem;
import util.CreateButton;

public class MainPagePanel extends JPanel {
    private JPanel content, buttonPanel, centerContent;
    private JLabel titleLabel, subtitleLabel;
    private JButton organizerButton, studentButton, staffButton;
    private CreateButton buttonCreator = new CreateButton();

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

        organizerButton = buttonCreator.createStyledButton("Organizer", e -> {
            controller.showOrganizerPanel();
        });

        studentButton = buttonCreator.createStyledButton("Student", e -> {
            controller.showParticipatePanel();
        });

        staffButton = buttonCreator.createStyledButton("Staff", e -> {
            controller.showParticipatePanel();
        });

        buttonPanel.add(organizerButton);
        buttonPanel.add(studentButton);
        buttonPanel.add(staffButton);

        content.add(titleLabel);
        content.add(Box.createVerticalStrut(10));
        content.add(subtitleLabel);
        content.add(buttonPanel);

        centerContent = new JPanel(new GridBagLayout());
        centerContent.setOpaque(false);
        centerContent.add(content);

        add(centerContent, BorderLayout.CENTER);
    }
}