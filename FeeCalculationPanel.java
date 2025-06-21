import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FeeCalculationPanel extends JPanel {
    public FeeCalculationPanel(CampusEventManagementSystem controller) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(20, 30, 20, 30));

        JLabel billTitle = new JLabel("Fee Breakdown for ");
        billTitle.setFont(new Font("SansSerif", Font.BOLD, 20));
        billTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(billTitle);
        add(Box.createRigidArea(new Dimension(0, 20)));
    }
}
