import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddButtonHandler implements ActionListener {
    private EventFormPanel formPanel;

    public AddButtonHandler(EventFormPanel formPanel) {
        this.formPanel = formPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!Getvalue.validateAll(formPanel)) {
            return;
        }

        String name = Getvalue.getEventName(formPanel);
        String date = Getvalue.getDate(formPanel);
        String venue = Getvalue.getVenue(formPanel);
        String type = Getvalue.getTypeEvent(formPanel);
        int capacity = Getvalue.getCapacity(formPanel);
        double fee = Getvalue.getRegistrationFee(formPanel);

        // Print or show dialog
        System.out.println("Event Name: " + name);
        System.out.println("Date: " + date);
        System.out.println("Venue: " + venue);
        System.out.println("Type: " + type);
        System.out.println("Capacity: " + capacity);
        System.out.println("Fee: RM" + fee);

        JOptionPane.showMessageDialog(formPanel,
                "Added Event:\n" +
                "Name: " + name + "\n" +
                "Date: " + date + "\n" +
                "Venue: " + venue + "\n" +
                "Type: " + type + "\n" +
                "Capacity: " + capacity + "\n" +
                "Fee: RM" + fee,
                "Event Added",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
