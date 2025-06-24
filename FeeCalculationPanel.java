import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FeeCalculationPanel extends JPanel {
    JPanel contentPanel, titlePanel, breakdownPanel, buttonPanel;
    JLabel billTitle;
    JButton payButton;

    public FeeCalculationPanel(CampusEventManagementSystem controller, Event event, FeeCalculator feeBreakdown) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(20, 30, 20, 30));

        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.WHITE);

        titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        titlePanel.setMaximumSize(new Dimension(1000, 50));
        titlePanel.setBackground(new Color(240, 240, 240));
        titlePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        billTitle = new JLabel("Fee Breakdown for " + event.getEventName());
        billTitle.setFont(new Font("Monospaced", Font.BOLD, 25));
        titlePanel.add(billTitle);
        contentPanel.add(titlePanel);
        
        breakdownPanel = new JPanel();
        breakdownPanel.setLayout(new BoxLayout(breakdownPanel, BoxLayout.Y_AXIS));
        breakdownPanel.setBackground(Color.WHITE);
        breakdownPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));
        
        breakdownPanel.add(createHeaderRow("Breakdown Bill", "Amount (RM)"));
        
        for (FeeComponent component : feeBreakdown.getDetailedFeeComponent()) {
            breakdownPanel.add(Box.createVerticalStrut(5));
            breakdownPanel.add(createRow(component.getDescription(), component.getFee()));
            breakdownPanel.add(Box.createVerticalStrut(5));
        }
        
        contentPanel.add(breakdownPanel);

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Color.WHITE);

        payButton = CreateButton.createStyledButton("Pay Now", 220, 70);

        payButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Payment processed. Thank you!");
        });

        buttonPanel.add(payButton);
        contentPanel.add(buttonPanel);

        add(contentPanel, BorderLayout.CENTER);
    }

    private JPanel createHeaderRow(String left, String right) {
        JPanel header = new JPanel(new BorderLayout());
        header.setMaximumSize(new Dimension(1000, 100));
        header.setBackground(new Color(230, 230, 230));

        JLabel leftLabel = new JLabel(left);
        leftLabel.setFont(new Font("Monospaced", Font.BOLD, 40));

        JLabel rightLabel = new JLabel(right);
        rightLabel.setFont(new Font("Monospaced", Font.BOLD, 40));
        rightLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        header.add(leftLabel, BorderLayout.WEST);
        header.add(rightLabel, BorderLayout.EAST);
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.DARK_GRAY));

        return header;
    }

    private JPanel createRow(String label, double value) {
        JPanel row = new JPanel(new BorderLayout());
        row.setMaximumSize(new Dimension(1000, 100));
        row.setBackground(Color.WHITE);

        JLabel nameLabel = new JLabel(label);
        nameLabel.setFont(new Font("Monospaced", Font.PLAIN, 30));

        JLabel valueLabel = new JLabel(String.format("%.2f", value));
        valueLabel.setFont(new Font("Monospaced", Font.BOLD, 30));
        valueLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        row.add(nameLabel, BorderLayout.WEST);
        row.add(valueLabel, BorderLayout.EAST);
        row.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));

        return row;
    }
}