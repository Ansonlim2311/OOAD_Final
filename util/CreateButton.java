package util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateButton {
    private JButton button;

    public JButton createStyledButton(String text, ActionListener action) {
        button = new JButton(text);
        button.setFont(new Font("Monospaced", Font.BOLD, 25));
        button.setPreferredSize(new Dimension(280, 60));
        button.setBackground(new Color(150, 0, 0));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(action);

        return button;
    }

    public JButton createStyledButton(String text, int width, int height) {
        button = new JButton(text);
        button.setPreferredSize(new Dimension(width, height));
        button.setBackground(new Color(150, 0, 0));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFont(new Font("Monospaced", Font.BOLD, 24));
        button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        
        return button;
    }
}