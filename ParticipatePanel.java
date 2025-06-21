import javax.swing.*;
import java.awt.*;

public class ParticipatePanel extends JPanel {
    JButton payButton;

    public ParticipatePanel(CampusEventManagementSystem controller) {
        setLayout(new BorderLayout());

        // Main Content Panel (placeholder)
        JPanel content = new JPanel();
        content.setBackground(Color.WHITE);
        content.add(new JLabel("Participate Portal Under Construction"));

        payButton = new JButton("Pay");

        styleButton(payButton);
        payButton.addActionListener(e -> controller.showFeeCalculationPanel());

        content.add(payButton);

        add(content, BorderLayout.CENTER);
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
