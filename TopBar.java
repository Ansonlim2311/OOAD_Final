import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TopBar extends JPanel {
    private JLabel titleLabel;
    private JButton backButton;

    public TopBar(String title, ActionListener backAction) {
        setLayout(new BorderLayout());
        setBackground(new Color(244, 0, 0));
        setPreferredSize(new Dimension(0, 60));

        titleLabel = new JLabel(" " + title);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Monospaced", Font.BOLD, 26));
        add(titleLabel, BorderLayout.WEST);

        if (backAction != null) {
            backButton = new JButton("Back");
            backButton.setFont(new Font("Monospaced", Font.BOLD, 25));
            backButton.setPreferredSize(new Dimension(100, 60));
            backButton.setBackground(Color.WHITE);
            backButton.setForeground(Color.BLACK);
            backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            backButton.addActionListener(backAction);
            add(backButton, BorderLayout.EAST);
        }
    }
}