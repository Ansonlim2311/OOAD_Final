import javax.swing.*;
import java.awt.*;

public class OrganizerPanel extends JPanel {
    private JButton addButton, deleteButton, updateButton;
    private EventFormPanel formPanel;

    public OrganizerPanel(CampusEventManagementSystem controller, EventManager eventManager) {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        // -------- Split Pane --------
        JSplitPane mainContentSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        mainContentSplitPane.setDividerLocation(400);
        mainContentSplitPane.setDividerSize(5);
        mainContentSplitPane.setContinuousLayout(true);

        // -------- Left Panel: Form --------
        formPanel = new EventFormPanel();
        mainContentSplitPane.setLeftComponent(formPanel);

// -------- Right Panel: Placeholder (no table yet) --------
        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.setBackground(Color.WHITE);
        listPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        EventTable tableModel = new EventTable(eventManager.getEvents());
        JTable eventTable = new JTable(tableModel);
        eventTable.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(eventTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Event List"));
        listPanel.add(scrollPane, BorderLayout.CENTER);

        mainContentSplitPane.setRightComponent(listPanel);
        add(mainContentSplitPane, BorderLayout.CENTER);

        // -------- Button Panel --------
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        updateButton = new JButton("Update");

        styleButton(addButton);
        styleButton(deleteButton);
        styleButton(updateButton);

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);

        add(buttonPanel, BorderLayout.SOUTH);
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
