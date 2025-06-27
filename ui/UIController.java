package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UIController {
    private final JFrame frame;
    private final JPanel container;
    private TopBar topBar;

    public UIController(JFrame frame, JPanel container) {
        this.frame = frame;
        this.container = container;
    }

    public void switchPanel(String title, ActionListener backAction, JPanel newPanel) {
        container.removeAll();
        topBar = new TopBar(title, backAction);
        topBar.setPreferredSize(new Dimension(frame.getWidth(), 60));
        topBar.setBackground(Color.WHITE);
        
        container.add(topBar, BorderLayout.NORTH);
        container.add(newPanel, BorderLayout.CENTER);
        
        container.revalidate();
        container.repaint();
    }

    public JPanel getContainer() {
        return container;
    }
}