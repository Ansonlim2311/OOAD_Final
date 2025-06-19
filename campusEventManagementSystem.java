import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CampusEventManagementSystem {
    private JFrame frame;
    private JPanel container;
    private TopBar topBar;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CampusEventManagementSystem().mainPageUI());
    }

    private void mainPageUI() {
        frame = new JFrame("Campus Event Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1000);
        frame.setLocationRelativeTo(null);

        container = new JPanel(new BorderLayout());

        topBar = new TopBar("Campus Event Management", null);
        topBar.setBackground(Color.WHITE);
        topBar.setPreferredSize(new Dimension(frame.getWidth(), 60));

        container.add(topBar, BorderLayout.NORTH);
        showMainPage();
        frame.setContentPane(container);
        frame.setVisible(true);
    }

    public void setTopBar(String title, ActionListener backAction) {
        topBar = new TopBar(title, backAction);
    }

    private void switchPanel(String title, ActionListener backAction, JPanel newPanel) {
        container.removeAll();
        setTopBar(title, backAction);
        container.add(topBar, BorderLayout.NORTH);
        container.add(newPanel, BorderLayout.CENTER);
        container.revalidate();
        container.repaint();
    }

    public void showMainPage() {
        switchPanel("Campus Event Management", null, new MainPagePanel(this));
    }

    public void showOrganizerPanel() {
        switchPanel("Organizer Dashboard", e -> showMainPage(), new OrganizerPanel(this));
    }

    public void showParticipatePanel() {
        switchPanel("Participate Dashboard", e -> showMainPage(), new ParticipatePanel(this));
    }
}