package ui;

import javax.swing.*;
import java.awt.*;

import main.CampusEventManagementSystem;
import util.CreateButton;
import User.Organizer;
import User.Staff;
import User.Student;

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
            Organizer organizer = new Organizer("LIMWEIJUN", "241UC2415S", "lim.wei.jun@organizer.mmu.edu.my", "Organizer");
            controller.setCurrentUser(organizer);
            controller.showOrganizerPanel();
        });

        studentButton = buttonCreator.createStyledButton("Student", e -> {
            Student student = new Student("Jayy", "241UC24178", "jayy.wong.jun@student.mmu.edu.my", "Student");
            controller.setCurrentUser(student);
            controller.showParticipatePanel();
        });

        staffButton = buttonCreator.createStyledButton("Staff", e -> {
            Staff staff = new Staff("Kerqian", "241UC2415E", "ker.qian@staff.mmu.edu.my", "Staff");
            controller.setCurrentUser(staff);
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