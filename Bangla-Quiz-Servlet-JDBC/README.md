
# Bangla Quiz using Servlet + JDBC

## Topic: Arithmetic (High School)

## Database
CREATE DATABASE quizdb;
CREATE TABLE student(sl INT AUTO_INCREMENT PRIMARY KEY, student_id VARCHAR(20));
CREATE TABLE score(sl INT AUTO_INCREMENT PRIMARY KEY, student_id VARCHAR(20), score INT);

## Run
Deploy on Tomcat 9 and open:
http://localhost:8080/Bangla-Quiz-Servlet-JDBC/index.html
