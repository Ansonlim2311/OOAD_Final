import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CampusEventManagementSystem {
    JFrame frame;
    JPanel container, topBar;
    JLabel headerLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CampusEventManagementSystem().mainPageUI());
    }

    private void mainPageUI() {
        frame = new JFrame("Campus Event Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);

        container = new JPanel(new BorderLayout());

        topBar = new JPanel(new BorderLayout());
        topBar.setBackground(Color.DARK_GRAY);
        topBar.setPreferredSize(new Dimension(frame.getWidth(), 40));

        container.add(topBar, BorderLayout.NORTH);
        showMainPage();
        frame.setContentPane(container);
        frame.setVisible(true);
    }

    public void setTopBar(String title, ActionListener backAction) {
        topBar.removeAll();

        headerLabel = new JLabel("  " + title);
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        topBar.add(headerLabel, BorderLayout.WEST);

        if (backAction != null) {
            JButton backButton = new JButton("Back");
            backButton.setBackground(Color.GRAY);
            backButton.setForeground(Color.WHITE);
            backButton.addActionListener(backAction);
            topBar.add(backButton, BorderLayout.EAST);
        }

        topBar.revalidate();
        topBar.repaint();
    }

    public void showMainPage() {
        container.removeAll();
        setTopBar("Campus Event Management", null);
        container.add(topBar, BorderLayout.NORTH);
        container.add(new MainPagePanel(this), BorderLayout.CENTER);
        refreshUI();
    }

    public void showOrganizerPanel() {
        container.removeAll();
        setTopBar("Organizer Dashboard", e -> showMainPage());
        container.add(topBar, BorderLayout.NORTH);
        container.add(new OrganizerPanel(this), BorderLayout.CENTER);
        refreshUI();
    }

    public void showParticipatePanel() {
        container.removeAll();
        setTopBar("Participate Dashboard", e -> showMainPage());
        container.add(topBar, BorderLayout.NORTH);
        container.add(new ParticipatePanel(this), BorderLayout.CENTER);
        refreshUI();
    }

    public void refreshUI() {
        container.revalidate();
        container.repaint();
    }
}