package quiz_ap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Game extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private String username;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private List<Question> questions;

    private ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton option1, option2, option3, option4;
    private JLabel lblQuestion, lblProgress;
    private JButton btnNext;

    public Game(String username, String difficulty) {
        this.username = username;
        this.questions = fetchQuestionsFromDatabase(difficulty);

        if (questions.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No questions available for " + difficulty, "Error", JOptionPane.ERROR_MESSAGE);
            dispose();
            return;
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 350);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);
        setContentPane(contentPane);

        lblQuestion = new JLabel();
        lblQuestion.setFont(new Font("Arial", Font.BOLD, 14));
        lblQuestion.setBounds(50, 30, 400, 40);
        contentPane.add(lblQuestion);

        option1 = new JRadioButton();
        option1.setBounds(50, 100, 400, 30);
        option2 = new JRadioButton();
        option2.setBounds(50, 140, 400, 30);
        option3 = new JRadioButton();
        option3.setBounds(50, 180, 400, 30);
        option4 = new JRadioButton();
        option4.setBounds(50, 220, 400, 30);

        buttonGroup.add(option1);
        buttonGroup.add(option2);
        buttonGroup.add(option3);
        buttonGroup.add(option4);

        contentPane.add(option1);
        contentPane.add(option2);
        contentPane.add(option3);
        contentPane.add(option4);

        lblProgress = new JLabel("Question 1 of " + questions.size());
        lblProgress.setFont(new Font("Arial", Font.PLAIN, 14));
        lblProgress.setBounds(50, 260, 200, 30);
        contentPane.add(lblProgress);

        btnNext = new JButton("Next");
        btnNext.setBounds(200, 270, 80, 30);
        btnNext.setEnabled(false); // Disable initially

        btnNext.addActionListener(e -> {
            if (checkAnswer()) {
                score++;
            }
            currentQuestionIndex++;

            if (currentQuestionIndex < questions.size()) {
                displayQuestion();
            } else {
                displayResults();
            }
        });
        contentPane.add(btnNext);

        // Enable "Next" button only when an option is selected
        ActionListener optionListener = e -> btnNext.setEnabled(true);
        option1.addActionListener(optionListener);
        option2.addActionListener(optionListener);
        option3.addActionListener(optionListener);
        option4.addActionListener(optionListener);

        displayQuestion();
    }

    private List<Question> fetchQuestionsFromDatabase(String difficulty) {
        List<Question> questionList = new ArrayList<>();
        String sql = "SELECT * FROM astrology_quiz WHERE LOWER(difficulty) = LOWER(?)";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/astrology_quiz", "root", "password");
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, difficulty);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                questionList.add(new Question(
                    resultSet.getString("question"),
                    resultSet.getString("option_a"),
                    resultSet.getString("option_b"),
                    resultSet.getString("option_c"),
                    resultSet.getString("option_d"),
                    resultSet.getString("correct_answer"),
                    resultSet.getString("difficulty")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching questions from the database", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return questionList;
    }

    private void displayQuestion() {
        buttonGroup.clearSelection();
        btnNext.setEnabled(false); // Re-disable "Next" until an option is selected

        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            lblQuestion.setText(currentQuestion.getQuestionText());
            option1.setText(currentQuestion.getOptionA());
            option2.setText(currentQuestion.getOptionB());
            option3.setText(currentQuestion.getOptionC());
            option4.setText(currentQuestion.getOptionD());

            lblProgress.setText("Question " + (currentQuestionIndex + 1) + " of " + questions.size());

            // Refresh UI
            contentPane.revalidate();
            contentPane.repaint();
        }
    }

    private boolean checkAnswer() {
        String selectedAnswer = "";
        if (option1.isSelected()) selectedAnswer = "A";
        else if (option2.isSelected()) selectedAnswer = "B";
        else if (option3.isSelected()) selectedAnswer = "C";
        else if (option4.isSelected()) selectedAnswer = "D";

        // Get correct answer from the database
        String correctAnswer = questions.get(currentQuestionIndex).getCorrectAnswer().trim();

        // DEBUG: Print values to check if they match
        System.out.println("Selected Answer: [" + selectedAnswer + "]");
        System.out.println("Correct Answer:  [" + correctAnswer + "]");

        boolean isCorrect = selectedAnswer.equalsIgnoreCase(correctAnswer);

        // Debugging Output
        if (isCorrect) {
            System.out.println(" Correct Answer!");
        } else {
            System.out.println("Wrong Answer! Check if database answers are stored as A, B, C, D.");
        }

        return isCorrect;
    }



    private void displayResults() {
        System.out.println("Final Score Before Saving: " + score); // Debugging

        storeScore(); // Store score after game completion

        String message = "Quiz Completed!\n" + username + ", you scored " + score + " out of " + questions.size();
        JOptionPane.showMessageDialog(this, message, "Quiz Over", JOptionPane.INFORMATION_MESSAGE);
        
        dispose();
        
        AdminHomePage adminPage = new AdminHomePage(username);
        adminPage.setVisible(true);
        adminPage.viewReports(); // Force refresh reports
    }

    
    private void storeScore() {
        System.out.println("Saving score for user: " + username + " | Score: " + score); // Debugging

        String sql = "INSERT INTO scores (user_id, score) VALUES (?, ?) ON DUPLICATE KEY UPDATE score = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/astrology_quiz", "root", "password");
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, score);
            preparedStatement.setInt(3, score);  // Update score if user already exists

            int rowsInserted = preparedStatement.executeUpdate();
            
            if (rowsInserted > 0) {
                System.out.println("✅ Score successfully saved for user: " + username + " with score: " + score);
            } else {
                System.out.println("⚠ Score was NOT saved!");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error storing score: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    public static void main(String[] args) {
        String[] difficultyLevels = {"Beginner", "Intermediate", "Advanced"};
        String selectedDifficulty = (String) JOptionPane.showInputDialog(null, "Select Difficulty Level", "Quiz Difficulty", JOptionPane.QUESTION_MESSAGE, null, difficultyLevels, difficultyLevels[0]);

        if (selectedDifficulty != null) {
            EventQueue.invokeLater(() -> {
                try {
                    new Game("testUser", selectedDifficulty).setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
