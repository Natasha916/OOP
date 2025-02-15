package quiz_ap;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                JFrame frame = new JFrame("Quiz Application");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 300);
                frame.setLayout(new GridLayout(3, 1));

                JLabel lblWelcome = new JLabel("Welcome to Quiz Application", SwingConstants.CENTER);
                lblWelcome.setFont(new Font("Arial", Font.BOLD, 16));
                frame.add(lblWelcome);

                JButton btnAdminLogin = new JButton("Admin");
                btnAdminLogin.addActionListener(e -> {
                    frame.dispose();
                    new AdminHomePage("admin").setVisible(true); // Opens Admin Homepage
                });
                frame.add(btnAdminLogin);

                JButton btnSignup = new JButton("User");
                btnSignup.addActionListener(e -> {
                    frame.dispose();
                    new Signup().setVisible(true); // Opens Signup Page
                });
                frame.add(btnSignup);

                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
