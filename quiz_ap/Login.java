package quiz_ap;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField usernameField;
    private JPasswordField passwordField;

    private static final String ADMIN_USERNAME = "admin"; // Admin username
    private static final String ADMIN_PASSWORD = "admin"; // Admin password

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Login frame = new Login();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("LOGIN");
        lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblTitle.setBounds(180, 10, 100, 21);
        contentPane.add(lblTitle);

        JLabel lblUsername = new JLabel("USERNAME");
        lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblUsername.setBounds(50, 60, 80, 26);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("PASSWORD");
        lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblPassword.setBounds(50, 110, 100, 20);
        contentPane.add(lblPassword);

        usernameField = new JTextField();
        usernameField.setBackground(Color.LIGHT_GRAY);
        usernameField.setBounds(150, 65, 200, 25);
        contentPane.add(usernameField);
        usernameField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBackground(Color.LIGHT_GRAY);
        passwordField.setBounds(150, 110, 200, 25);
        contentPane.add(passwordField);

        JButton btnSubmit = new JButton("SUBMIT");
        btnSubmit.addActionListener((ActionEvent e) -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter both username and password!");
                return;
            }

            boolean isAdmin = username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD);

            if (isAdmin) {
                JOptionPane.showMessageDialog(null, "Admin Login Successful!");
                dispose();
                HomePage homePage = new HomePage(username, true);
                homePage.setVisible(true);
            } else {
                String loggedInUser = userLogin(username, password);
                if (loggedInUser != null) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    dispose();
                    HomePage homePage = new HomePage(loggedInUser, false);
                    homePage.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnSubmit.setBackground(Color.LIGHT_GRAY);
        btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnSubmit.setBounds(150, 160, 100, 30);
        contentPane.add(btnSubmit);
    }

    private String userLogin(String name, String password) {
        String sql = "SELECT * FROM Users WHERE name = ? AND password = ?";

        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return name;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }
}
