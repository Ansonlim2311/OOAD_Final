import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TopBar extends JPanel {
    private JLabel titleLabel;
    private JButton backButton;

    public TopBar(String title, ActionListener backAction) {
        setLayout(new BorderLayout());
        setBackground(Color.DARK_GRAY);
        setPreferredSize(new Dimension(0, 40));

        titleLabel = new JLabel("  " + title);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(titleLabel, BorderLayout.WEST);

        if (backAction != null) {
            backButton = new JButton("Back");
            backButton.setBackground(Color.GRAY);
            backButton.setForeground(Color.WHITE);
            backButton.addActionListener(backAction);
            add(backButton, BorderLayout.EAST);
        }
    }

    public void setTitle(String newTitle) {
        titleLabel.setText("  " + newTitle);
    }
}