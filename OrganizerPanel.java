import javax.swing.*;
import java.awt.*;

public class OrganizerPanel extends JPanel {
    public OrganizerPanel(CampusEventManagementSystem controller) {
        setLayout(new BorderLayout());

        // Main Content Panel (placeholder)
        JPanel content = new JPanel();
        content.setBackground(Color.WHITE);
        content.add(new JLabel("Organizer Portal Under Construction"));

        add(content, BorderLayout.CENTER);
    }
}