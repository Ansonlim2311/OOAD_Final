package main;

import javax.swing.*;
import java.awt.*;

import interfaces.RegistrationNavigator;
import model.Event;
import model.EventManager;
import model.FeeCalculator;
import ui.FeeCalculationPanel;
import ui.MainPagePanel;
import ui.OrganizerPanel;
import ui.ParticipatePanel;
import ui.UIController;
import util.CsvWriter;
import util.CsvReader;

public class CampusEventManagementSystem implements RegistrationNavigator {
    private JFrame frame;
    private JPanel container;
    private CsvReader fileReader = new CsvReader("events.csv");
    private CsvWriter fileWriter = new CsvWriter("events.csv");
    private EventManager eventManager = new EventManager(fileReader, fileWriter);
    private UIController uiController;

    private void mainPageUI() {
        frame = new JFrame("Campus Event Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1550, 1000);
        frame.setLocationRelativeTo(null);
        
        container = new JPanel(new BorderLayout());
        uiController = new UIController(frame, container);

        showMainPage();
        frame.setContentPane(container);
        frame.setVisible(true);
    }
    
    public void showMainPage() {
        uiController.switchPanel("Campus Event Management", null, new MainPagePanel(this));
    }
    
    public void showOrganizerPanel() {
        uiController.switchPanel("Organizer Dashboard", e -> showMainPage(), new OrganizerPanel(this, eventManager));
    }
    
    public void showParticipatePanel() {
        uiController.switchPanel("Registration System", e -> showMainPage(), new ParticipatePanel(this, eventManager));
    }
    
    public void showFeeCalculationPanel(Event event, FeeCalculator feeBreakDown) {
        uiController.switchPanel("Fee Calculation", e -> showParticipatePanel(), new FeeCalculationPanel(this, event, feeBreakDown));
    }
    
    @Override
    public void nagivateToFeePanel(Event event, FeeCalculator feeBreakDown) {
        showFeeCalculationPanel(event, feeBreakDown);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CampusEventManagementSystem().mainPageUI());
    }
}