import javax.swing.*;
import java.awt.*;

public class ParticipatePanel extends JPanel {
    JComboBox<Integer> paxDropdown;
    JTable eventTable;

    public ParticipatePanel(CampusEventManagementSystem controller, EventManager eventManager) {
        setLayout(new BorderLayout());
        //1.Create a pax selection Bar//
        JPanel paxBar = new JPanel(new BorderLayout());
        paxBar.setBackground(Color.WHITE);
        paxBar.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        paxBar.setPreferredSize(new Dimension(0, 40));

         //2.Create pax dropdown + pax label//
        JPanel paxSelectionPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,0));
        paxSelectionPanel.setBackground(Color.WHITE);

        JLabel paxLabel = new JLabel("Number of pax:");
        paxLabel.setFont(new Font("Monospaced",Font.PLAIN,19));


        Integer[] paxOptions = new Integer[100];
        for (int i=0 ; i < 100; i++) paxOptions[i] = i+1;

        paxDropdown = new JComboBox<>(paxOptions);
        paxDropdown.setPreferredSize(new Dimension(160,30));
        paxDropdown.setFont(new Font("Monospaced",Font.PLAIN,14));

        paxSelectionPanel.add(paxLabel);
        paxSelectionPanel.add(paxDropdown);

        paxBar.add(paxSelectionPanel, BorderLayout.EAST);

        //3.Table panel in center//
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel tableWrapper = new JPanel(new BorderLayout());
        tableWrapper.setPreferredSize(new Dimension(1300,200));
        tableWrapper.setBorder(BorderFactory.createTitledBorder("Event List"));

        EventTable model = new EventTable(eventManager.getEvents());
        eventTable = new JTable(model);
        eventTable.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(eventTable);
        tableWrapper.add(scrollPane,BorderLayout.CENTER);

        //4.Register Bar
        JPanel registerBar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        registerBar.setPreferredSize(new Dimension(1300,60));
        registerBar.setBackground(Color.RED);

        JButton registerButton = new JButton("Register");
        registerButton.setPreferredSize(new Dimension(150,50));
        registerButton.setBackground(new Color(204, 0, 0));
        registerButton.setForeground(Color.PINK);
        registerButton.setFocusPainted(false);
        registerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        // registerButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        registerBar.add(registerButton);

        //5.Message Bar
        JPanel messageBar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        messageBar.setPreferredSize(new Dimension(1300,45));
        messageBar.setBackground(Color.BLUE);

        JLabel messageLabel = new JLabel("GoodMorning");
        messageLabel.setFont(new Font("Monospaced", Font.ITALIC, 14));
        messageBar.add(messageLabel);

        centerPanel.add(tableWrapper);
        centerPanel.add(registerBar);
        centerPanel.add(messageBar);

        add(paxBar,BorderLayout.NORTH);
        add(centerPanel,BorderLayout.CENTER);
    }

    private void styleButton(JButton button) {
        button.setPreferredSize(new Dimension(100, 35));
        button.setBackground(new Color(204, 0, 0));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
    }
}
