import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.entity.Booking;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class demo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    demo frame = new demo();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public demo() {
        setTitle("WELCOME");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("City");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBounds(171, 11, 450, 29);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("PickUp");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(10, 70, 46, 14);
        contentPane.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(91, 68, 86, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("DropPoint");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_2.setBounds(10, 118, 71, 14);
        contentPane.add(lblNewLabel_2);

        textField_1 = new JTextField();
        textField_1.setBounds(91, 116, 86, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Price");
        lblNewLabel_3.setBounds(222, 205, 52, 14);
        contentPane.add(lblNewLabel_3);

        JButton button = new JButton("Submit");
        button.setBounds(200, 230, 89, 23);
        contentPane.add(button);

        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setBounds(127, 180, 249, 14);
        contentPane.add(lblNewLabel_5);

        // Add ActionListener to the submit button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pickupId = textField.getText();
                String dropId = textField_1.getText();

                // Create a Booking object with pickup and dropPoint values
                Booking booking = new Booking(pickupId, dropId);

                // Perform booking logic here
                double price = calculatePrice(booking);
                lblNewLabel_5.setText("Price: " + price);
            }

            private double  calculatePrice(Booking booking) {
                double base = 100;
				return base;
            }
        }); 
    }
}