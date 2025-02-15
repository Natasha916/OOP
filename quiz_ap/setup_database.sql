-- MySQL Database Setup for Quiz Application

CREATE DATABASE IF NOT EXISTS astrology_quiz;
USE astrology_quiz;

-- Users Table (Stores User Credentials)
CREATE TABLE IF NOT EXISTS Users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    country VARCHAR(50) NOT NULL
);

-- Questions Table (Stores Quiz Questions)
CREATE TABLE IF NOT EXISTS Questions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    question TEXT NOT NULL,
    optionA VARCHAR(255) NOT NULL,
    optionB VARCHAR(255) NOT NULL,
    optionC VARCHAR(255) NOT NULL,
    optionD VARCHAR(255) NOT NULL,
    correctAnswer VARCHAR(255) NOT NULL,
    difficulty ENUM('Beginner', 'Intermediate', 'Advanced') NOT NULL
);

-- Scores Table (Tracks User Scores)
CREATE TABLE IF NOT EXISTS Scores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    score INT NOT NULL,
    FOREIGN KEY (username) REFERENCES Users(username) ON DELETE CASCADE
);

-- Sample Questions Insertion
INSERT INTO Questions (question, optionA, optionB, optionC, optionD, correctAnswer, difficulty) VALUES
('What is the first sign of the zodiac?', 'Taurus', 'Leo', 'Aries', 'Gemini', 'Aries', 'Beginner'),
('How many zodiac signs are there in Western astrology?', '10', '12', '9', '14', '12', 'Beginner'),
('Which zodiac sign is represented by the bull?', 'Capricorn', 'Taurus', 'Virgo', 'Scorpio', 'Taurus', 'Beginner'),
('What element is associated with Cancer, Scorpio, and Pisces?', 'Fire', 'Water', 'Earth', 'Air', 'Water', 'Beginner'),
('Which planet is known as the ruler of Leo?', 'Saturn', 'Venus', 'Mars', 'Sun', 'Sun', 'Beginner');
