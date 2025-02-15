package quiz_ap;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import javax.swing.table.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class AdminHomePage extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JButton btnAddQuestion, btnDeleteQuestion, btnUpdateQuestion, btnViewReports;
    private String adminUsername;

    public AdminHomePage(String username) {
        this.adminUsername = username;
        setTitle("Admin Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(40, 40, 40));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblTitle = new JLabel("ADMIN DASHBOARD");
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 24));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBounds(300, 10, 300, 30);
        contentPane.add(lblTitle);

        // Buttons for Admin actions
        btnAddQuestion = createStyledButton("➕ Add Question", 20, 60);
        btnAddQuestion.addActionListener(e -> openAddQuestionDialog());
        contentPane.add(btnAddQuestion);

        btnDeleteQuestion = createStyledButton("❌ Delete Question", 20, 110);
        btnDeleteQuestion.addActionListener(e -> openDeleteQuestionDialog());
        contentPane.add(btnDeleteQuestion);

        btnUpdateQuestion = createStyledButton("✏ Update Question", 20, 160);
        btnUpdateQuestion.addActionListener(e -> openUpdateQuestionDialog());
        contentPane.add(btnUpdateQuestion);

        btnViewReports = createStyledButton("📊 View Reports", 20, 210);
        btnViewReports.addActionListener(e -> viewReports());
        contentPane.add(btnViewReports);

        // Table for viewing reports
        table = new JTable();
        styleTable(table);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(220, 60, 550, 350);
        scrollPane.getViewport().setBackground(Color.LIGHT_GRAY);
        contentPane.add(scrollPane);
    }

    // Method to create a custom styled button
    private JButton createStyledButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setBounds(x, y, 180, 40);
        button.setBackground(new Color(70, 130, 180)); // Steel Blue
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setOpaque(true);
        button.setBorderPainted(false);

    
        // Hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(100, 149, 237)); // Lighter blue
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(70, 130, 180)); // Normal blue
            }
        });

        return button;
    }

    // Method to style the table
    private void styleTable(JTable table) {
        table.setBackground(Color.LIGHT_GRAY);
        table.setFont(new Font("SansSerif", Font.PLAIN, 14));
        table.setRowHeight(25);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("SansSerif", Font.BOLD, 14));
        header.setBackground(new Color(70, 130, 180));
        header.setForeground(Color.WHITE);
    }

    // Method to add a new question
    private void openAddQuestionDialog() {
        String[] difficultyLevels = {"Beginner", "Intermediate", "Advanced"};
        String selectedDifficulty = (String) JOptionPane.showInputDialog(
            this, 
            "Select Difficulty Level:", 
            "Question Difficulty", 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            difficultyLevels, 
            difficultyLevels[0]
        );

        if (selectedDifficulty == null) {
            return; // If no difficulty is selected, exit
        }

        String question = JOptionPane.showInputDialog(this, "Enter the question:");
        String optionA = JOptionPane.showInputDialog(this, "Enter option A:");
        String optionB = JOptionPane.showInputDialog(this, "Enter option B:");
        String optionC = JOptionPane.showInputDialog(this, "Enter option C:");
        String optionD = JOptionPane.showInputDialog(this, "Enter option D:");
        String correctAnswer = JOptionPane.showInputDialog(this, "Enter correct answer:");

        if (question != null && optionA != null && optionB != null && optionC != null && optionD != null && correctAnswer != null) {
            String sql = "INSERT INTO astrology_quiz (question, option_a, option_b, option_c, option_d, correct_answer, difficulty) VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/astrology_quiz", "root", "password");
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setString(1, question);
                preparedStatement.setString(2, optionA);
                preparedStatement.setString(3, optionB);
                preparedStatement.setString(4, optionC);
                preparedStatement.setString(5, optionD);
                preparedStatement.setString(6, correctAnswer);
                preparedStatement.setString(7, selectedDifficulty); // Add selected difficulty level

                int result = preparedStatement.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Question Added Successfully to " + selectedDifficulty + " Level!");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error adding question: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    // Method to delete a question
    private void openDeleteQuestionDialog() {
        String questionId = JOptionPane.showInputDialog(this, "Enter the Question ID to delete:");

        if (questionId != null) {
            String sql = "DELETE FROM astrology_quiz WHERE id = ?"; // Use actual column name

            try (Connection connection = DatabaseConnector.connect();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setInt(1, Integer.parseInt(questionId));

                int result = preparedStatement.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Question Deleted Successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "Question ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error deleting question: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Method to update a question
    private void openUpdateQuestionDialog() {
        String questionId = JOptionPane.showInputDialog(this, "Enter the Question ID to update:");

        if (questionId != null) {
            String sql = "SELECT * FROM astrology_quiz WHERE id = ?";

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/astrology_quiz", "root", "password");
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setInt(1, Integer.parseInt(questionId));

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String question = resultSet.getString("question");
                        String optionA = resultSet.getString("option_a");
                        String optionB = resultSet.getString("option_b");
                        String optionC = resultSet.getString("option_c");
                        String optionD = resultSet.getString("option_d");
                        String correctAnswer = resultSet.getString("correct_answer");

                        question = JOptionPane.showInputDialog(this, "Edit question:", question);
                        optionA = JOptionPane.showInputDialog(this, "Edit option A:", optionA);
                        optionB = JOptionPane.showInputDialog(this, "Edit option B:", optionB);
                        optionC = JOptionPane.showInputDialog(this, "Edit option C:", optionC);
                        optionD = JOptionPane.showInputDialog(this, "Edit option D:", optionD);
                        correctAnswer = JOptionPane.showInputDialog(this, "Edit correct answer:", correctAnswer);

                        String updateSql = "UPDATE astrology_quiz SET question = ?, option_a = ?, option_b = ?, option_c = ?, option_d = ?, correct_answer = ? WHERE id = ?";

                        try (PreparedStatement updateStmt = connection.prepareStatement(updateSql)) {
                            updateStmt.setString(1, question);
                            updateStmt.setString(2, optionA);
                            updateStmt.setString(3, optionB);
                            updateStmt.setString(4, optionC);
                            updateStmt.setString(5, optionD);
                            updateStmt.setString(6, correctAnswer);
                            updateStmt.setInt(7, Integer.parseInt(questionId));

                            int result = updateStmt.executeUpdate();
                            if (result > 0) {
                                JOptionPane.showMessageDialog(this, "Question Updated Successfully!");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Question ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error fetching question: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

   
    void viewReports() {
        String sql = "SELECT user_id, score FROM scores ORDER BY score DESC";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/astrology_quiz", "root", "password");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            DefaultTableModel model = new DefaultTableModel(new String[]{"user_id", "score"}, 0);
            
            while (resultSet.next()) {
                model.addRow(new Object[]{resultSet.getString("user_id"), resultSet.getInt("score")});
            }
            
            table.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error retrieving reports: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    // Main method for running independently (for testing)
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                AdminHomePage frame = new AdminHomePage("admin"); // Use any username for testing
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
