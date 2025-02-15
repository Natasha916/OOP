package quiz_ap;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private String username;
    private boolean isAdmin;
    private JTable highScoresTable;

    public HomePage(String username, boolean isAdmin) {
        this.username = username;
        this.isAdmin = isAdmin;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblWelcome = new JLabel("Welcome, " + username);
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 20));
        lblWelcome.setForeground(Color.WHITE);
        lblWelcome.setBounds(300, 20, 300, 30);
        contentPane.add(lblWelcome);

        if (isAdmin) {
            setupUserInterface();
        } else {
            setupUserInterface();
        }
    }

    private void setupUserInterface() {
        JButton btnPlayQuiz = createButton("Play Quiz", 50, 80);
        btnPlayQuiz.addActionListener(e -> {
            String[] difficultyLevels = {"Beginner", "Intermediate", "Advanced"};
            String selectedDifficulty = (String) JOptionPane.showInputDialog(
                null,
                "Select Difficulty Level",
                "Quiz Difficulty",
                JOptionPane.QUESTION_MESSAGE,
                null,
                difficultyLevels,
                difficultyLevels[0]
            );
            if (selectedDifficulty != null) {
                Game gamePage = new Game(username, selectedDifficulty);
                gamePage.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnPlayQuiz);

        JButton btnViewDetails = createButton("View Player Details", 50, 130);
        btnViewDetails.addActionListener(e -> viewPlayerDetails());
        contentPane.add(btnViewDetails);

        JButton btnViewHighScores = createButton("View High Scores", 50, 180);
        btnViewHighScores.addActionListener(e -> displayHighScores());
        contentPane.add(btnViewHighScores);

        highScoresTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(highScoresTable);
        scrollPane.setBounds(250, 80, 500, 300);
        contentPane.add(scrollPane);
    }

    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBounds(x, y, 180, 40);
        button.setBackground(new Color(70, 70, 70));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    private void viewPlayerDetails() {
        JOptionPane.showMessageDialog(this, "Player Details:\nUsername: " + username, "Player Details", JOptionPane.INFORMATION_MESSAGE);
    }

    private void displayHighScores() {
        List<String[]> highScores = getHighScores();
        String[] columnNames = {"user_id", "Score"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (String[] row : highScores) {
            model.addRow(row);
        }
        highScoresTable.setModel(model);
    }

    private List<String[]> getHighScores() {
        List<String[]> highScores = new ArrayList<>();
        String sql = "SELECT user_id, score FROM scores ORDER BY score DESC LIMIT 10";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/astrology_quiz", "root", "password");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                highScores.add(new String[]{resultSet.getString("user_id"), String.valueOf(resultSet.getInt("score"))});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error retrieving high scores", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return highScores;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        EventQueue.invokeLater(() -> {
            try {
                boolean isAdmin = args.length > 0 && args[0].equals("admin");
                HomePage frame = new HomePage("testUser", isAdmin);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
