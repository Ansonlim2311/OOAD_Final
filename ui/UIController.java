package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UIController {
    private JFrame frame;
    private JPanel container;
    private TopBar topBar;

    public UIController(JFrame frame, JPanel container) {
        this.frame = frame;
        this.container = container;
    }

    public void switchPanel(String title, ActionListener backAction, JPanel newPanel) {
        container.removeAll();
        topBar = new TopBar(title, backAction);
        
        container.add(topBar, BorderLayout.NORTH);
        container.add(newPanel, BorderLayout.CENTER);
        
        container.revalidate();
        container.repaint();
    }
}