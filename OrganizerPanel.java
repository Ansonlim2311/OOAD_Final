import javax.swing.*;
import java.awt.*;

public class OrganizerPanel extends JPanel {
    private JButton addButton;
    private JButton deleteButton;
    private JButton updateButton;

    public OrganizerPanel(CampusEventManagementSystem controller) {
        setLayout(new BorderLayout());

        // Main Content Panel (placeholder)
        JPanel content = new JPanel();
        content.setBackground(Color.LIGHT_GRAY);
        // content.add(new JLabel("Organizer Portal Under Construction"));

        // 按钮面板，水平排列按钮
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        addButton = new JButton("ADD");
        styleButton(addButton);
        addButton.addActionListener(e -> controller.showOrganizerPanel());

        deleteButton = new JButton("DELETE");
        styleButton(deleteButton);
        // deleteButton.addActionListener(e -> controller.deleteAction());

        updateButton = new JButton("UPDATE");
        styleButton(updateButton);
        // updateButton.addActionListener(e -> controller.updateAction());

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);

        add(buttonPanel, BorderLayout.NORTH);
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