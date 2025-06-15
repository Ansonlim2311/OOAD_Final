import javax.swing.*;
import java.awt.*;

public class ParticipatePanel extends JPanel {
    public ParticipatePanel(CampusEventManagementSystem controller) {
        setLayout(new BorderLayout());

        // Main Content Panel (placeholder)
        JPanel content = new JPanel();
        content.setBackground(Color.LIGHT_GRAY);
        content.add(new JLabel("Participate Portal Under Construction"));

        add(content, BorderLayout.CENTER);
    }
}
