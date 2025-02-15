package quiz_ap;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nameField, countryField;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Signup frame = new Signup();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Signup() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblTitle = new JLabel("SIGN UP");
        lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblTitle.setBounds(180, 10, 100, 21);
        contentPane.add(lblTitle);

        JLabel lblName = new JLabel("NAME");
        lblName.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblName.setBounds(50, 60, 80, 26);
        contentPane.add(lblName);

        JLabel lblPassword = new JLabel("PASSWORD");
        lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblPassword.setBounds(50, 110, 100, 20);
        contentPane.add(lblPassword);

        JLabel lblCountry = new JLabel("COUNTRY");
        lblCountry.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblCountry.setBounds(50, 160, 100, 20);
        contentPane.add(lblCountry);

        nameField = new JTextField();
        nameField.setBounds(150, 65, 200, 25);
        contentPane.add(nameField);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 110, 200, 25);
        contentPane.add(passwordField);

        countryField = new JTextField();
        countryField.setBounds(150, 160, 200, 25);
        contentPane.add(countryField);

        JButton btnSignup = new JButton("SIGN UP");
        btnSignup.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnSignup.setBounds(150, 210, 100, 30);
        btnSignup.setBackground(Color.LIGHT_GRAY);
        contentPane.add(btnSignup);

        btnSignup.addActionListener(e -> registerUser());
    }

    private void registerUser() {
        String name = nameField.getText();
        String password = new String(passwordField.getPassword());
        String country = countryField.getText();

        if (name.isEmpty() || password.isEmpty() || country.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/astrology_quiz", "root", "password")) {
            // Check if name exists in the users table
            String checkQuery = "SELECT * FROM users WHERE name = ?";
            PreparedStatement checkStmt = connection.prepareStatement(checkQuery);
            checkStmt.setString(1, name);
            ResultSet resultSet = checkStmt.executeQuery();

            if (resultSet.next()) {
                JOptionPane.showMessageDialog(this, "Name already exists! Redirecting to Login Page.", "Info", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                Login loginPage = new Login();
                loginPage.setVisible(true);
                return;
            }

            // Insert new user into the users table
            String insertQuery = "INSERT INTO users (name, password, country) VALUES (?, ?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
            insertStmt.setString(1, name);
            insertStmt.setString(2, password);  // Ideally, hash the password before storing
            insertStmt.setString(3, country);
            insertStmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Signup Successful! Redirecting to Login Page.");
            dispose();
            Login loginPage = new Login();
            loginPage.setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
