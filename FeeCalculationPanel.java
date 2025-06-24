import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FeeCalculationPanel extends JPanel {
    public FeeCalculationPanel(CampusEventManagementSystem controller, Event event, FeeCalculator feeBreakdown) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(20, 30, 20, 30));

        JLabel billTitle = new JLabel("Fee Breakdown for " + event.getEventName());
        billTitle.setFont(new Font("SansSerif", Font.BOLD, 20));
        billTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(billTitle);
        add(Box.createRigidArea(new Dimension(0, 20)));

        for (FeeComponent component : feeBreakdown.getDetailedFeeComponent()) {
            add(createRow(component.getDescription(), component.getFee()));
        }
    }

    private JPanel createRow(String label, double value) {
        JPanel row = new JPanel(new BorderLayout());
        row.setMaximumSize(new Dimension(600, 40));
        row.setBackground(Color.WHITE);

        JLabel nameLabel = new JLabel(label);
        nameLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));

        JLabel valueLabel = new JLabel(String.format("RM %.2f", value));
        valueLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        valueLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        row.add(nameLabel, BorderLayout.WEST);
        row.add(valueLabel, BorderLayout.EAST);
        row.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));

        return row;
    }
}
