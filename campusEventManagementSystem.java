import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CampusEventManagementSystem implements RegistrationNavigator {
    private JFrame frame;
    private JPanel container;
    private TopBar topBar;
    private EventManager eventManager = new EventManager();
   
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
        switchPanel("Organizer Dashboard", e -> showMainPage(), new OrganizerPanel(this, eventManager));
    }
    
    public void showParticipatePanel() {
        switchPanel("Registration System", e -> showMainPage(), new ParticipatePanel(this, eventManager));
    }
    
    public void showFeeCalculationPanel(Event event, FeeCalculator feeBreakDown) {
        switchPanel("Fee Calculation", e -> showParticipatePanel(), new FeeCalculationPanel(this, event, feeBreakDown));
    }
    
    @Override
    public void nagivateToFeePanel(Event event, FeeCalculator feeBreakDown) {
        showFeeCalculationPanel(event, feeBreakDown);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CampusEventManagementSystem().mainPageUI());
    }
}