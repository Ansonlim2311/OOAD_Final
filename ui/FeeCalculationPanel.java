package ui;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

import interfaces.FeeComponent;
import main.CampusEventManagementSystem;
import model.Event;
import model.FeeCalculator;
import util.CreateButton;
import util.CreateRow;

public class FeeCalculationPanel extends JPanel {
    private JPanel contentPanel, titlePanel, breakdownPanel, buttonPanel;
    private JLabel billTitle;
    private JButton payButton;
    private CreateButton buttonCreator = new CreateButton();
    private CreateRow rowCreator = new CreateRow();
    private JPanel messageBar;
    private JLabel discountLabel;

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
        
        breakdownPanel.add(rowCreator.createHeaderRow("Breakdown Bill", "Amount (RM)"));
        
        for (FeeComponent component : feeBreakdown.getDetailedFeeComponent()) {
            breakdownPanel.add(Box.createVerticalStrut(5));
            breakdownPanel.add(rowCreator.createRow(component.getDescription(), component.getFee()));
            breakdownPanel.add(Box.createVerticalStrut(5));
        }
        
        contentPanel.add(breakdownPanel);

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Color.WHITE);

        payButton = buttonCreator.createStyledButton("Pay Now", 220, 70);

        payButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Payment processed. Thank you!");
        });

        messageBar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        messageBar.setPreferredSize(new Dimension(1300,50));
        messageBar.setBackground(Color.WHITE);

        discountLabel = new JLabel("**Group Discount 5% (5 Or More Pax)  Total Amount Discount 5% (Total Amount More than 2000)**");
        discountLabel.setFont(new Font("Monospaced", Font.BOLD, 16));
        messageBar.add(discountLabel);

        buttonPanel.add(payButton);
        contentPanel.add(messageBar);
        contentPanel.add(buttonPanel);

        add(contentPanel, BorderLayout.CENTER);
    }
}