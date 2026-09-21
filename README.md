# Student Record Management System

A console-based Java application that performs full CRUD (Create, Read, Update, Delete) operations on student records, backed by a MySQL database.

## Features
- Add a new student record
- View all student records
- Update an existing student's details
- Delete a student record
- Simple interactive menu-driven interface

## Tech Stack
- **Java** — core application logic
- **MySQL** — persistent data storage
- **JDBC (MySQL Connector/J)** — bridges Java and MySQL

## Project Structure
- `Student.java` — represents a single student record
- `DBConnection.java` — manages the connection to the MySQL database
- `StudentDAO.java` — handles all database operations (Create, Read, Update, Delete)
- `Main.java` — runs the interactive console menu

## Database Schema
```sql
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    roll_number VARCHAR(20) UNIQUE NOT NULL,
    department VARCHAR(50),
    semester INT,
    marks DOUBLE
);
```

## How to Run
1. Install MySQL and create a database named `student_db`, then run the schema above.
2. Download [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/) and add it to your project's classpath.
3. In `DBConnection.java`, set your own MySQL username and password.
4. Compile and run `Main.java`.

## What I Learned
This project was my introduction to connecting Java applications to a relational database using JDBC — including writing safe parameterized queries with `PreparedStatement`, handling result sets, and structuring a small application using the DAO (Data Access Object) pattern.
