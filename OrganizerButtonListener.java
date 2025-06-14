// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class OrganizerButtonListener implements ActionListener {
//     private JFrame frame;

//     public OrganizerButtonListener(JFrame frame) {
//         this.frame = frame;
//     }

//     @Override
//     public void actionPerformed(ActionEvent e) {
//         frame.setSize(800, 500); // Resize to organizer screen
//         frame.getContentPane().removeAll();  // Properly clears content
//         frame.getContentPane().setLayout(new BorderLayout());

//         OrganizerPanel organizerPanel = new OrganizerPanel(frame);
//         frame.getContentPane().add(organizerPanel, BorderLayout.CENTER);

//         frame.revalidate();
//         frame.repaint();
//     }
// }