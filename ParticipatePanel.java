import javax.swing.*;

import javafx.scene.layout.Border;

import java.awt.*;

public class ParticipatePanel extends JPanel {
    JButton payButton;

    public ParticipatePanel(CampusEventManagementSystem controller, EventManager eventManager) {
        setLayout(new BorderLayout());

        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.setBackground(Color.WHITE);
        listPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        EventTable tableModel = new EventTable(eventManager.getEvents());
        JTable eventTable = new JTable(tableModel);
        eventTable.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(eventTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Event List"));
        listPanel.add(scrollPane, BorderLayout.CENTER);

        add(listPanel, BorderLayout.CENTER);
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
