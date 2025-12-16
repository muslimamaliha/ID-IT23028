# Project Name: QuizApp

## Features
1. User registration & login
2. 10 Java programming questions
3. 15-second timer per question
4. Automatic answer submission
4. Instant scoring system
5. Leaderboard ranking
6. MySQL database storage
7. Cross-platform (Windows, macOS, Linux)

## Technology Used
1. Java (JDK 21) - Core language
2. JavaFX 21.0.8 - GUI framework
3. MySQL 8.0 - Database
4. JDBC - Database connectivity
5. Maven - Build tool

## Database
### 1. Database Setup
```sql
-- Create database
CREATE DATABASE quiz_app;

-- Use the database
USE quiz_app;

-- Create users table
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create scores table
CREATE TABLE scores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    user_email VARCHAR(100),
    correct_score INT DEFAULT 0,
    wrong_score INT DEFAULT 0,
    total_score INT GENERATED ALWAYS AS (correct_score - wrong_score) STORED,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
```
### 2. Configure Database Connection
#### DBConnection.java:
```java
private static final String URL = "jdbc:mysql://localhost:3306/quiz_app";
private static final String USER = "your_mysql_username";
private static final String PASSWORD = "your_mysql_password";
```

## Project Structure
![Project Structure](https://github.com/muslimamaliha/ID-IT23028/blob/main/images/project_structure.png)

## Application Workflow
Welcome Screen → Start application

Login Screen → Enter name & email

Rules Screen → Read instructions

Quiz Screen → Answer 10 questions (15 sec each)

Score Screen → View results

Leaderboard → See rankings

## Preview
### Welcome Screen
![Welcome Screen](https://github.com/muslimamaliha/ID-IT23028/blob/main/images/welcome_screen.png)
### Login Screen
![Login Screen](https://github.com/muslimamaliha/ID-IT23028/blob/main/images/login_screen.png)
### Quiz Screen
![Quiz Screen](https://github.com/muslimamaliha/ID-IT23028/blob/main/images/quiz_screen.jpg)
### Leaderboard Screen
![Leaderboard Screen](https://github.com/muslimamaliha/ID-IT23028/blob/main/images/leaderboard_screen.png)

## Future Enhancements
1. Add multiple quiz categories (Python, C++, Database)
2. Implement admin panel for question management
3. Develop mobile application version
4. Add network multiplayer mode
5. Include difficulty levels (Easy, Medium, Hard)
6. Implement PDF report generation
7. Add multimedia questions (images, code snippets)

## License
This project is for educational purposes.

## Contact
Developer: Muslima Jahan Maliha

Student ID: IT23028

Email: it23028@mbstu.ac.bd

University: Mawlana Bhashani Science and Technology University

Department: Information and Communication Technology (ICT)

## Repository Links
https://github.com/muslimamaliha/ID-IT23028

