package util;

import javax.swing.*;
import java.awt.*;

public class CreateRow {
    private JPanel header, row;
    private JLabel leftLabel, rightLabel, nameLabel, valueLabel;
    
        public JPanel createHeaderRow(String left, String right) {
        header = new JPanel(new BorderLayout());
        header.setMaximumSize(new Dimension(1000, 100));
        header.setBackground(new Color(230, 230, 230));

        leftLabel = new JLabel(left);
        leftLabel.setFont(new Font("Monospaced", Font.BOLD, 40));

        rightLabel = new JLabel(right);
        rightLabel.setFont(new Font("Monospaced", Font.BOLD, 40));
        rightLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        header.add(leftLabel, BorderLayout.WEST);
        header.add(rightLabel, BorderLayout.EAST);
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.DARK_GRAY));

        return header;
    }

    public JPanel createRow(String label, double value) {
        row = new JPanel(new BorderLayout());
        row.setMaximumSize(new Dimension(1000, 100));
        row.setBackground(Color.WHITE);

        nameLabel = new JLabel(label);
        nameLabel.setFont(new Font("Monospaced", Font.PLAIN, 30));

        valueLabel = new JLabel(String.format("%.2f", value));
        valueLabel.setFont(new Font("Monospaced", Font.BOLD, 30));
        valueLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        row.add(nameLabel, BorderLayout.WEST);
        row.add(valueLabel, BorderLayout.EAST);
        row.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));

        return row;
    }
}