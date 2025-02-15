package quiz_ap;
class Question {
    private String questionText, optionA, optionB, optionC, optionD, correctAnswer, difficulty;

    public Question(String question, String optionA, String optionB, String optionC, String optionD, String correctAnswer, String difficulty) {
        this.questionText = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
        this.difficulty = difficulty;
    }

    public String getQuestionText() { return questionText; }
    public String getOptionA() { return optionA; }
    public String getOptionB() { return optionB; }
    public String getOptionC() { return optionC; }
    public String getOptionD() { return optionD; }
    public String getCorrectAnswer() { return correctAnswer; }
    public String getDifficulty() { return difficulty; }
}
